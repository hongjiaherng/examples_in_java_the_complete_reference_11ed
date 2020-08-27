package chapter26awtcontrolslayoutmanagersandmenu.layout;

import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Frame {

    Checkbox windows10, windows7, windows8, android, solaris, mac;
    Panel osCards;
    CardLayout cardLO;
    Button Win, Other;

    public CardLayoutDemo() {
        // Use a flow layout for the main frame.
        setLayout(new FlowLayout());

        Win = new Button("Windows");
        Other = new Button("Other");
        add(Win);
        add(Other);

        // Set osCards panel to use CardLayout.
        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO);

        windows7 = new Checkbox("Windows 7", true);
        windows8 = new Checkbox("Windows 8");
        windows10 = new Checkbox("Windows 10");
        android = new Checkbox("Android");
        solaris = new Checkbox("Solaris");
        mac = new Checkbox("Mac OS");

        // Add Windows check boxes to a panel.
        Panel winPan = new Panel();
        winPan.add(windows7);
        winPan.add(windows8);
        winPan.add(windows10);

        // Add other OS check boxes to a panel.
        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(solaris);
        otherPan.add(mac);

        // Add panels to card deck panel.
        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        // Add cards to main frame panel.
        add(osCards);

        // Use lambda expressions to handle button events.
        Win.addActionListener((e) -> cardLO.show(osCards, "Windows"));
        Other.addActionListener((e) -> cardLO.show(osCards, "Other"));

        // Register for mouse pressed events.
        addMouseListener(new MouseAdapter() {
            // Cycle through panels.
            @Override
            public void mousePressed(MouseEvent e) {
                cardLO.next(osCards);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        CardLayoutDemo appwin = new CardLayoutDemo();

        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("CardLayoutDemo");
        appwin.setVisible(true);
    }
}
