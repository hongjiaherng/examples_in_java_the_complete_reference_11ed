// Filters directories using wildcard/ glob (another overload method of newDirectoryStream())
// In this example, filters the directory based on filename.

package chapter22exploringjavanio.pathandfilesystemoperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class DirListFilterWildcard {
    public static void main(String[] args) {

        String dirname = "\\Users\\USER\\Desktop\\Java Practice";

        // Only filename/ directory name which ends with extension ".java" or ".class" will be displayed.
        String wildcard = "*.{java,class}";


        try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Path.of(dirname), wildcard)) {

            System.out.println("Directory of " + dirname);

            for (Path entry : dirStrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attribs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }
                System.out.println(entry.getName(4));
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
