// Use a reluctant quantifier.

package chapter30regexandotherpackages.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr6 {
    public static void main(String[] args) {
        // Use reluctant matching behavior.
        Pattern pat = Pattern.compile("e.+?d"); // '?': match zero or one
        Matcher mat = pat.matcher("extend cup end table");

        while (mat.find()) {
            System.out.println("Match: " + mat.group());
        }
    }
}
