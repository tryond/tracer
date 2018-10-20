package tracer.database.exceptions;

public class LoginException extends Exception {

    public LoginException(String msg) {
        super(msg);
    }

    public static void throwUsernameNotFoundException() throws LoginException {
        LoginException ex = new LoginException("Username not found");
        throw ex;
    }

    public static void throwPasswordIncorrectException() throws LoginException {
        LoginException ex = new LoginException("Password does not match");
        throw ex;
    }

    public static void throwLoginFailedException() throws LoginException {
        LoginException ex = new LoginException("Login failed");
        throw ex;
    }
}
