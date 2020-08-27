package chapter9packagesandinterfaces.client;

class InheritIncomplete extends Incomplete {

    int c;
    int d;

    InheritIncomplete(int x, int y) {
        this.c = x;
        this.d = y;
        System.out.println(a + b);
    }

    @Override
    public void callback(int param) {
        System.out.println(c + d + a + b + param);
    }
}
