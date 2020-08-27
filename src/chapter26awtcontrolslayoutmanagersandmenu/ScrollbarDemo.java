package chapter26awtcontrolslayoutmanagersandmenu;

import java.awt.*;
import java.awt.event.*;

public class ScrollbarDemo extends Frame implements AdjustmentListener {

    String msg = "";
    Scrollbar vertSB, horzSB;

    public ScrollbarDemo() {
        // Use a flow layout.
        setLayout(new FlowLayout());

        // Create scroll bars and set preferred size.
        vertSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 200);
        vertSB.setPreferredSize(new Dimension(20, 100));

        horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        horzSB.setPreferredSize(new Dimension(100, 20));

        // Add the scroll bars to the frame.
        add(vertSB);
        add(horzSB);

        // Add AdjustmentListeners for the scroll bars.
        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);

        // Add MouseMotionListener.
        addMouseMotionListener(new MouseAdapter() {
            // Update scroll bars to reflect mouse dragging.
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                vertSB.setValue(y);
                horzSB.setValue(x);
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
    public void adjustmentValueChanged(AdjustmentEvent e) {
        repaint();
    }

    // Display current value of scroll bars.

    @Override
    public void paint(Graphics g) {
        msg = "Vertical: " + vertSB.getValue();
        msg += ", Horizontal: " + horzSB.getValue();
        g.drawString(msg, 20, 160);

        // show current mouse drag position.
        g.drawString("*", horzSB.getValue(), vertSB.getValue());
    }

    public static void main(String[] args) {
        ScrollbarDemo appwin = new ScrollbarDemo();

        appwin.setSize(new Dimension(300, 180));
        appwin.setTitle("ScrollbarDemo");
        appwin.setVisible(true);
    }
}
