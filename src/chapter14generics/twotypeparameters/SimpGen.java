package chapter14generics.twotypeparameters;

class TwoGen<T, V> {
    T ob1;
    V ob2;

    TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    void showTypes() {
        System.out.println("Type of T is " + ob1.getClass().getName());
        System.out.println("Type of V is " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

class SimpGen {
    public static void main(String[] args) {

        TwoGen<Integer, String> twoGenObj = new TwoGen<>(88, "Generics");

        twoGenObj.showTypes();

        int v = twoGenObj.getOb1();
        System.out.println("Value: " + v);

        String str = twoGenObj.getOb2();
        System.out.println("Value: " + str);



    }
}
