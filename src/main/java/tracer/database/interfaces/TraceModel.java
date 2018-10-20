package tracer.database.interfaces;

import tracer.database.exceptions.LogEntryException;

public interface TraceModel {

    public void logEntry(String table, String[] values) throws LogEntryException;

}
