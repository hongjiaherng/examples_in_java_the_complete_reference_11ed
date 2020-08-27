package chapter14generics.genericconstructors;

class GenCons {
    private double val;

    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }
}

class GenConsDemo {
    public static void main(String[] args) {

        GenCons test = new GenCons(Integer.valueOf(100));
        GenCons test2 = new GenCons(Float.valueOf(123.5f));

        test.showVal();
        test2.showVal();

    }
}
