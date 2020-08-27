package chapter14generics.simpleexample;

class Gen<T> {
    T obj;

    Gen(T o) {
        obj = o;
    }

    T getObj() {
        return obj;
    }

    void showType() {
        System.out.println("Type of T is " + obj.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {

        Gen<Integer> iObj;
        iObj = new Gen<Integer>(88);

        iObj.showType();

        int v = iObj.getObj();
        System.out.println("value: " + v);

        System.out.println();

        Gen<String> strObj = new Gen<String>("Generics Test");

        strObj.showType();

        String str = strObj.getObj();
        System.out.println("value: " + str);


        System.out.println();
        System.out.println(iObj);
        System.out.println(strObj);
        System.out.println();

        System.out.println(iObj.getObj());
        System.out.println(iObj.getObj().intValue());

    }
}
