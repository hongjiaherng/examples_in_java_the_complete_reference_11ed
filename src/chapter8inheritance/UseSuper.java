package chapter8inheritance;

class A {
    int i;

    void show() {
        System.out.println("i: " + i);
    }
}

class B extends A {
    int i;

    B(int a, int b) {
        i = b;
        super.i = a;
    }

    void show() {
        System.out.println("i in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
        super.show();
    }
}

public class UseSuper {

    public static void main(String[] args) {
        B subObj = new B(1, 2);

        subObj.show();


    }
}
