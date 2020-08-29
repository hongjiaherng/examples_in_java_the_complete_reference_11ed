// Use find() to find multiple subsequences.

package chapter30regexandotherpackages.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr3 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("test");
        Matcher mat = pat.matcher("test 1 2 3 test");

        while (mat.find()) {
            System.out.println("test found at index " + mat.start()); // Returns the start index of previous match.
        }
    }
}
