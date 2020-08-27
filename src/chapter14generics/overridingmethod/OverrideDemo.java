package chapter14generics.overridingmethod;

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        System.out.print("Gen's getOb(): ");
        return ob;
    }
}

class Gen2<T> extends Gen<T> {

    Gen2(T o) {
        super(o);
    }

    @Override
    T getOb() {
        System.out.print("Gen2's getOb(): ");
        return ob;
    }
}

class OverrideDemo {
    public static void main(String[] args) {

        Gen<Integer> iOb = new Gen<Integer>(Integer.valueOf(88));

        Gen2<Integer> iOb2 = new Gen2<Integer>(Integer.valueOf(99));

        Gen2<String> strOb2 = new Gen2<String>("Generics Test");

        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());

    }
}
