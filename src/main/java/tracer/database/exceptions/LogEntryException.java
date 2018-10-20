package tracer.database.exceptions;

public class LogEntryException extends Exception {

    public LogEntryException(String msg) {
        super(msg);
    }

    public static void throwUsernameNotFoundException() throws LogEntryException {
        LogEntryException ex = new LogEntryException("Username not found");
        throw ex;
    }

    public static void throwLogFailedException() throws LogEntryException {
        LogEntryException ex = new LogEntryException("Entry failed to log");
        throw ex;
    }
}
