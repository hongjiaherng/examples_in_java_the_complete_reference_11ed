package chapter22exploringjavanio.pathandfilesystemoperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;

class DirList {
    public static void main(String[] args) {
        String dirname = "\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\pathandfilesystemoperations\\pathdemo";

        // Obtain and manage a directory stream within a try block.
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Path.of(dirname))) {

            System.out.println("Directory of " + dirname);

            // Because DirectoryStream implements Iterable interface, we
            // can use a "foreach" loop to display the directory.

            // Method 1: Using foreach loop
            /*
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }

                System.out.println(entry.getName(8));
            }

             */

            // Method 2: Using iterator
            Iterator<Path> iterator = dirstrm.iterator();
            while (iterator.hasNext()) {
                Path entry = iterator.next();

                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }

                System.out.println(entry.getName(8));
            }

        } catch (InvalidPathException e) {
            System.out.println("Path Error: " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
