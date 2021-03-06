package chapter26awtcontrolslayoutmanagersandmenu.dialog;

import java.awt.*;
import java.awt.event.*;

class DialogDemo extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;
    SampleDialog myDialog;
    OpenDialog openDialog;

    public DialogDemo() {

        // Create the dialog box.
        myDialog = new SampleDialog(this, "New Dialog Box");
        openDialog = new OpenDialog(this, "Open Dialog Box");

        // Create menu bar and add it to frame.
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);

        // Create the menu items.
        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close"));
        file.add(item4 = new MenuItem("-"));
        file.add(item5 = new MenuItem("Quit..."));
        mbar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item6, item7, item8, item9;
        edit.add(item6 = new MenuItem("Cut"));
        edit.add(item7 = new MenuItem("Copy"));
        edit.add(item8 = new MenuItem("Paste"));
        edit.add(item9 = new MenuItem("-"));

        Menu sub = new Menu("Special");
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("First"));
        sub.add(item11 = new MenuItem("Second"));
        sub.add(item12 = new MenuItem("Third"));
        edit.add(sub);

        // These are checkable menu items.
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);

        mbar.add(edit);

        // Create an object to handle action and item events.
        MyMenuHandler handler = new MyMenuHandler();

        // Register to receive those events.
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        // Use a lambda expression to handle the Quit selection.
        item5.addActionListener((e) -> System.exit(0));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 220);

        if (debug.getState()) {
            g.drawString("Debug is on.", 10, 240);
        } else {
            g.drawString("Debug is off.", 10, 240);
        }

        if (test.getState()) {
            g.drawString("Testing is on.", 10, 260);
        } else {
            g.drawString("Testing is off.", 10, 260);
        }
    }

    public static void main(String[] args) {
        DialogDemo appwin = new DialogDemo();

        appwin.setSize(new Dimension(250, 300));
        appwin.setTitle("DialogDemo");
        appwin.setVisible(true);
    }

    // An inner class for handling action and item events for the menu.
    class MyMenuHandler implements ActionListener, ItemListener {

        // Handle action events.
        @Override
        public void actionPerformed(ActionEvent e) {
            msg = "You selected ";
            String arg = e.getActionCommand();

            switch (arg) {
                case "New...":
                    msg += "New.";
                    myDialog.setVisible(true);
                    break;
                case "Open...":
                    msg += "Open.";
                    openDialog.setVisible(true);
                    break;
                case "Close":
                    msg += "Close.";
                    break;
                case "Edit":
                    msg += "Edit.";
                    break;
                case "Cut":
                    msg += "Cut.";
                    break;
                case "Copy":
                    msg += "Copy.";
                    break;
                case "Paste":
                    msg += "Paste.";
                    break;
                case "First":
                    msg += "First.";
                    break;
                case "Second":
                    msg += "Second.";
                    break;
                case "Third":
                    msg += "Third.";
                    break;
                case "Debug":
                    msg += "Debug.";
                    break;
                case "Testing":
                    msg += "Testing.";
                    break;
            }
            repaint();
        }

        // Handle item events.
        @Override
        public void itemStateChanged(ItemEvent e) {
            repaint();
        }
    }

    class SampleDialog extends Dialog {
        SampleDialog(Frame parent, String title) {
            super(parent, title, true);
            setLayout(new FlowLayout());
            setSize(300, 200);

            add(new Label("Press this button:"));

            Button b;
            add(b = new Button("Cancel"));
            b.addActionListener((e) -> dispose());

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            g.drawString("This is in the dialog box", 20, 80);
        }
    }

    class OpenDialog extends Dialog {
        OpenDialog(Frame parent, String title) {
            super(parent, title, ModalityType.APPLICATION_MODAL);
            setLayout(new BorderLayout());
            setSize(new Dimension(400, 400));
            setBackground(Color.orange);

            Button b;
            add(new Label("Open"), BorderLayout.NORTH);
            add(new Button("Browse..."), BorderLayout.WEST);
            add(new TextArea("Text area to be shown"), BorderLayout.CENTER);
            add(b = new Button("Quit"), BorderLayout.SOUTH);
            add(new Label("Right"), BorderLayout.EAST);
            b.addActionListener(e -> dispose());

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });

        }
    }
}
