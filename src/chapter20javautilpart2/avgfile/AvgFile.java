package chapter20javautilpart2.avgfile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class AvgFile {
    public static void main(String[] args) throws IOException {

        int count = 0;
        double sum = 0.0;

        // Write output to a file.
        FileWriter fout = new FileWriter("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\avgfile\\test.txt");
        fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
        fout.close();

        FileReader fin = new FileReader("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\avgfile\\Test.txt");

        try (Scanner src = new Scanner(fin)) {

            // Read and sum numbers.
            while (src.hasNext()) {
                if (src.hasNextDouble()) {
                    sum += src.nextDouble();
                    count++;
                } else {
                    if (src.next().equals("done")) {
                        break;
                    } else {
                        System.out.println("File format error.");
                        return;
                    }
                }
            }
        }
        System.out.println("Average is " + sum / count);

    }
}
