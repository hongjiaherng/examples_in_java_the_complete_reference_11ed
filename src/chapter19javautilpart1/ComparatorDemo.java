package chapter19javautilpart1;

import java.util.*;

class MyComp implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {

        // Reverse the comparison.
        return bStr.compareTo(aStr);

        // No need to override equals or the default methods.
    }
}

class ComparatorDemo {
    public static void main(String[] args) {

        // Create a tree set with reversed order.
        TreeSet<String> ts = new TreeSet<>(new MyComp());

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

        System.out.println();

        // Create a tree set that reversed the order of reversed-order tree set (natural order).
        TreeSet<String> ts2 = new TreeSet<>(new MyComp().reversed());

        ts2.add("C");
        ts2.add("A");
        ts2.add("B");
        ts2.add("E");
        ts2.add("F");
        ts2.add("D");

        for (String element : ts2) {
            System.out.print(element + " ");
        }

    }
}
