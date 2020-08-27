// Use Scanner to compute an average a list of comma-separated values.

package chapter20javautilpart2.setdelimiters;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

class SetDelimiters {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0;
        Pattern delimiter;

        // Write output to a file.
        FileWriter fout = new FileWriter("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\setdelimiters\\test.txt");

        // Now, store values in comma-separated list.
        fout.write("2, 3.4,   5, 6, 7.4, 9.1, 10.5, done");
        fout.close();

        FileReader fin = new FileReader("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter20javautilpart2\\setdelimiters\\test.txt");

        try (Scanner src = new Scanner(fin)) {
            // Set delimiters to space and comma.
            src.useDelimiter(", *");
            delimiter = src.delimiter();

            // Read and sum numbers.
            while (src.hasNext()) {
                if (src.hasNextDouble()) {
                    sum += src.nextDouble();
                    count++;
                } else {
                    String str = src.next();
                    if (str.equals("done")) {
                        break;
                    } else {
                        System.out.println("File format error.");
                        return;
                    }
                }
            }
        }
        System.out.println("Average is " + sum / count);

        System.out.println(delimiter);


    }
}
