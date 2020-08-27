package chapter26awtcontrolslayoutmanagersandmenu.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutDemo extends Frame {

    static final int n = 4;

    public GridLayoutDemo() {

        // Use GridLayout.
        setLayout(new GridLayout(n, n));

        setFont(new Font("SansSerif", Font.BOLD, 24));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (k > 0) {
                    add(new Button("" + k));
                }
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GridLayoutDemo appwin = new GridLayoutDemo();

        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("GridLayoutDemo");
        appwin.setVisible(true);
    }
}
