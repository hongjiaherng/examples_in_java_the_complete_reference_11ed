package chapter27images;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBuffer extends Frame {
    int gap = 3;
    int mx, my;
    boolean flicker = true;
    Image buffer = null;
    int w = 400, h = 400;

    public DoubleBuffer() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics screengc = null;

        // Swap Graphics reference g with the graphics context that refers to the offscreen canvas, buffer
        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }

        // Set and fill all the color into buffer if flicker is false.
        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.red);
        for (int i = 0; i < w; i += gap) {
            g.drawLine(i, 0, w-i, h);
        }
        for (int i = 0; i < h; i += gap) {
            g.drawLine(0, i, w, h-i);
        }

        g.setColor(Color.black);
        g.drawString("Press mouse button to double buffer", 10, h/2);

        g.setColor(Color.yellow);
        g.fillOval(mx-gap, my-gap, gap*2+1, gap*2+1);

        // display offscreen image
        if (!flicker) {
            screengc.drawImage(buffer, 0, 0, null);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        DoubleBuffer appwin = new DoubleBuffer();

        appwin.setSize(new Dimension(400, 400));
        appwin.setTitle("DoubleBuffer");
        appwin.setVisible(true);

        // Create an off-screen buffer.
        appwin.buffer = appwin.createImage(appwin.w, appwin.h);
    }
}
