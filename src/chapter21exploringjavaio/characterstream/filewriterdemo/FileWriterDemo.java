package chapter21exploringjavaio.characterstream.filewriterdemo;

import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (FileWriter f0 = new FileWriter("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\characterstream\\filewriterdemo\\file1.txt");
        FileWriter f1 = new FileWriter("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\characterstream\\filewriterdemo\\file2.txt");
        FileWriter f2 = new FileWriter("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\characterstream\\filewriterdemo\\file3.txt")) {

            // Write to first file
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            // Write to second file
            f1.write(buffer);

            // Write to third file
            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);

        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        }
    }
}