package chapter11multithreadedprogramming.suspendresume;

class NewThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread obj1 = new NewThread("One");
        NewThread obj2 = new NewThread("Two");

        System.out.println(obj1.t.getState());

        obj1.t.start();
        obj2.t.start();

        try {
            Thread.sleep(1000);

            obj1.mySuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            obj1.myResume();
            System.out.println("Resuming thread One");

            obj2.mySuspend();
            System.out.println(obj2.t.getState());
            System.out.println("Suspending thread Two");
            System.out.println(obj2.t.getState());
            Thread.sleep(1000);
            obj2.myResume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println(Thread.currentThread().getState());
        try {
            System.out.println("Waiting for threads to finish.");
            obj1.t.join();
            obj2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        Thread.State ts = obj2.t.getState();
        System.out.println(obj1.t.getState());
        System.out.println(ts);

        if (ts == Thread.State.TERMINATED) {
            System.out.println("Child thread 2 is terminated.");
        }

        System.out.println("Main thread exiting.");
    }
}
