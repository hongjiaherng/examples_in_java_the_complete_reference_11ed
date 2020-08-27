package chapter14generics.wildcard;

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}

class WildcardDemo {
    public static void main(String[] args) {

        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iOb = new Stats<Integer>(inums);
        double v = iOb.average();
        System.out.println("iOb average is " + v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dOb = new Stats<Double>(dnums);
        double w = dOb.average();
        System.out.println("dOb average is " + w);

        Float fnums[] = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Stats<Float> fOb = new Stats<Float>(fnums);
        double x = fOb.average();
        System.out.println("fOb average is " + x);

        System.out.print("Averages of iOb and dOb ");
        if (iOb.sameAvg(dOb)) {
            System.out.println("are the same.");
        } else {
            System.out.println("differ.");
        }

        System.out.print("Averages of iOb and fOb ");
        if (iOb.sameAvg(fOb)) {
            System.out.println("are the same.");
        } else {
            System.out.println("differ.");
        }

    }
}
