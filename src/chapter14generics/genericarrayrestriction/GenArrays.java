package chapter14generics.genericarrayrestriction;

class Gen<T extends Number> {
    T ob;

    T vals[];

    Gen(T o, T[] nums) {
        ob = o;

        // This statement is illegal.
        // vals = new T[10]; // can't create an array of T

        // But, this statement is OK.
        vals = nums; // OK to assign reference to existent array

    }
}

class GenArrays {
    public static void main(String[] args) {

        Integer[] n = {1, 2, 3, 4, 5};

        Gen<Integer> iOb = new Gen<>(50, n);

        // Can't create an array of type-specific generic reference
        // Gen<Integer> gens[] = new Gen<Integer>[10];

        // This is OK.
        Gen<?> gens[] = new Gen<?>[10]; // OK

        Gen[] raw = new Gen[10];
        raw[0] = new Gen(13, n);

    }
}
