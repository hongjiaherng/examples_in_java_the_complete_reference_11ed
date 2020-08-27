package chapter25introducingtheawt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ShowFonts extends Frame {
    String msg = "First five fonts: ";
    GraphicsEnvironment ge;

    public ShowFonts() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Get the graphics environment.
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Obtain a list of the fonts.
        String[] fontList = ge.getAvailableFontFamilyNames();

        // Create a string of the first 5 fonts.
        for (int i = 0; (i < 5) && (i < fontList.length); i++) {
            msg += fontList[i] + "      ";
        }
    }

    // Display the fonts.
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        ShowFonts appwin = new ShowFonts();

        appwin.setSize(new Dimension(500, 100));
        appwin.setTitle("ShowFonts");
        appwin.setVisible(true);
    }
}
