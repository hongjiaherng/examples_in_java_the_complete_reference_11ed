package chapter26awtcontrolslayoutmanagersandmenu.layout;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagLayoutDemo extends Frame implements ItemListener {

    String msg = "";
    Checkbox windows, android, solaris, mac;

    public GridBagLayoutDemo() {

        // Use a GridBagLayout.
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbag);

        // Define check boxes.
        windows = new Checkbox("Windows", true);
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        // Define the grid bag.

        // Use default row weight of 0 for first row.
        gbc.weightx = 1.0; // use a column weight of 1
        gbc.ipadx = 200; // pad by 200 units
        gbc.insets = new Insets(0, 6, 0, 0); // inset slightly from left

        gbc.anchor = GridBagConstraints.NORTHEAST;

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(windows, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(android, gbc);

        // Give second row a weight of 1.
        gbc.weighty = 1.0;

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(solaris, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(mac, gbc);

        // Add the components.
        add(windows);
        add(android);
        add(solaris);
        add(mac);

        // Register to receive item events.
        windows.addItemListener(this);
        android.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

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

    // Display current state of the check boxes.
    @Override
    public void paint(Graphics g) {
        msg = "Current state: ";
        g.drawString(msg, 20, 100);
        msg = " Windows: " + windows.getState();
        g.drawString(msg, 30, 120);
        msg = " Android: " + android.getState();
        g.drawString(msg, 30, 140);
        msg = " Solaris: " + solaris.getState();
        g.drawString(msg, 30, 160);
        msg = " Mac: " + mac.getState();
        g.drawString(msg, 30, 180);
    }

    public static void main(String[] args) {
        GridBagLayoutDemo appwin = new GridBagLayoutDemo();

        appwin.setSize(new Dimension(250, 200));
        appwin.setTitle("GridBagLayoutDemo");
        appwin.setVisible(true);
    }
}
