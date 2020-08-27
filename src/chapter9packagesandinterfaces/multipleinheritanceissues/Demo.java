package chapter9packagesandinterfaces.multipleinheritanceissues;

class Demo {
    public static void main(String[] args) {
        Issue obj = new Issue();

        obj.save();
        obj.delete();
        obj.reset();

    }
}
