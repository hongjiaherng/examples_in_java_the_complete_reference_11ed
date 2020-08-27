/**
 * File path must be specified properly in the command line, but the problem for this is we can't get an argument with spaces
 * between it.
 * So, I avoid putting the test.txt and destination.txt in this package (chapter22exploringjavanio.channelbasedio.niocopy).
 * Instead, move these two files as following:
 *
 * test.txt file and destination.txt file should be in the directory of (if run the .class file in this particular directory):
 * C:\Users\USER\IdeaProjects\Examples in Java The Complete Reference\out\production\Examples in Java The Complete Reference\
 *
 */

package chapter22exploringjavanio.channelbasedio.niocopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

class NIOCopy {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: Copy from to");
            return;
        }

        try {
            Path source = Path.of(args[0]);
            Path target = Path.of(args[1]);

            // Copy the file.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }

    }
}
