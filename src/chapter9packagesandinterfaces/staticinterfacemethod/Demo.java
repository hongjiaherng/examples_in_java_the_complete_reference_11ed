package chapter9packagesandinterfaces.staticinterfacemethod;

public class Demo {
    public static void main(String[] args) {
        System.out.println(MyIF.getDefaultNumber());
        // static methods are not inherited by either implementing class or a subinterface
    }
}
