package chapter9packagesandinterfaces.staticinterfacemethod;

public interface MyIF {

    int getNumber();

    default String getString() {
        return "Default String";
    }

    static int getDefaultNumber() {
        return 0;
    }
}
