package chapter18exploringjavalang;

class IsDemo {
    public static void main(String[] args) {
        char[] a = {'a', 'b', '5', '?', 'A', ' '};

        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i])) {
                System.out.println(a[i] + " is a digit.");
            }
            if (Character.isLetter(a[i])) {
                System.out.println(a[i] + " is a letter.");
            }
            if (Character.isWhitespace(a[i])) {
                System.out.println(a[i] + " is whitespace.");
            }
            if (Character.isUpperCase(a[i])) {
                System.out.println(a[i] + " is uppercase.");
            }
            if (Character.isLowerCase(a[i])) {
                System.out.println(a[i] + " is lowercase.");
            }
        }
        System.out.println("Max radix: " + Character.MAX_RADIX);
        System.out.println("Min radix: " + Character.MIN_RADIX);
        System.out.println(Character.BYTES);
        System.out.println(Character.TYPE);
        System.out.println("Min value of Character: " + Character.MIN_VALUE);
        System.out.println("Max value of Character: " + Character.MAX_VALUE);
        System.out.println(Character.SIZE);
        if (Character.isDefined('\u0021')) {
            System.out.println("\"\u0021\" is defined by Unicode.");
        }
        System.out.println(Character.isJavaIdentifierStart('p'));
    }
}
