package tracer.database;

public class ElephantDatabase extends Database {

    static final String url = "jdbc:postgresql://pellefant.db.elephantsql.com:5432/xqicwdtc";
    static final String databaseName = "postgres";
    static final String username = "xqicwdtc";
    static final String password = "Wx9dCpXi9kFp29GogCEiAl6CVb1PKu9j";

    public ElephantDatabase() {
        super(url, databaseName, username, password);
    }
}
