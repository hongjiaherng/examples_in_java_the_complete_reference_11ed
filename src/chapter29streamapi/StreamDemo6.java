// Map a Stream to an IntStream.

package chapter29streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class StreamDemo6 {
    public static void main(String[] args) {

        // A list of double values.
        List<Double> myList = new ArrayList<>();

        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);

        System.out.print("Original values in myList: ");
        myList.stream().forEach((a) -> System.out.print(a + " "));
        System.out.println();

        // Map the ceiling of the elements in myList to an IntStream.
        IntStream cStream = myList.stream().mapToInt((a) -> (int) Math.ceil(a));

        System.out.print("The ceilings of the values in myList: ");
        cStream.forEach((a) -> System.out.print(a + " "));

    }
}
