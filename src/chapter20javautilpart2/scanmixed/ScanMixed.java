package chapter20javautilpart2.scanmixed;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ScanMixed {
    public static void main(String[] args) throws IOException {
        int i;
        double d;
        boolean b;
        String str;

        // Write output to a file.
        FileWriter fout = new FileWriter("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\scanmixed\\test.txt");
        fout.write("Testing Scanner 10 12.2 one true two false");
        fout.close();

        FileReader fin = new FileReader("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\scanmixed\\test.txt");
        Scanner src = new Scanner(fin);

        // Read to end.
        while (src.hasNext()) {
            if (src.hasNextInt()) {
                i = src.nextInt();
                System.out.println("int: " + i);
            } else if (src.hasNextDouble()) {
                d = src.nextDouble();
                System.out.println("double: " + d);
            } else if (src.hasNextBoolean()) {
                b = src.nextBoolean();
                System.out.println("boolean: " + b);
            } else {
                str = src.next();
                System.out.println("String: " + str);
            }
        }
        src.close();
    }
}
