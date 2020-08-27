package chapter13iotrywithresourcesandothertopics.trywithresourcescopyfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyFile {
    public static void main(String[] args) {
        int i;

        if (args.length != 2) {
            System.out.println("Usage: CopyFile from to");
            return;
        }

        try (var fin = new FileInputStream(args[0]);
             var fout = new FileOutputStream(args[1])) {

            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
