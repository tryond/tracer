package tracer;

import tracer.database.UserTable;
import tracer.database.Database;
import tracer.database.ElephantDatabase;
import tracer.database.interfaces.UserModel;

public class SequenceLogger
{


    private String username;
    private String cursor_type;

    private Database database;
    private UserModel userModel;


    public SequenceLogger()
    {
        // Create database for login and trace logging
        database = new ElephantDatabase();

        // User table within database for use with login
        userModel = new UserTable(database);

        // Login controller for use with acquiring valid username
        // TODO: import login controller
        // LoginController login = new LoginController(userModel);

        // Cursor selector for use with selecting a valid cursor type
        // TODO: import cursor selector
        // CursorSelector cursorSelector = new CursorSelector();

        // Trace table within database for use with trace logging
        // TODO: create trace model
        // TraceModel traceModel = new DBTraceModel(database);



    }


    public void go()
    {

        // 1. Login / Register username

        // 2. Get cursor type

        // 3. Start sequence tracking

        // 4. Format sequence

        // 5. Send to database

        // 6. Display results

        // 7. Reset to step 3

    }

    public void loggedIn(String username)
    {

    }

    public void cursorTypeSelected(String cursor_type)
    {

    }


    public void sequenceOver()
    {

    }

}
