package chapter26awtcontrolslayoutmanagersandmenu;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextAreaDemo extends Frame {

    public TextAreaDemo() {

        // Use a flow layout.
        setLayout(new FlowLayout());

        String val =
                "Java 9 is the latest version of the most\n" +
                        "widely-used computer language for Internet programming.\n" +
                        "Building on a rich heritage, Java has advanced both\n" +
                        "the art and science of computer language design.\n\n" +
                        "One of the reasons for Java's ongoing success is its\n" +
                        "constant, steady rate of evolution. Java has never stood\n" +
                        "still. Instead, Java has consistently adapted to the\n" +
                        "rapidly changing landscape of the networked world.\n" +
                        "Moreover, Java has often led the way, charting the\n" +
                        "course for others to follow.";

        TextArea text = new TextArea(val, 10, 30);
        add(text);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TextAreaDemo appwin = new TextAreaDemo();

        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("TextAreaDemo");
        appwin.setVisible(true);
    }
}
