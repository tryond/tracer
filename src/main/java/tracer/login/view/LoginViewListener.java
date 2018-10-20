package tracer.login.view;

public interface LoginViewListener {

    public void attemptLogin(String username, String password);

    public void goToRegister();

}
