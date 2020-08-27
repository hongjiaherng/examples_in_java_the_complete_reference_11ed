package chapter24eventhandling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// When the close box in the frame is clicked, close the window and exit the program.
class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
