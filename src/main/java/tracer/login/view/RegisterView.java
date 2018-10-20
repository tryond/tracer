package tracer.login.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterView {
    private JPanel panelMain;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JPasswordField textRePassword;
    private JTextField textFistName;
    private JTextField textLastName;
    private JButton buttonRegister;
    private JButton buttonLogin;
    private JLabel labelPanel;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelRePassword;
    private JLabel labelFirstName;
    private JLabel labelLastName;

    // Change to array list of LoginViewListener
    private ArrayList<RegisterViewListener> listeners;

    public void addListener(RegisterViewListener listener) {
        listeners.add(listener);
    }

    public JPanel getPanel() {
        return panelMain;
    }

    public RegisterView() {

        listeners = new ArrayList<RegisterViewListener>();

        // Attempt to Register
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (RegisterViewListener listener : listeners) {
                    listener.attemptRegister(
                            textUsername.getText(),
                            textPassword.getText(),
                            textRePassword.getText(),
                            textFistName.getText(),
                            textLastName.getText()
                    );
                }

            }
        });

        // Go to Login View
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (RegisterViewListener listener : listeners) {
                    listener.goToLogin();
                }

            }
        });
    }




}
