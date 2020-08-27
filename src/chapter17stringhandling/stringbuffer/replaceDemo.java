package chapter17stringhandling.stringbuffer;

class replaceDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This is a test.");

        sb.replace(5, 7, "was");
        System.out.println("After replace: " + sb);
        System.out.println("Capacity = " + sb.capacity());
        System.out.println("Length = " + sb.length());
        System.out.println(sb.codePointAt(0));
    }
}
