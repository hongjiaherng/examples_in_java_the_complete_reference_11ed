package chapter25introducingtheawt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FontInfo extends Frame {

    public FontInfo() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Font f = g.getFont();
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();
        StringBuilder msg = new StringBuilder();
        msg.append("Family: " + fontName);
        msg.append(", Font: " + fontFamily);
        msg.append(", Size: " + fontSize + ", Style: ");

        if (fontStyle == Font.BOLD) {
            msg.append("Bold ");
        }
        if (fontStyle == Font.ITALIC) {
            msg.append("Italic ");
        }
        if (fontStyle == Font.PLAIN) {
            msg.append("Plain ");
        }
        g.drawString(msg.toString(), 10, 60);
    }

    public static void main(String[] args) {
        FontInfo appwin = new FontInfo();

        appwin.setSize(new Dimension(300, 100));
        appwin.setTitle("FontInfo");
        appwin.setVisible(true);
    }
}
