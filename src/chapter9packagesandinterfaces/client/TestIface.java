package chapter9packagesandinterfaces.client;

class TestIface {
    public static void main(String[] args) {

        Client c = new Client();
        c.callback(42);

        c.nonIfaceMeth();

        Callback callback = c;
        callback.callback(52);
    }
}
