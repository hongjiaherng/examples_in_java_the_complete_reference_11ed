package chapter21exploringjavaio.bytestream.sequenceinputstreamdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {

    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (IOException e) {
            return null;
        }
    }
}

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.addElement("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\sequenceinputstreamdemo\\file1.txt");
        files.addElement("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\sequenceinputstreamdemo\\file2.txt");
        files.addElement("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\sequenceinputstreamdemo\\file3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);

        try {
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("Error Opening File.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Error Closing SequenceInputStream");
            }
        }
    }
}
