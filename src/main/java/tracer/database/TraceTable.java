package tracer.database;

import tracer.database.exceptions.LogEntryException;
import tracer.database.interfaces.TraceModel;
import tracer.sequence.TraceFormatter;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.awt.*;

public class TraceTable implements TraceModel {

    private String tracesTable = "traces";

    private String[] tracesTableFields = {
            "username",
            "id",
            "date",
            "points",
            "sequence_id",
            "position",
            "round",
            "attempt",
            "cursor_type",
            "poll_rate"
    };

    private Database database = null;

    public TraceTable(Database db) {
        database = db;
    }

    public void logEntry(String table, String[] values) throws LogEntryException
    {
        try {
            database.insertIntoTable(table, values);
        }
        catch (SQLException ex) {
            LogEntryException.throwLogFailedException();
        }
    }

    public void logTrace(String[] values) throws LogEntryException
    {
        try {
            database.insertIntoTable(tracesTable, values);
        }
        catch (SQLException ex) {
            LogEntryException.throwLogFailedException();
        }
    }

    public void logTrace(
            String username,
            ArrayList<Point> points,
            String sequence_id,
            int position,
            int round,
            int attempt,
            String cursor_type,
            double poll_rate
    ) throws LogEntryException
    {

        String pointString = TraceFormatter.getPoints(points);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);

        String[] values = new String[] {
                username,
                "default",
                dateString,
                pointString,
                sequence_id,
                Integer.toString(position),
                Integer.toString(round),
                Integer.toString(attempt),
                cursor_type,
                Double.toString(poll_rate)
        };

        try {
            database.insertIntoTable(tracesTable, values);
        }
        catch (SQLException ex) {
            LogEntryException.throwLogFailedException();
        }
    }
}
