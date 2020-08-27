package chapter21exploringjavaio.characterstream.chararraywriterdemo;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "This should end up in the array";
        char[] buf = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");

        char[] c = f.toCharArray();
        for (char x : c) {
            System.out.print(x);
        }

        System.out.println("\nTo a FileWriter()");

        // Use try-with-resources to manage the file stream.
        try (FileWriter f2 = new FileWriter("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\characterstream\\chararraywriterdemo\\test.txt")) {

            f.writeTo(f2);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("Doing a reset");
        f.reset();

        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
