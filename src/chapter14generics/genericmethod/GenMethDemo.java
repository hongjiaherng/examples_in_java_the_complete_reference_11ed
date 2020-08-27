package chapter14generics.genericmethod;

class GenMethDemo {

    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Use isIn() on Integers.
        Integer nums[] = {1, 2, 3, 4, 5};

        if (GenMethDemo.<Integer, Integer>isIn(2, nums)) {
            System.out.println("2 is in nums");
        }
        if (!isIn(7, nums)) {
            System.out.println("7 is not in nums");
        }

        System.out.println();

        String[] strings = {"one", "two", "three", "four", "five"};

        if (isIn("two", strings)) {
            System.out.println("two is in strings");
        }
        if (!isIn("seven", strings)) {
            System.out.println("seven is not in strings");
        }

        // Won't compile! Tpes must be compatible.
        /*
        if (isIn("two", nums)) {
            System.out.println("two is in strings");
        }

         */

    }
}
