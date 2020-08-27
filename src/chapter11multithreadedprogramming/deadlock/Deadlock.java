package chapter11multithreadedprogramming.deadlock;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered A.foo");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("A Interrupted");
        }



        System.out.println(name + " trying to call B.last()");
        b.lastB(); // MainThread owns the monitor on a and is waiting for the monitor on b
    }

    synchronized void lastA() {
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("B Interrupted");
        }



        System.out.println(name + " trying to call A.last()");
        a.lastA(); // RacingThread owns the monitor on b and is waiting for the monitor on a
    }

    synchronized void lastB() {
        System.out.println("Inside B.last");
    }
}

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;

    Deadlock() {
        Thread.currentThread().setName("MainThread");
        t = new Thread(this, "RacingThread");
    }

    void deadlockStart() {
        t.start();
        a.foo(b);
        System.out.println("Back in main thread");
    }

    public void run() {
        b.bar(a);
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        Deadlock d1 = new Deadlock();

        d1.deadlockStart();

    }
}
