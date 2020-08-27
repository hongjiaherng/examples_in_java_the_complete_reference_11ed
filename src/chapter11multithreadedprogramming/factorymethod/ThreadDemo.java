package chapter11multithreadedprogramming.factorymethod;

class NewThread implements Runnable {

    Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }

    public static NewThread createAndStart() {
        NewThread myThrd = new NewThread();
        myThrd.t.start();
        return  myThrd;
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        NewThread nt = NewThread.createAndStart();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread exiting.");
        }
    }
}
