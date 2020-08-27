package chapter9packagesandinterfaces.client;

class Client implements Callback {

    @Override
    public void callback(int param) {
        System.out.println("callback called with " + param);

    }

    void nonIfaceMeth() {
        System.out.println("Classes that implement interfaces " + "may also define other members, too.");
    }
}
