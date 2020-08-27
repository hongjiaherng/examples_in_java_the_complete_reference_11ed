// A simple telephone numeber database that uses a property list.

package chapter19javautilpart1.storeandloadinproperties;

import java.io.*;
import java.util.Properties;

class Phonebook {
    public static void main(String[] args) throws IOException {

        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        // FileInputStream fin = null;
        boolean changed = false;

        /*
        // Try to open phonebook.dat file.
        try {
            fin = new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter19javautilpart1\\storeandloadinproperties\\phonebook.dat");
        } catch (FileNotFoundException e) {
            // Ignore missing file
        }

        // If phonebook file already exists, load existing telephone numbers.
        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        */

        // Try to open phonebook.dat file.
        try (FileInputStream fin = new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter19javautilpart1\\storeandloadinproperties\\phonebook.dat")) {
            // If phonebook file already exists, load existing telephone numbers.
            ht.load(fin);
        } catch (FileNotFoundException e) {
            System.out.println("No file exists. Creating a new file...");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // Let user enter new names and numbers.
        do {
            System.out.println("Enter new name" + " ('quit' to stop): ");
            name = br.readLine();
            if (name.equals("quit")) continue;
            // continue: bypass the remaining operation in the loop to proceed to the condition.
            // In this case, it will straightly go to the while statement.

            System.out.println("Enter number: ");
            number = br.readLine();

            ht.setProperty(name, number);
            changed = true;
        } while (!name.equals("quit"));

        // If phone book data has changed, save it.
        if (changed) {
            FileOutputStream fout =
                    new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter19javautilpart1\\storeandloadinproperties\\phonebook.dat");

            ht.store(fout, "Telephone Book");
            fout.close();
        }

        // Look up numbers given a name.
        do {
            System.out.println("Enter name to find" + "('quit' to quit): ");
            name = br.readLine();
            if (name.equals("quit")) continue;

            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("quit"));

    }
}
