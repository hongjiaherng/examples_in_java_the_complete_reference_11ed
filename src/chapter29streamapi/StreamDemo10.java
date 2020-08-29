// Demonstrate trySplit().

package chapter29streamapi;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

class StreamDemo10 {
    public static void main(String[] args) {

        // Create a list of Strings.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Phi");
        myList.add("Omega");

        // Obtain a Stream to the array list.
        Stream<String> myStream = myList.stream();

        // Obtain a Spliterator.
        Spliterator<String> spliterator = myStream.spliterator();

        // Now, split the first iterator.
        Spliterator<String> spliterator2 = spliterator.trySplit();

        // If spliterator could be split, use spliterator2 first.
        if (spliterator2 != null) {
            System.out.println("Output from spliterator2: ");
            spliterator2.forEachRemaining((n) -> System.out.println(n));
        }

        // Now, use the spliterator.
        System.out.println("\nOutput from spliterator: ");
        spliterator.forEachRemaining((n) -> System.out.println(n));


    }
}
