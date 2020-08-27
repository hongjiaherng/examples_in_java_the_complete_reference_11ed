package chapter14generics.genericinterface;

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {

    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    @Override
    public T min() {
        T v = vals[0];

        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    @Override
    public T max() {
        T v = vals[0];

        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

class GenIFDemo {
    public static void main(String[] args) {

        Integer inums[] = {3, 6, 2, 8, 6};
        Character chs[] = {'b', 'r', 'p', 'w'};

        MyClass<Integer> iObj = new MyClass<Integer>(inums);
        MyClass<Character> cObj = new MyClass<Character>(chs);

        System.out.println("Max value in inums: " + iObj.max());
        System.out.println("Min value in inums: " + iObj.min());

        System.out.println();

        System.out.println("Max value in chs: " + cObj.max());
        System.out.println("Min value in chs: " + cObj.min());

    }
}
