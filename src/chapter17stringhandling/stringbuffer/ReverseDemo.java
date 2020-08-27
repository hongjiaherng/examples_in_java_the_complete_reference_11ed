package chapter17stringhandling.stringbuffer;

class ReverseDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abcdef");

        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
