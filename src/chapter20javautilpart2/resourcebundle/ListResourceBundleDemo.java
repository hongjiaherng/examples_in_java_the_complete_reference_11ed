package chapter20javautilpart2.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

class ListResourceBundleDemo {
    public static void main(String[] args) {
        // Load the default bundle.
        ResourceBundle rd = ResourceBundle.getBundle("chapter20javautilpart2.resourcebundle.SampleRB");

        System.out.println("English version: ");
        System.out.println("String for Title key: " + rd.getString("title"));

        System.out.println("String for StopText key: " + rd.getString("StopText"));

        System.out.println("String for StartText key: " + rd.getString("StartText"));

        // Load the German bundle.
        rd = ResourceBundle.getBundle("chapter20javautilpart2.resourcebundle.SampleRB", Locale.GERMAN);

        System.out.println("\nGerman version: ");
        System.out.println("String for Title key: " + rd.getString("title"));

        System.out.println("String for StopText key: " + rd.getString("StopText"));

        System.out.println("String for StartText key: " + rd.getString("StartText"));


        // Load the Chinese bundle.
        rd = ResourceBundle.getBundle("chapter20javautilpart2.resourcebundle.SampleRB", Locale.CHINESE);

        System.out.println("\nChinese version: ");
        System.out.println("String for Title key: " + rd.getString("title"));

        System.out.println("String for StopText key: " + rd.getString("StopText"));

        System.out.println("String for StartText key: " + rd.getString("StartText"));
    }
}
