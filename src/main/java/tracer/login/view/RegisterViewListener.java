package tracer.login.view;

public interface RegisterViewListener {

    public void attemptRegister(String username, String password, String retype, String firstname, String lastname);

    public void goToLogin();
}
