package chapter18exploringjavalang;

class VersionDemo {
    public static void main(String[] args) {
        Runtime.Version ver = Runtime.version();

        // Display individual counters.
        System.out.println("Feature release counter: " + ver.feature());
        System.out.println("Interim release counter: " + ver.interim());
        System.out.println("Update release counter: " + ver.update());
        System.out.println("Patch release counter: " + ver.patch());

        System.out.println();

        System.out.println("Build number: " + ver.build());
        System.out.println("Pre-release information, if present: " + ver.pre());
        System.out.println("Optional information: " + ver.optional());
        System.out.println(ver.version());
        System.out.println(Runtime.version());
        Runtime.Version ver2 = Runtime.Version.parse("14.0.1+7");
        System.out.println(ver2.version());
        System.out.println(ver.compareTo(ver2));
        System.out.println(ver2.compareTo(ver));
    }
}
