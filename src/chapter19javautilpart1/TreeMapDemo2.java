// Use a comparator to sort accounts by last name.

package chapter19javautilpart1;

import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

// Compare last whole words in two strings.
class TComp implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        k = aStr.substring(i + 1).compareToIgnoreCase(bStr.substring(j + 1));

        if (k == 0) { // last names match, check entire name
            return aStr.compareToIgnoreCase(bStr);
        } else {
            return k;
        }
    }

    // No need to override equals.
}

class TreeMapDemo2 {
    public static void main(String[] args) {
        // Create a tree map.
        TreeMap<String, Double> tm = new TreeMap<>(new TComp());

        // Put elements to the map.
        tm.put("John Doe", 3434.34);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1378.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith", -19.08);

        // Get a set of the entries.
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // Display the elements.
        for (Map.Entry<String, Double> element : set) {
            System.out.print(element.getKey() + " ");
            System.out.println(element.getValue());
        }
        System.out.println();

        // Deposit 1000 into John Doe's account.
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);

        System.out.println("John Doe's new balance: " + tm.get("John Doe"));

    }
}
