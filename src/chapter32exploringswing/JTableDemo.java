// Demonstrate JTable.

package chapter32exploringswing;

import javax.swing.*;

class JTableDemo {

    // Initialize column headings.
    String[] colHeads = {"Name", "Extension", "ID#"};

    // Initialize data.
    Object[][] data = {
            {"Gail", "45567", "865"},
            {"Ken", "7566", "555"},
            {"Viviane", "5634", "587"},
            {"Melanie", "7345", "922"},
            {"Anne", "1237", "333"},
            {"John", "5656", "314"},
            {"Matt", "5672", "217"},
            {"Claire", "6741", "444"},
            {"Erwin", "9023", "519"},
            {"Ellen", "1134", "532"},
            {"Jennifer", "5689", "112"},
            {"Ed", "9030", "133"},
            {"Helen", "6751", "145"}
    };

    public JTableDemo() {

        // Set up the JFrame. Use default BorderLayout.
        JFrame jfrm = new JFrame("JTableDemo");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 300);

        // Create the table.
        JTable table = new JTable(data, colHeads);

        // Add the table to a scroll pane.
        JScrollPane jsp = new JScrollPane(table);

        // Add the scroll pane to the content pane.
        jfrm.add(jsp);

        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(() -> new JTableDemo());
    }
}
