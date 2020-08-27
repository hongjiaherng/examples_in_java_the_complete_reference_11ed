package chapter9packagesandinterfaces.client;

class TestIface2 {
    public static void main(String[] args) {

        Callback c = new Client();
        AnotherClient obj = new AnotherClient();

        c.callback(42);

        c = obj;
        c.callback(42);
    }
}
