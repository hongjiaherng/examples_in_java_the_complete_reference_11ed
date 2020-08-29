// Use collect() to create a List and a Set from a stream.

package chapter29streamapi.streamdemo7;

import java.util.*;
import java.util.stream.Collectors;
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

class StreamDemo7 {
    public static void main(String[] args) {

        // A list of names, phone numbers, and e-mail addresses.
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // Use collect to create a List of the names and phone numbers.
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Names and phone numbers in a List:");
        for (NamePhone e : npList) {
            System.out.println(e.name + ": " + e.phonenum);
        }

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // Now, create a Set by use of collect().
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in a Set:");
        for (NamePhone e : npSet) {
            System.out.println(e.name + ": " + e.phonenum);
        }
        System.out.println();

        // Transform a stream into LinkedList.
        // We have to obtain the stream again because the last operation .collect() has already consumed the stream.
        // It is a terminal operation.
        nameAndPhone = myList.parallelStream().map((a) -> new NamePhone(a.name, a.phonenum));
        LinkedList<NamePhone> npLinkedList = nameAndPhone.collect(
                () -> new LinkedList<>(),
                (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));

        System.out.println("Names and phone numbers in a LinkedList:");
        for (NamePhone e : npLinkedList) {
            System.out.println(e.name + ": " + e.phonenum);
        }
        System.out.println();

        // Transform a stream into HashSet.
        // We can use method/ constructor reference as well instead of lambda expression.
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        HashSet<NamePhone> npHastSet = nameAndPhone.collect(
                HashSet::new,
                HashSet::add,
                HashSet::addAll);

        System.out.println("Names and phone numbers in a HashSet:");
        for (NamePhone e : npHastSet) {
            System.out.println(e.name + ": " + e.phonenum);
        }
        System.out.println();
    }
}
