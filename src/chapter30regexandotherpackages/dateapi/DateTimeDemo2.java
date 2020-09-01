// Demonstrate DateTimeFormatter.

package chapter30regexandotherpackages.dateapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

class DateTimeDemo2 {
    public static void main(String[] args) {

        LocalDate curDate = LocalDate.now();
        System.out.println(curDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        LocalTime curTime = LocalTime.now();
        System.out.println(curTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

    }
}
