package chapter17stringhandling.string;

class Concat {
    public static void main(String[] args) {
        String longStr = "This could have been " +
                "a very long line that would have " +
                "wrapped around. But String concatenation " +
                "prevents this.";
        System.out.println(longStr);
    }
}
