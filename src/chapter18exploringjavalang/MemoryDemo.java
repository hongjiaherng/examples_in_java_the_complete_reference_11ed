package chapter18exploringjavalang;

class MemoryDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime(); // Can't instantiate an object but can obtain the reference to the object
        long mem1, mem2;
        Integer[] someints = new Integer[1000];

        System.out.println("Total memory is: " + r.totalMemory());
        mem1 = r.freeMemory();
        System.out.println("Initial free memory: " + mem1);

        r.gc();
        mem1 = r.freeMemory();
        System.out.println("Free memory after garbage collection: " + mem1);

        for (int i = 0; i < 1000; i++) {
            someints[i] = Integer.valueOf(i); // allocate integers
        }

        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation: " + mem2);
        System.out.println("Memory used by allocation: " + (mem1 - mem2));

        // discard Integers
        for (int i = 0; i < 1000; i++) {
            someints[i] = null;
        }

        r.gc(); // request garbage collection

        mem2 = r.freeMemory();
        System.out.println("Free memory after collecting discarded Integers: " + mem2);


    }
}
