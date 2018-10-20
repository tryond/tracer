package tracer.login.view;

import tracer.cursor.MouseTypeView;

import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame;

    public LoginView loginView;
    public RegisterView registerView;
    public DisclaimerView disclaimerView;

    public View() {

        // TODO: this is a test
        frame = new JFrame("Mouse Logger 1.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        loginView = new LoginView();
        registerView = new RegisterView();
        disclaimerView = new DisclaimerView();
    }

    public void displayLogin() {
        System.out.println("Display Login");

        frame.setContentPane(loginView.getPanel());
        refresh();
    }

    public void displayRegister() {
        System.out.println("Display Register");

        frame.setContentPane(registerView.getPanel());
        refresh();
    }

    public void displayDisclaimer() {
        System.out.println("Display Disclaimer");

        frame.setContentPane(disclaimerView.getPanel());
        refresh();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void minimizeFrame() {
        frame.setState(Frame.ICONIFIED);
    }

    public void closeFrame()
    {
        frame.setVisible(false);
    }

    private void refresh() {
        frame.validate();
        frame.pack();
        frame.setVisible(true);
    }


}
