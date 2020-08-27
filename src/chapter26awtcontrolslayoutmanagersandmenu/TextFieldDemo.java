package chapter26awtcontrolslayoutmanagersandmenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldDemo extends Frame implements ActionListener {

    TextField name, pass;

    public TextFieldDemo() {

        // Use a flow layout.
        setLayout(new FlowLayout());

        // Create controls.
        Label namep = new Label("Name: ", Label.RIGHT);
        Label passp = new Label("Password: ", Label.RIGHT);
        name = new TextField(12);
        pass = new TextField(8);
        pass.setEchoChar('?');

        // Add the controls to the frame.
        add(namep);
        add(name);
        add(passp);
        add(pass);

        // Add action event handlers.
        name.addActionListener(this);
        pass.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // User pressed Enter.
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Name: " + name.getText(), 20, 100);
        g.drawString("Selected text in name: " + name.getSelectedText(), 20, 120);
        g.drawString("Password: " + pass.getText(), 20, 140);
    }

    public static void main(String[] args) {
        TextFieldDemo appwin = new TextFieldDemo();

        appwin.setSize(new Dimension(380, 180));
        appwin.setTitle("TextFieldDemo");
        appwin.setVisible(true);
    }
}
