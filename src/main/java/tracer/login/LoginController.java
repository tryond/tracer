package tracer.login;



import tracer.database.exceptions.LoginException;
import tracer.database.exceptions.RegistrationException;
import tracer.database.interfaces.UserModel;
import tracer.login.interfaces.LoginListener;
import tracer.login.view.*;

import java.util.ArrayList;

import static java.lang.System.exit;

public class LoginController implements LoginViewListener, RegisterViewListener, DisclaimerViewListener
{

    private String username;                // which user to track

    private View view;                      // controls visual components
    private UserModel model;                // stores information

    private ArrayList<LoginListener> listeners;

    public LoginController(UserModel model)
    {

        this.model = model;

        this.view = new View();

        listeners = new ArrayList<LoginListener>();

        view.loginView.addListener(this);
        view.registerView.addListener(this);
        view.disclaimerView.addListener(this);
    }

    public void addListener(LoginListener listener)
    {
        listeners.add(listener);
    }

    // Begin GUI
    public void go() {
        view.displayLogin();
    }

    // Attempt to Login through model
    public void attemptLogin(String username, String password) {
        try {
            model.login(username, password);

            // Set username for the remainder of the program
            this.username = username;

            loginSuccess();
        }
        catch (LoginException ex) {

            view.showMessage(ex.toString());
            ex.printStackTrace();
        }
    }

    // Attempt to Register through model
    public void attemptRegister(String username, String password, String retype, String firstname, String lastname) {
        try {
            model.register(username, password, retype, firstname, lastname);

            // Set username for the remainder of the program
            this.username = username;

            // Disclaimer
            goToDisclaimer();

        }
        catch (RegistrationException ex) {

            view.showMessage(ex.toString());
            ex.printStackTrace();
        }
    }

    // Navigate to Login Screen
    public void goToLogin() {
        view.displayLogin();
    }

    // Navigate to Register Screen
    public void goToRegister() {
        view.displayRegister();
    }

    // Navigate to Disclaimer Screen
    public void goToDisclaimer() {
        view.displayDisclaimer();
    }

    public void termsAccepted() {
        loginSuccess();
    }

    public void loginSuccess()
    {
        for (LoginListener listener : listeners) {
            listener.userLoggedIn(this.username);
        }

        view.closeFrame();
    }

    // Close the Application
    public void close() {
        exit(0);
    }
}
