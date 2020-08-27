package chapter8inheritance;

class Aa {
    int i;
    int j;

    Aa(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

class Bb extends Aa {
    int k;

    Bb(int i, int j, int k) {
        super(i, j);
        this.k = k;
    }

    @Override
    void show() {
        System.out.println("k: " + k);
    }
}

public class OverrideTest {

    public static void main(String[] args) {
        Bb subObj = new Bb(1, 2, 3);

        subObj.show();

        Aa supObj = new Aa(1, 2);
        supObj.show();
    }
}
