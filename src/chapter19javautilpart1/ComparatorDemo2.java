package chapter19javautilpart1;

import java.util.*;

class ComparatorDemo2 {
    public static void main(String[] args) {


        // Pass a reverse comparator to TreeSet() via a lambda expression.
        TreeSet<String> ts = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr));

        /*
        Can be write as (for a more simple method):
        TreeSet<String> ts = new TreeSet<>(Comparator.reverseOrder());
         */


        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Display the elements.
        for (String element : ts) {
            System.out.print(element + " ");
        }

    }
}
