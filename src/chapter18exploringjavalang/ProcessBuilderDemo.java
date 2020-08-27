package chapter18exploringjavalang;

import java.io.IOException;

class ProcessBuilderDemo {
    public static void main(String[] args) {
         try {
             // create a java file called testfile
             ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile.java");
             proc.start();
         } catch (IOException e) {
             System.out.println("Error executing notepad.");
         }
    }
}
