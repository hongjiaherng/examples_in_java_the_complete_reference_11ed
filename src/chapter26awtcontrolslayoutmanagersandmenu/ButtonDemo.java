package chapter26awtcontrolslayoutmanagersandmenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonDemo extends Frame implements ActionListener {

    String msg = "";
    Button yes, no, maybe;

    public ButtonDemo() {

        // Use a flow layout.
        setLayout(new FlowLayout());

        // Create some buttons.
        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Undecided");

        // Add them to the frame.
        add(yes);
        add(no);
        add(maybe);

        // Add action listeners for the buttons.
        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    // Handle button action events.
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Yes")) {
            msg = "You pressed Yes.";
        } else if (str.equals("No")) {
            msg = "You pressed No.";
        } else {
            msg = "You pressed Undecided.";
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        ButtonDemo appwin = new ButtonDemo();

        appwin.setSize(new Dimension(250, 150));
        appwin.setTitle("ButtonDemo");
        appwin.setVisible(true);
    }
}
