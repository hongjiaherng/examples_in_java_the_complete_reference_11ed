package chapter21exploringjavaio.bytestream.bytearrayoutputstreamdemo;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This should end up in the array";
        byte buf[] = s.getBytes();

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Error writing to buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");
        byte b[] = f.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }

        System.out.println("\nTo an OutputStream()");

        // Use try-with-resources to manage the file stream.
        try (FileOutputStream f2
                     = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\bytearrayoutputstreamdemo\\test.txt")) {

            f.writeTo(f2);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }

        System.out.println("Doing a reset");
        f.reset();

        for (int i = 0; i < 3; i++) {
            f.write('X');
        }

        System.out.println(f.toString());
    }
}
