package chapter23networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

class URLConnectionDemo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        int c;
        URL hp = new URL("http://www.internic.net");
        URLConnection hpCon = hp.openConnection();

        // get date
        long d = hpCon.getDate();
        if (d == 0) {
            System.out.println("No date information.");
        } else {
            System.out.println("Date: " + new Date(d));
        }

        // Get content type
        System.out.println("Content-Type: " + hpCon.getContentType());

        // Get expiration date
        d = hpCon.getExpiration();
        if (d == 0) {
            System.out.println("No expiration information.");
        } else {
            System.out.println("Expires: " + new Date(d));
        }

        // Get content length
        long len = hpCon.getContentLengthLong();
        if (len == -1) {
            System.out.println("Content length unavailable.");
        } else {
            System.out.println("Content length: " + len);
        }

        if (len != 0) {
            System.out.println("=== Content ===");
            InputStream input = hpCon.getInputStream();
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No content available.");
        }
    }
}
