package chapter20javautilpart2;

import java.util.Formatter;

class FormatDemo2 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();


        for (double i = 1.23; i < 1.0e+6; i *= 100) {
            fmt.format(" %f  %e", i, i);
            System.out.println(fmt);
        }
        fmt.close();

        Formatter fmt2 = new Formatter();

        fmt2.format("%a", 512.0);
        System.out.println(fmt2);

        fmt2.close();

    }
}
