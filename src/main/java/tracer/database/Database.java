package tracer.database;

import java.sql.*;

import static java.lang.System.exit;

public class Database {

    private Connection connection = null;
    private Statement statement = null;

    public Statement getStatement() {
        return statement;
    }

    public Database(String url, String database, String username, String password) {

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        connection.close();
                        System.out.println("Connection closed");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        exit(1);
                    }
                }
            });
        }
        catch (Exception ex) {
            System.err.println("There was an error connecting to the database.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
    }

    public void insertIntoTable(String table, String[] colValues) throws SQLException {

        StringBuilder sb = new StringBuilder();

        // Build SQL INSERT statement
        sb.append("INSERT INTO " + table + " VALUES (");
        for (int i = 0; i < colValues.length-1; ++i) {

            if (colValues[i].equals("default")) {
                sb.append(colValues[i] + ",");
            }
            else {
                sb.append("'" + colValues[i] + "',");
            }
        }

        if (colValues[colValues.length-1].equals("default")) {
            sb.append(colValues[colValues.length-1] + ");");
        }
        else {
            sb.append("'" + colValues[colValues.length-1] + "');");
        }

        // sb.append("'" + colValues[colValues.length-1] + "');");

        // TODO
        System.out.println(sb.toString());

        statement.executeUpdate(sb.toString()); // can throw SQLException
    }

    public boolean existsInTable(String table, String[] colNames, String[] colValues) throws SQLException {

        StringBuilder sb = new StringBuilder();

        // Build SQL INSERT statement
        sb.append("SELECT EXISTS (");
        sb.append("SELECT 1 FROM " + table + " WHERE ");
        for (int i = 0; i < colNames.length-1; ++i) sb.append(colNames[i] + "='" + colValues[i] + "' AND ");
        sb.append(colNames[colNames.length-1] + "='" + colValues[colValues.length-1] + "');");

        // TODO
        System.out.println(sb.toString());

        ResultSet rs = statement.executeQuery(sb.toString());
        return rs.next() && rs.getBoolean(1);

    }

    public ResultSet getFromTable(String table, String[] colNames, String[] colValues) throws SQLException {

        if (colNames.length != colValues.length) {
            throw new SQLException("Number of column names and values don't match.");
        }

        StringBuilder query = new StringBuilder();

        query.append("select * from " + table);

        if (colNames.length > 0) {
            query.append(" where ");

            // for all but the last column
            for (int i = 0; i < colNames.length - 1; ++i) {
                query.append(colNames[i] + " = '" + colValues[i] + "' " + "AND ");
            }

            // append the last column name and value pair
            query.append(colNames[colNames.length-1] + " = '" + colValues[colValues.length-1] + "' ");
        }

        query.append(";");

        return statement.executeQuery(query.toString());

    }

}

