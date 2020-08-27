package chapter14generics.rawtype;

class Gen<T> {

    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    T getObj() {
        return obj;
    }

}

class RawDemo {
    public static void main(String[] args) {

        Gen<Integer> iObj = new Gen<Integer>(88);

        Gen<String> strObj = new Gen<String>("Generics Test");

        // Create a raw-type Gen object and give it a Double value.
        Gen raw = new Gen(98.6);

        // Cast here is necessary because type is unknown.
        double d = (Double) raw.getObj();
        System.out.println("value: " + d);

        // The use of a raw type can lead to run-time exceptions. Here are some examples.

        // The following cast causes a run-time error!
        // int i = (Integer) raw.getObj(); // run-time error

        // This assignment overrides type safety.
        strObj = raw; // OK, but potentially wrong
        // String str = strObj.getObj();  // run-time error

        //This assignment also overrides type safety.
        raw = iObj; // OK, but potentially wrong
        // d = (Double) raw.getObj(); // run-time error


    }
}
