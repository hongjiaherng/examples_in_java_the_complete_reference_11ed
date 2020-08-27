package chapter14generics.nongenericsvsgenerics;

class NonGen {
    Object obj;

    NonGen(Object o) {
        obj = o;
    }

    Object getObj() {
        return obj;
    }

    void showType() {
        System.out.println("Type of obj is " + obj.getClass().getName());
    }
}

class NonGenDemo {
    public static void main(String[] args) {

        NonGen iObj;
        iObj = new NonGen(88);
        iObj.showType();
        int v = (Integer) iObj.getObj();
        System.out.println("value: " + v);

        System.out.println();

        NonGen strObj = new NonGen("Non-Generics Test");
        strObj.showType();
        String str = (String) strObj.getObj();
        System.out.println("value: " + str);

        System.out.println();

        // This compiles, but is conceptually wrong!
        iObj = strObj;
        int a = (Integer) iObj.getObj(); // run-time error!
        System.out.println(a);

    }
}
