// Parse a date and time.

package chapter30regexandotherpackages.dateapi;

import java.time.*;
import java.time.format.*;

public class DateTimeDemo4 {
    public static void main(String[] args) {

        // Obtain a LocalDateTime object by parsing a date and time string.
        LocalDateTime curDateTime = LocalDateTime.parse(
                "September 1, 2020 06:26 PM", DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a"));

        // Now, display the parsed date and time.
        System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("MMMM d',' yyyy h':'mm a")));

    }
}
