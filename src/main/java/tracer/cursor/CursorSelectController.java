package tracer.cursor;

import tracer.cursor.interfaces.CursorSelectListener;
import tracer.cursor.view.CursorSelectView;

import javax.swing.*;
import java.util.ArrayList;

public class CursorSelectController implements CursorSelectListener
{

    private JFrame frame;
    private CursorSelectView view;

    private ArrayList<CursorSelectListener> listeners;

    public CursorSelectController()
    {
        frame = new JFrame("OTL - Cursor Type");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        listeners = new ArrayList<CursorSelectListener>();

        view = new CursorSelectView();
        view.addListener(this);
    }

    public void addListener(CursorSelectListener listener) {
        listeners.add(listener);
    }


    public void go()
    {
        frame.setContentPane(view.getPanel());

        refresh();
    }


    private void refresh() {
        frame.validate();
        frame.pack();
        frame.setVisible(true);
    }

    public void cursorTypeSelected(String cursor_type) {

        for (CursorSelectListener listener : listeners) {
            listener.cursorTypeSelected(cursor_type);
        }

        frame.setVisible(false);

    }
}
