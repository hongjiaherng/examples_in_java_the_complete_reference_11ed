// Demonstrate an icon-based JButton.

package chapter32exploringswing.jbuttondemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JButtonDemo implements ActionListener {

    JLabel jlab;

    public JButtonDemo() {

        // Set up the JFrame.
        JFrame jfrm = new JFrame("JButtonDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(600, 550);

        // Add buttons to content pane.
        ImageIcon hourglass = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jbuttondemo\\hourglass.jpg");
        JButton jb = new JButton(hourglass);
        jb.setActionCommand("Hourglass");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon analog = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jbuttondemo\\analog.jpg");
        jb = new JButton(analog);
        jb.setActionCommand("Analog Clock");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon digital = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jbuttondemo\\digital.jpg");
        jb = new JButton(digital);
        jb.setActionCommand("Digital Clock");
        jb.addActionListener(this);
        jfrm.add(jb);

        ImageIcon stopwatch = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jbuttondemo\\stopwatch.jpg");
        jb = new JButton(stopwatch);
        jb.setActionCommand("Stopwatch");
        jb.addActionListener(this);
        jfrm.add(jb);

        // Create and add the label to content pane.
        jlab = new JLabel("Choose a Timepiece");
        jfrm.add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Handle button events.
    @Override
    public void actionPerformed(ActionEvent e) {
        jlab.setText("You selected " + e.getActionCommand());
    }

    public static void main(String[] args) {

        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JButtonDemo();
            }
        });
    }
}
