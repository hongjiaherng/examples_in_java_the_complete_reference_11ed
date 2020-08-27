package chapter9packagesandinterfaces.multipleinheritanceissues;

interface Alpha {
    void save();

    default void reset() {
        System.out.println("Resetting in Alpha...");
    }
}
