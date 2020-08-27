package chapter15lambdaexpression.constuctorreferences;

interface MyFunc3<R, T> {
    R func(T n);
}

class MyClass3<T> {
    private T val;

    MyClass3(T v) {
        val = v;
    }

    MyClass3() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class MyClass4 {
    String str;

    MyClass4(String s) {
        str = s;
    }

    MyClass4() {
        str = "";
    }

    String getVal() {
        return str;
    }
}

class ConstructorRefDemo3 {

    static <R, T> R myClassFactory(MyFunc3<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {

        MyFunc3<MyClass3<Double>, Double> myClassCons = MyClass3<Double>::new;
        MyClass3<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("val in mc is " + mc.getVal());

        MyFunc3<MyClass4, String> myClassCons2 = MyClass4::new;
        MyClass4 mc2 = myClassFactory(myClassCons2, "Lambda");
        System.out.println("str in mc2 is " + mc2.getVal());

    }
}
