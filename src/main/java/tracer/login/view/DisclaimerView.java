package tracer.login.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisclaimerView {
    private JPanel panelMain;
    private JTextArea textDisclaimer;
    private JLabel labelPanel;
    private JCheckBox checkBoxAgree;
    private JButton buttonStart;

    private ArrayList<DisclaimerViewListener> listeners;

    public void addListener(DisclaimerViewListener listener) {
        listeners.add(listener);
    }

    public JPanel getPanel() {
        return panelMain;
    }

    public DisclaimerView() {

        listeners = new ArrayList<DisclaimerViewListener>();

        buttonStart.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (checkBoxAgree.isSelected()) {

                    for (DisclaimerViewListener listener : listeners) {
                        listener.termsAccepted();
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "You Must Agree to the Terms of Service");
                }

            }
        });
    }
}
