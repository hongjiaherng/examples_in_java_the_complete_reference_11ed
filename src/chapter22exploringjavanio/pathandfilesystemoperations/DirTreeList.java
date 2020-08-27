package chapter22exploringjavanio.pathandfilesystemoperations;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Create a custom version of SimpleFileVisitor that overrides the visitFile() method. (I used anonymous class instead)
/*
class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

 */

class DirTreeList {
    public static void main(String[] args) {

        String dirname = "\\Users\\USER\\IdeaProjects\\Examples in Java The Complete Reference\\src\\chapter22exploringjavanio\\pathandfilesystemoperations\\pathdemo";

        FileVisitor<Path> visitor = new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        };

        System.out.println("Directory tree starting with " + dirname + ":\n");

        try {
            Files.walkFileTree(Path.of(dirname), visitor);
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }

    }
}
