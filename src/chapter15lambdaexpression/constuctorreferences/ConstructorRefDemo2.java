package chapter15lambdaexpression.constuctorreferences;

interface MyFunc2<T> {
    MyClass2<T> func(T n);
}

class MyClass2<T> {
    private T val;

    MyClass2(T v) {
        val = v;
    }

    MyClass2() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

class ConstructorRefDemo2 {
    public static void main(String[] args) {

        MyFunc2<Integer> myClassCons = MyClass2<Integer>::new;

        MyClass2<Integer> mc = myClassCons.func(100);

        System.out.println("val in mc is " + mc.getVal());

    }
}
