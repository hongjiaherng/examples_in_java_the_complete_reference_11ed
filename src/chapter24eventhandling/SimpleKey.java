package chapter24eventhandling;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleKey extends Frame implements KeyListener {

    String msg = "";
    String keyState = "";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Handle key typed.
    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    // Handle key press.
    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Key Down";
        repaint();
    }

    // Handle a key release.
    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Key Up";
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        SimpleKey appwin = new SimpleKey();

        appwin.setSize(new Dimension(200, 150));
        appwin.setTitle("Simple Key");
        appwin.setVisible(true);
    }
}
