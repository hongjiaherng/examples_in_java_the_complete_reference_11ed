package chapter10exceptionhandling;

class Exc2 {
    public static void main(String[] args) {
        int d, a;


            d = 0;

        try {
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero.");
        }

        System.out.println("After catch statement.");

    }
}
