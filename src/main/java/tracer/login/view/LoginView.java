package tracer.login.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginView {
    private JPanel panelMain;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton buttonLogin;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JButton buttonRegister;
    private JLabel labelPanel;


    private ArrayList<LoginViewListener> listeners;

    public JPanel getPanel() {
        return panelMain;
    }

    public void addListener(LoginViewListener listener) {
        listeners.add(listener);
    }

    public LoginView() {

        listeners = new ArrayList<LoginViewListener>();

        // Attempt Login
        buttonLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                for (LoginViewListener listener : listeners) {
                    listener.attemptLogin(textUsername.getText(), textPassword.getText());
                }

            }
        });

        // Navigate to Register View
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (LoginViewListener listener : listeners) {
                    listener.goToRegister();
                }
            }
        });
    }
}
