// Demonstrate JScrollPane.

package chapter32exploringswing;

import javax.swing.*;
import java.awt.*;

class JScrollPaneDemo {

    public JScrollPaneDemo() {

        // Set up the JFrame. Use the default BorderLayout.
        JFrame jfrm = new JFrame("JScrollPaneDemo");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400, 400);

        // Create a panel and add 400 buttons to it.
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));

        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                jp.add(new JButton("Button " + b));
                ++b;
            }
        }

        // Create the scroll pane.
        JScrollPane jsp = new JScrollPane(jp);

        // Add the scroll pane to the content pane.
        // Because the default border layout is used,
        // the scroll pane will be added to the center.
        jfrm.add(jsp, BorderLayout.CENTER);

        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JScrollPaneDemo();
            }
        });
    }
}
