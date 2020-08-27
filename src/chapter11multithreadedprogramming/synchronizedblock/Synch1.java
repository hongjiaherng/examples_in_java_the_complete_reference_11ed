package chapter11multithreadedprogramming.synchronizedblock;

class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller extends Thread {
    String msg;
    Callme target;

    public Caller(Callme target, String msg) {
        super();
        this.target = target;
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized(target) {
            target.call(msg);
        }
    }
}

public class Synch1 {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller obj1 = new Caller(target, "Hello");
        Caller obj2 = new Caller(target, "Synchronized");
        Caller obj3 = new Caller(target, "World");

        obj1.start();
        obj2.start();
        obj3.start();

        try {
            obj1.join();
            obj2.join();
            obj3.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
