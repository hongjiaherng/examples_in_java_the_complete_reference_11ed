package chapter14generics.bridgemethod;

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }
}

class Gen2 extends Gen<String> {

    Gen2(String o) {
        super(o);
    }

    @Override
    String getOb() {
        System.out.print("You called String getOb(): ");
        return ob;
    }
}

class BridgeDemo {
    public static void main(String[] args) {

        Gen2 strOb2 = new Gen2("Generics Test");

        System.out.println(strOb2.getOb());


    }
}
