// A simple example of LocalDate and LocalTime.

package chapter30regexandotherpackages.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class DateTimeDemo {
    public static void main(String[] args) {

        LocalDate curDate = LocalDate.now();
        System.out.println(curDate);

        LocalTime curTime = LocalTime.now();
        System.out.println(curTime);

        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime);

        curTime = curDateTime.toLocalTime();
        System.out.println(curTime);

        curDate = curDateTime.toLocalDate();
        System.out.println(curDate);
    }
}
