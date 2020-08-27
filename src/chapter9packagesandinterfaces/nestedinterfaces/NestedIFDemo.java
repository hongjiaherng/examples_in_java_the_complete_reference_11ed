package chapter9packagesandinterfaces.nestedinterfaces;

class A {

    interface NestedIF {
        boolean isNotNegative(int x);
    }
}

class B implements A.NestedIF {

    @Override
    public boolean isNotNegative(int x) {
        return x > 0 ? true : false;
    }
}

class NestedIFDemo {
    public static void main(String[] args) {

        A.NestedIF nif = new B();

        if (nif.isNotNegative(10))
            System.out.println("10 is not negative");
        if (nif.isNotNegative(-12))
            System.out.println("this won't be displayed");
    }
}
