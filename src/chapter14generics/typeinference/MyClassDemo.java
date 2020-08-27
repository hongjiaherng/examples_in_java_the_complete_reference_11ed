package chapter14generics.typeinference;

class MyClass<T, V> {
    T ob1;
    V ob2;

    MyClass(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    boolean isSame(MyClass<T, V> o) {
        if (ob1 == o.ob1 && ob2 == o.ob2) {
            return true;
        } else {
            return false;
        }
    }
}

class MyClassDemo {
    public static void main(String[] args) {

        MyClass<Integer, String> mcOb = new MyClass<>(98, "A String");

        System.out.println(mcOb.isSame(new MyClass<>(98, "A String")));

    }
}
