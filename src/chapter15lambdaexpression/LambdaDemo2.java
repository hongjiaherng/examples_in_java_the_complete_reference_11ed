package chapter15lambdaexpression;

interface NumericTest {
    boolean test(int n);
}

class LambdaDemo2 {
    public static void main(String[] args) {
        NumericTest isEven = n -> (n % 2) == 0;

        if (isEven.test(10)) System.out.println("10 is even");
        if (!isEven.test(9)) System.out.println("9 is not even");

        NumericTest isNonNeg = (n) -> n >= 0;

        if (isNonNeg.test(1)) System.out.println("1 is non-negative");
        if (!isNonNeg.test(-1)) System.out.println("-1 is negative");

        // Using the anonymous class way
        isEven = new NumericTest() {
            @Override
            public boolean test(int n) {
                return (n % 2) == 0;
            }
        };
        System.out.println(isEven.test(1));

        isNonNeg = new NumericTest() {
            @Override
            public boolean test(int n) {
                return n >= 0;
            }
        };
        System.out.println(isNonNeg.test(10));

    }
}
