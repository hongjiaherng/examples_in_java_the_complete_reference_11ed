// Use a quantifier.

package chapter30regexandotherpackages.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr4 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("W+"); // '+': Match one or more
        Matcher mat = pat.matcher("W WW WWW");

        while (mat.find()) {
            System.out.println("Match: " + mat.group()); // Returns the input subsequence matched by the previous match.
        }
    }
}
