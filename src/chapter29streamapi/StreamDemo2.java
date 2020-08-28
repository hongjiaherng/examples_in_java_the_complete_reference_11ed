// Demonstrate the reduce() method.

package chapter29streamapi;

import java.util.ArrayList;
import java.util.Optional;

class StreamDemo2 {
    public static void main(String[] args) {

        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        // Two ways to obtain the integer product of the elements in myList
        // by use of reduce().
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        if (productObj.isPresent()) System.out.println("Product as Optional: " + productObj.get());

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);

        int evenProduct = myList.stream().reduce(1, (a, b) -> ((b % 2) == 0) ? a * b : a);
        System.out.println("Product of even number as int: " + evenProduct);
    }
}
