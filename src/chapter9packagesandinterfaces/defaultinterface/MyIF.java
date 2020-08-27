package chapter9packagesandinterfaces.defaultinterface;

public interface MyIF {

    int getNumber();

    default String getString() {
        return "Default String";
    }
}
