package chapter21exploringjavaio.characterstream;

import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\characterstream\\FileReaderDemo.java")) {

            int c;

            // Read and display the file.
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

    }
}
