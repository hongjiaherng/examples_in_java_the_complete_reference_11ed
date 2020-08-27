package chapter11multithreadedprogramming;

class CurrentThreadDemo {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();

        System.out.println("Current thread: " + t);
        System.out.println(t.getName());

        t.setName("My Thread");
        System.out.println("After name change: " + t);
        System.out.println(t.getName());

        try {
            for (int n = 6; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
