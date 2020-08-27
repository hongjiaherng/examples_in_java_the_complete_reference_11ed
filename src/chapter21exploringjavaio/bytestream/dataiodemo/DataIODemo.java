// Demonstrate DataInputStream and DataOutputStream.

package chapter21exploringjavaio.bytestream.dataiodemo;

import java.io.*;

class DataIODemo {
    public static void main(String[] args) {

        // First, write the data.
        try (DataOutputStream dout =
                     new DataOutputStream(new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\dataiodemo\\Test.dat"))) {

            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open Output File");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

        // Now, read the data back.
        try (DataInputStream din =
                new DataInputStream(new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter21exploringjavaio\\bytestream\\dataiodemo\\Test.dat"))) {

            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Here are the values: " + d + " " + i + " " + b);

        } catch (FileNotFoundException e) {
            System.out.println("Cannot Open Input File");
            return;
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

    }
}
