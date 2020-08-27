package chapter13iotrywithresourcesandothertopics.showfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ShowFile2 {
    public static void main(String[] args) {

        int i;
        FileInputStream fin = null;

        // First, confirm that a filename has been specified.
        if (args.length != 1) {
            System.out.println("Usage: ShowFile2 filename");
            return;
        }

        // The following code opens a file, reads characters until EOF is encountered,
        // and then closes the file via a finally block.
        try {
            fin = new FileInputStream(args[0]);

            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getClass());
        } finally {
            // Close file in all cases.
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing File");
            }

        }
    }
}
