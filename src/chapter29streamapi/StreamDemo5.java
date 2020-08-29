// Use map() to create a new stream that contains only selected aspects of
// the original stream.

package chapter29streamapi;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

class StreamDemo5 {
    public static void main(String[] args) {
        // A list of names, phone numbers, and e-mail addresses.
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Original values in myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phonenum + " " + a.email));
        System.out.println();

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        System.out.println("List of names and phone numbers: ");
        nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phonenum));
        System.out.println();

        Stream<NamePhone> nameAndPhone2 = myList.stream().
                filter((a) -> a.name.equals("James")).
                map((a) -> new NamePhone(a.name, a.phonenum));

        nameAndPhone2.forEach((a) -> System.out.println(a.name + " " + a.phonenum));
    }
}
