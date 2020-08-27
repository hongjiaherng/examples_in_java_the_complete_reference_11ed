package chapter15lambdaexpression;

// Functional interface
interface MyNumber {
    double getValue();
}

class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNum; // declare an interface reference

        // Here, the lambda expression is simply a constant expression.
        // When it is assigned to myNum, a class instance is constructed
        // in which the lambda expression implements the getValue() method in MyNumber.
        myNum = () -> 123.45;

        // Call getValue(), which is provided by the previously assigned lambda expression.
        System.out.println("A fixed value: " + myNum.getValue());

        // Here, a more complex expression is used.
        myNum = () -> Math.random() * 100;

        // These call the lambda expression in the previous line.
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());

        // A lambda expression must be compatible with the method
        // defined by the functional interface. Therefore, this won't work:
        // myNum = () -> "123.03"; // Error!

        myNum = new MyNumber() {
            @Override
            public double getValue() {
                return 123.45;
            }
        };
        System.out.println(myNum.getValue());

        myNum = new MyNumber() {
            @Override
            public double getValue() {
                return Math.random() * 100;
            }
        };
        System.out.println(myNum.getValue());

    }
}
