// Extend Phaser and override onAdvance() so that only a specific number of phases are executed.

package chapter28concurrencyutilities.synchronizer.phaser;

import java.util.concurrent.Phaser;

class PhaserDemo2 {
    public static void main(String[] args) {

        MyPhaser phsr = new MyPhaser(1, 4);

        System.out.println("Starting\n");

        new Thread(new MyThread2(phsr, "A")).start();
        new Thread(new MyThread2(phsr, "B")).start();
        new Thread(new MyThread2(phsr, "C")).start();

        // Wait for the specified number of phases to complete.
        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }
        System.out.println("The Phaser is terminated");

    }
}

// Extend MyPhaser to allow only a specific number of phases to be executed.
class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    // Override onAdvance() to execute the specified number of phases.

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        // This println() statement is for illustration only.
        // Normally, onAdvance() will not display output.
        System.out.println("Phase " + phase + " completed.\n");

        // If all phases have completed, return true.
        if (phase == numPhases || registeredParties == 0) {
            return true;
        }
        // Otherwise, return false.
        return false;
    }
}

// A thread of execution that uses a Phaser.
class MyThread2 implements Runnable {
    Phaser phsr;
    String name;

    MyThread2(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " + phsr.getPhase());

            phsr.arriveAndAwaitAdvance();

            // Pause a bit to prevent jumbled output. This is for illustration only.
            // It is not required for the proper operation of the phaser.
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
