package chapter20javautilpart2;

import java.util.StringTokenizer;

class StringTokenizerDemo {

    static String in = "title=Java: The Complete Reference;" +
            "author=Schildt;" +
            "publisher=Oracle Press;" +
            "copyright=2019";

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(in, "=;");

        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}
