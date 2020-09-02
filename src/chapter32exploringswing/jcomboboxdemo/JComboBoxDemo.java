// Demonstrate JComboBox.

package chapter32exploringswing.jcomboboxdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JComboBoxDemo {

    String[] timepieces = {"Hourglass", "Analog", "Digital", "Stopwatch"};

    public JComboBoxDemo() {

        // Set up the JFrame.
        JFrame jfrm = new JFrame("JComboBoxDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(400, 250);

        // Instantiate a combo box and add it to the content pane.
        JComboBox<String> jcb = new JComboBox<>(timepieces);
        jfrm.add(jcb);

        // Create a label and add it to the content pane.
        JLabel jlab = new JLabel(new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jcomboboxdemo\\hourglass.jpg"));
        jfrm.add(jlab);

        // Handle selections.
        jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) jcb.getSelectedItem();
                jlab.setIcon(new ImageIcon("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter32exploringswing\\jcomboboxdemo\\" + s + ".jpg"));
            }
        });

        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JComboBoxDemo();
            }
        });
    }
}
