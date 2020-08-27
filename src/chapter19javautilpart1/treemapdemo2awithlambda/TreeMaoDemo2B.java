package chapter19javautilpart1.treemapdemo2awithlambda;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TreeMaoDemo2B {
    public static void main(String[] args) {

        Comparator<String> compLastThenFirst = (aStr, bStr) -> {
            int i, j, k;

            i = aStr.lastIndexOf(' ');
            j = bStr.lastIndexOf(' ');
            k = aStr.substring(i + 1).compareToIgnoreCase(bStr.substring(j + 1));

            if (k == 0) {
                return aStr.compareToIgnoreCase(bStr);
            } else {
                return k;
            }
        };

        /*Comparator<String> compLastName = (aStr, bStr) -> {
            int i, j;

            i = aStr.lastIndexOf(' ');
            j = bStr.lastIndexOf(' ');

            return aStr.substring(i + 1).compareToIgnoreCase(bStr.substring(j + 1));

        };

        Comparator<String> compFirstName = (aStr, bStr) -> aStr.compareToIgnoreCase(bStr);

        Comparator<String> compLastThenFirst = compLastName.thenComparing(compFirstName);

*/
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);

        tm.put("John Doe", 3434.34);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1378.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith", -19.08);

        Set<Map.Entry<String, Double>> set = tm.entrySet();

        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }



    }
}
