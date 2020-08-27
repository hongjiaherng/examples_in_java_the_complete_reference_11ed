package chapter24eventhandling;

import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame implements MouseListener, MouseMotionListener {

    String msg = "";

    // Coordinates of mouse
    int mouseX = 0, mouseY = 0;

    public MouseEventsDemo() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Handle mouse clicked.
    @Override
    public void mouseClicked(MouseEvent e) {
        msg = msg + " -- click received";
        repaint();
    }

    // Handle mouse entered.
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered.";
        repaint();
    }

    // Handle mouse exited.
    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited.";
        repaint();
    }

    // Handle button pressed.
    @Override
    public void mousePressed(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        repaint();
    }

    // Handle button released.
    @Override
    public void mouseReleased(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button Released";
        repaint();
    }

    // Handle mouse dragged.
    @Override
    public void mouseDragged(MouseEvent e) {
        // Save coordinates
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + " mouse at " + mouseX + ", " + mouseY;
        repaint();
    }

    // Handle mouse moved.
    @Override
    public void mouseMoved(MouseEvent e) {
        msg = "Moving mouse at " + e.getX() + ", " + e.getY();
        repaint();
    }

    // Display msg in the window at current X, Y location.
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        MouseEventsDemo appwin = new MouseEventsDemo();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("MouseEventsDemo");
        appwin.setVisible(true);
    }
}

