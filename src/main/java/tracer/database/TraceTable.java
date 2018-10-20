package tracer.database;

import tracer.database.exceptions.LogEntryException;
import tracer.database.interfaces.TraceModel;

import java.sql.SQLException;

public class TraceTable implements TraceModel {

    private String usersTable = "users";
    private String[] usersTableFields = {"username", "password", "first_name", "last_name"};
    private String[] usersTableFieldsPartial = {"username", "password"};

    private String strokesTable = "strokes";
    private String[] strokesTableFields = {"username", "direction", "points", "id"};

    private Database database = null;

    public TraceTable(Database db) {
        database = db;
    }

    public void logEntry(String table, String[] values) throws LogEntryException {
        try {
            database.insertIntoTable(table, values);
        }
        catch (SQLException ex) {
            LogEntryException.throwLogFailedException();
        }
    }
}
