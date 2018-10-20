package tracer.database.exceptions;

public class RegistrationException extends Exception {

    public RegistrationException(String msg) {
        super(msg);
    }

    public static void throwPasswordMismatchException() throws RegistrationException {
        RegistrationException ex = new RegistrationException("Passwords do not match");
        throw ex;
    }

    public static void throwUsernameTakenException() throws RegistrationException {
        RegistrationException ex = new RegistrationException("Username already taken");
        throw ex;
    }

    public static void throwRegistrationFailedException() throws RegistrationException {
        RegistrationException ex = new RegistrationException("Registration failed");
        throw ex;
    }
}
