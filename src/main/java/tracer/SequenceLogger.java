package tracer;

import com.sun.deploy.trace.Trace;
import tracer.cursor.CursorSelectController;
import tracer.cursor.interfaces.CursorSelectListener;
import tracer.database.TraceTable;
import tracer.database.UserTable;
import tracer.database.Database;
import tracer.database.ElephantDatabase;
import tracer.database.exceptions.LogEntryException;
import tracer.database.interfaces.TraceModel;
import tracer.database.interfaces.UserModel;
import tracer.login.LoginController;
import tracer.login.interfaces.LoginListener;
import tracer.login.view.View;
import tracer.sequence.TraceFormatter;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.awt.*;
import java.util.Date;
import java.util.Random;

public class SequenceLogger implements LoginListener, CursorSelectListener
{
    private String username;
    private String cursor_type;

    private Database database;
    private UserModel userModel;

    private LoginController login;
    private CursorSelectController cursorSelector;

    private TraceTable traceTable;


    public SequenceLogger()
    {
        // Create database for login and trace logging
        database = new ElephantDatabase();

        // User table within database for use with login
        userModel = new UserTable(database);

        // Login controller for use with acquiring valid username
        login = new LoginController(userModel);
        login.addListener(this);

        // Cursor selector for use with selecting a valid cursor type
         cursorSelector = new CursorSelectController();
         cursorSelector.addListener(this);

        // Trace table within database for use with trace logging
        traceTable = new TraceTable(database);



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

//        ArrayList<Point> pointArrayList = new ArrayList<Point>();
//        ArrayList<Integer> timesMS = new ArrayList<Integer>();
//
//        Random rng = new Random();
//
//        for (int i = 0; i < 100; ++i)
//        {
//            pointArrayList.add(new Point(rng.nextInt(100), rng.nextInt(100)));
//            timesMS.add(rng.nextInt(10));
//        }
//
//        System.out.println("num points before norm: " + pointArrayList.size());
//
//        // TODO: test
//        pointArrayList = TraceFormatter.normalizeTime(pointArrayList, timesMS, 0.01);
//
//        System.out.println("num points after norm: " + pointArrayList.size());
//
//
//        String pointString = TraceFormatter.getPoints(pointArrayList);
//
//        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = dateFormat.format(date);
//
//        String[] traceValues = new String[] {
//                username,
//                "default",
//                dateString,
//                pointString,
//                "5x5x0000",
//                "10",
//                "11",
//                "0",
//                cursor_type,
//                "0.01"
//        };
//        try {
//            traceTable.logTrace(traceValues);
//
//            traceTable.logTrace(
//                    username,
//                    pointArrayList,
//                    "5x9x1093",
//                    66,
//                    99,
//                    100,
//                    cursor_type,
//                    0.09
//            );
//
//        }
//        catch (LogEntryException ex) {
//            ex.printStackTrace();
//        }
//
//    }
}
