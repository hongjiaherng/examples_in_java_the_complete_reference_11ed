package chapter13iotrywithresourcesandothertopics.instanceof1;

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A) {
            System.out.println("a is instance of A");
        }
        if (b instanceof B) {
            System.out.println("b is instance of B");
        }
        if (c instanceof C) {
            System.out.println("c is instance of C");
        }
        if (c instanceof A) {
            System.out.println("c can be cast to A");
        }
        if (a instanceof C) {
            System.out.println("a can be cast to C");
        }
        System.out.println();

        A obj;

        obj = d;
        System.out.println("obj now refers to d");

        if (obj instanceof D) {
            System.out.println("obj is instance of D");
        }

        System.out.println();

        obj = c;
        System.out.println("obj now refers to c");
        if (obj instanceof D) {
            System.out.println("obj can be cast to D");
        } else {
            System.out.println("obj cannot be cast to D");
        }

        if (obj instanceof A) {
            System.out.println("obj can be cast to A");
        }

        System.out.println();

        if (a instanceof Object) {
            System.out.println("a may be cast to Object");
        }
        if (b instanceof Object) {
            System.out.println("b may be cast to Object");
        }
        if (c instanceof Object) {
            System.out.println("c may be cast to Object");
        }
        if (d instanceof Object) {
            System.out.println("d may be cast to Object");
        }
    }
}
