package tracer.cursor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MouseTypeView {
    private JPanel panelMain;
    private JRadioButton mouseRadioButton;
    private JRadioButton trackpadRadioButton;
    private JButton startButton;

    boolean mouseSelected = true;
    boolean trackpadSelected = false;

    private ArrayList<MouseTypeViewListener> listeners;

    public JPanel getPanel() {
        return panelMain;
    }

    public void addListener(MouseTypeViewListener listener) {
        listeners.add(listener);
    }

    public MouseTypeView() {

        listeners = new ArrayList<MouseTypeViewListener>();

        mouseRadioButton.setSelected(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mouseType = mouseSelected ? "mouse" : trackpadSelected ? "trackpad" : "error";

                for (MouseTypeViewListener listener : listeners) {
                    listener.mouseTypeSelected(mouseType);
                }

            }
        });

        mouseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // mouse type has been selected
                if (!mouseSelected) {
                    mouseSelected = true;

                    if (trackpadSelected) {
                        trackpadRadioButton.setSelected(false);
                        trackpadSelected = false;
                    }
                }
                // won't allow for unchecked boxes
                else {
                    mouseRadioButton.setSelected(true);
                }
            }
        });

        trackpadRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // trackpad type has been selected
                if (!trackpadSelected) {
                    trackpadSelected = true;

                    if (mouseSelected) {
                        mouseRadioButton.setSelected(false);
                        mouseSelected = false;
                    }
                }
                // won't allow for unchecked boxes
                else {
                    trackpadRadioButton.setSelected(true);
                }

            }
        });
    }
}
