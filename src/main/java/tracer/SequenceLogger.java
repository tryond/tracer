package tracer;

import tracer.cursor.CursorSelectController;
import tracer.cursor.interfaces.CursorSelectListener;
import tracer.database.UserTable;
import tracer.database.Database;
import tracer.database.ElephantDatabase;
import tracer.database.interfaces.UserModel;
import tracer.login.LoginController;
import tracer.login.interfaces.LoginListener;
import tracer.login.view.View;

import javax.swing.*;

public class SequenceLogger implements LoginListener, CursorSelectListener
{
    private String username;
    private String cursor_type;

    private Database database;
    private UserModel userModel;

    private View view;
    private LoginController login;

    private CursorSelectController cursorSelector;

    public SequenceLogger()
    {
        // Create database for login and trace logging
        database = new ElephantDatabase();

        // User table within database for use with login
        userModel = new UserTable(database);

        // Login controller for use with acquiring valid username
        // TODO: import login controller


        view = new View();
        login = new LoginController(userModel, view);

        login.addListener(this);


        // Cursor selector for use with selecting a valid cursor type
        // TODO: import cursor selector
         cursorSelector = new CursorSelectController();
         cursorSelector.addListener(this);

        // Trace table within database for use with trace logging
        // TODO: create trace model
        // TraceModel traceModel = new DBTraceModel(database);



    }




    public void go()
    {
        login.go();
    }

    public void userLoggedIn(String username)
    {
        this.username = username;

        System.out.println("Sequence Logger: " + "User Logged In: " + this.username);

        cursorSelector.go();
    }

    public void cursorTypeSelected(String cursor_type)
    {
        this.cursor_type = cursor_type;

        System.out.println("Sequence Logger: " + "Cursor Type Selected: " + this.cursor_type);

        // Start sequence tracker
    }
}
