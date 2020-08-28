// Demonstrate the use of a combiner with reduce().

package chapter29streamapi;

import java.util.ArrayList;

class StreamDemo3 {
    public static void main(String[] args) {

        // This is a list of double values.
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        double productOfSqrRoots = myList.parallelStream().reduce(
                1.0,
                (a, b) -> a * Math.sqrt(b),
                (a, b) -> a * b
        );

        System.out.println("Product of square roots: " + productOfSqrRoots);


        // This won't work. !! VERY HARD TO UNDERSTAND !!
        // In this version of reduce(), ACCUMULATOR and COMBINER function are one and the same.
        // This results in an error because when TWO PARTIAL RESULTS ARE COMBINED, THEIR SQUARE
        // ROOTS ARE MULTIPLIED TOGETHER RATHER THAN THE PARTIAL RESULTS, themselves.
        double productOfSqrRoots2 = myList.parallelStream().reduce(
                1.0,
                (a, b) -> a * Math.sqrt(b)
        );

        System.out.println(productOfSqrRoots2);
    }
}
