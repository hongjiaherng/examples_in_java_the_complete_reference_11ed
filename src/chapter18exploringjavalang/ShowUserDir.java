package chapter18exploringjavalang;

class ShowUserDir {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.compiler"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
    }
}
