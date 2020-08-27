// Demonstrate FileInputStream.

package chapter21exploringjavaio.bytestream.fileinputstreamdemo;

import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        // Use try-with-resources to close the stream.
        try (FileInputStream f = new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\fileinputstreamdemo\\FileInputStreamDemo.java")) {

            System.out.println("Total Available Bytes: " + (size = f.available()));

            int n = size / 40; // 48
            System.out.println("First " + n + " bytes of the file one read() at a time");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("\nStill Available: " + f.available());

            System.out.println("Reading the next " + n + " with one read(b[])");
            byte b[] = new byte[n];
            if (f.read(b) != n) {
                System.out.println("Couldn't read " + n + " bytes.");
            }

            System.out.println(new String(b, 0, n));
            System.out.println("\nStill Available: " + (size = f.available()));
            System.out.println("Skipping half of remaining bytes with skip()");
            f.skip(size / 2);
            System.out.println("Still Available: " + f.available());

            System.out.println("Reading " + n / 2 + " into the end of array");
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.out.println("Couldn't read " + n / 2 + " bytes.");
            }

            System.out.println(new String(b, 0, b.length));
            System.out.println("Still Available: " + f.available());

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
