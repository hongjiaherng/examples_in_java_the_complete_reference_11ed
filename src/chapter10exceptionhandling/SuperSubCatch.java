package chapter10exceptionhandling;

class SuperSubCatch {
    public static void main(String[] args) {

        try {
            int a = 0;
            int b = 42 / a;

        } catch (ArithmeticException e) {
            System.out.println("This is never reached.");
        } catch (Exception e) {
            System.out.println("Generic Exception catch.");
        }

    }
}
