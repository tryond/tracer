package tracer.database;

import tracer.database.exceptions.LoginException;
import tracer.database.exceptions.RegistrationException;
import tracer.database.interfaces.UserModel;

import java.sql.SQLException;

public class UserTable implements UserModel {

    private String usersTable = "users";
    private String[] usersTableFields = {"username", "password", "first_name", "last_name"};
    private String[] usersTableFieldsPartial = {"username", "password"};

    private String strokesTable = "strokes";
    private String[] strokesTableFields = {"username", "direction", "points", "id"};

    private Database database = null;

    public UserTable(Database db) {
        database = db;
    }

    public void register(String username, String password, String retype, String firstname, String lastname)  throws RegistrationException {

        try {
            // Check for password mismatch
            if (!password.equals(retype)) {
                RegistrationException.throwPasswordMismatchException();
            }

            // Check for existing username
            if (database.existsInTable(usersTable, new String[]{"username"}, new String[]{username})) {
                RegistrationException.throwUsernameTakenException();
            }

            // Create new user
            database.insertIntoTable(usersTable, new String[]{username, password, firstname, lastname});

            // Check that user was registered successfully
            if (!database.existsInTable(usersTable, usersTableFields, new String[]{username, password, firstname, lastname})) {
                RegistrationException.throwRegistrationFailedException();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();

            // Registration failed
            RegistrationException.throwRegistrationFailedException();
        }
    }

    public void login(String username, String password) throws LoginException {

        try {

            // Check for username
            if (!database.existsInTable(usersTable, new String[]{"username"}, new String[]{username})) {
                LoginException.throwUsernameNotFoundException();
            }

            // Check for username and password
            if (!database.existsInTable(usersTable, usersTableFieldsPartial, new String[]{username, password})) {
                LoginException.throwPasswordIncorrectException();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();

            // Login falied
            LoginException.throwLoginFailedException();
        }
    }
}
