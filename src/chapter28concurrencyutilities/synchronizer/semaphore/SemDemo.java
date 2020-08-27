package chapter28concurrencyutilities.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

class SemDemo {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1); // Specify the number of thread allowed to access the shared resources at one time

        new Thread(new IncThread(sem, "Thread A")).start();
        new Thread(new DecThread(sem, "Thread B")).start();
    }
}

// A shared resource.
class Shared {
    static int count = 0;
}

// A thread of execution that increments count.
class IncThread implements Runnable {

    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {

        System.out.println("Starting " + name);

        try {
            // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            // Now, access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count++; // return count then increment
                System.out.println(name + ": " + Shared.count);

                // Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Release the permit.
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}

// A thread of execution that decrements count.
class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            // Now, access shared resources.
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                // Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Release the permit.
        System.out.println(name + " release the permits.");
        sem.release();
    }
}