package chapter18exploringjavalang;

class Elapsed {
    public static void main(String[] args) {
        long start, end;

        System.out.println("Time a for loop from 0 to 100,000,000");

        // Time a for loop from 0 to 100,000,000

        start = System.nanoTime(); // get starting time
        for (long i = 0; i < 100000000L; i++);
        end = System.nanoTime(); // get ending time

        System.out.println("Elapsed time: " + (end - start));

    }
}
