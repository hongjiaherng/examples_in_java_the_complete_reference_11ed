// Use wildcard and quantifier.

package chapter30regexandotherpackages.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr5 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("e.+d");
        Matcher mat = pat.matcher("extend cup end table");

        while (mat.find()) {
            System.out.println("Match: " + mat.group());
        }
        // The result is called greedy behavior.
    }
}
