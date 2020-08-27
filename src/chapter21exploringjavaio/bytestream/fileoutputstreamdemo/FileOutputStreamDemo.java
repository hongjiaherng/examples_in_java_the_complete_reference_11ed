package chapter21exploringjavaio.bytestream.fileoutputstreamdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte buf[] = source.getBytes();
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;

        try {
            f0 = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\fileoutputstreamdemo\\file1.txt");
            f1 = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\fileoutputstreamdemo\\file2.txt");
            f2 = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\fileoutputstreamdemo\\file3.txt");

            // Write to first file
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }

            // Write to second file
            f1.write(buf);

            // Write to third file
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (FileNotFoundException e) {
            System.out.println("An FileNotFoundException occurred");
        } catch (IOException e) {
            System.out.println("An I/O Error Occurred");
        } finally {
            try {
                if (f0 != null) {
                    f0.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file1.txt");
            }
            try {
                if (f1 != null) {
                    f1.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file2.txt");
            }
            try {
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException e) {
                System.out.println("Error Closing file3.txt");
            }
        }
    }
}
