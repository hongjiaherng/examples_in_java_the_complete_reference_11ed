package chapter9packagesandinterfaces.client;

class AnotherClient implements Callback {

    @Override
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + (p * p));
    }
}
