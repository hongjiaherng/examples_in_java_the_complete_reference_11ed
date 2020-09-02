package chapter32exploringswing.jlabeldemo;

import javax.swing.*;
import java.awt.*;

class JLabelDemo {
    public JLabelDemo() {

        // Set up the JFrame.
        JFrame jfrm = new JFrame("JLabelDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(500, 300);

        // Create an icon.
        ImageIcon ii = new ImageIcon(
                "C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jlabeldemo\\hourglass.jpg");

        // Create a label.
        JLabel jl = new JLabel("Hourglass", ii, JLabel.CENTER);

        // Add the label to the content pane.
        jfrm.add(jl);

        // Display the frame.
        jfrm.setVisible(true);

    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JLabelDemo();
            }
        });
    }
}
