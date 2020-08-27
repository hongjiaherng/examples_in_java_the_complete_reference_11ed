// Filters directories with DirectoryStream.Filter<T> functional interface

package chapter22exploringjavanio.pathandfilesystemoperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;

class DirListFilterFunctionalInterface {
    public static void main(String[] args) {
        String dirname = "\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\pathandfilesystemoperations\\pathdemo";

        // Create a filter that returns true only for writable files.
        // Method 1: Anonymous Class
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if (Files.isWritable(entry)) return true;
                return false;
            }
        };

        // Method 2: Lambda Expression
        /*
        DirectoryStream.Filter<Path> how = entry -> {
            if (Files.isWritable(entry)) return true;
            return false;
        };

         */

        // Obtain and manage a directory stream of writable files.
        try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Path.of(dirname), how)) {

            System.out.println("Directory of " + dirname);

            Iterator<Path> iterator = dirStrm.iterator();
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
