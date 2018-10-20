package tracer.cursor.view;

import tracer.cursor.interfaces.CursorSelectListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CursorSelectView {
    private JPanel panelMain;
    private JRadioButton mouseRadioButton;
    private JRadioButton trackpadRadioButton;
    private JButton startButton;

    boolean mouseSelected = true;
    boolean trackpadSelected = false;

    private ArrayList<CursorSelectListener> listeners;

    public JPanel getPanel() {
        return panelMain;
    }

    public void addListener(CursorSelectListener listener) {
        listeners.add(listener);
    }

    public CursorSelectView() {

        listeners = new ArrayList<CursorSelectListener>();

        mouseRadioButton.setSelected(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String mouseType = mouseSelected ? "mouse" : trackpadSelected ? "trackpad" : "error";

                for (CursorSelectListener listener : listeners) {
                    listener.cursorTypeSelected(mouseType);
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
