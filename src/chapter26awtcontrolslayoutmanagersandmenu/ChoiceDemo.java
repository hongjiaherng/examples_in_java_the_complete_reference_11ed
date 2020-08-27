package chapter26awtcontrolslayoutmanagersandmenu;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChoiceDemo extends Frame implements ItemListener {
    Choice os, browser;
    String msg = "";

    public ChoiceDemo() {

        // Use a flow layout.
        setLayout(new FlowLayout());

        // Create choice lists.
        os = new Choice();
        browser = new Choice();

        // Add items to os list.
        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");

        // Add items to browser list.
        browser.add("Internet Explorer");
        browser.add("Firefox");
        browser.add("Chrome");

        // Add choice lists to window.
        add(os);
        add(browser);

        // Add item listeners.
        os.addItemListener(this);
        browser.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    // Display current selections.
    @Override
    public void paint(Graphics g) {
        msg = "Current OS: ";
        msg += os.getSelectedItem();
        g.drawString(msg, 20, 120);
        msg = "Current Browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 20, 140);
    }

    public static void main(String[] args) {
        ChoiceDemo appwin = new ChoiceDemo();

        appwin.setSize(new Dimension(240, 180));
        appwin.setTitle("ChoiceDemo");
        appwin.setVisible(true);
    }
}
