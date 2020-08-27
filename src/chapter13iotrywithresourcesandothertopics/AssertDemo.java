package chapter13iotrywithresourcesandothertopics;

class AssertDemo {

    static int val = 3;

    static int getNum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;

        for (int i = 0; i < 10; i ++) {
            n = getNum();

            assert n > 0 : "n is not positive!"; // will fail when n is 0

            System.out.println("n is " + n);
        }
    }
}
