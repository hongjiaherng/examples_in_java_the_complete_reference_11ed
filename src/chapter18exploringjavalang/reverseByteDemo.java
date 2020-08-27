package chapter18exploringjavalang;

class reverseByteDemo {
    public static void main(String[] args) {
        short s = 10;
        short a = Short.reverseBytes(s);
        System.out.println(a);

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.bitCount(10));
        System.out.println(Integer.bitCount(15));
        System.out.println(Integer.BYTES);
        System.out.println(Short.BYTES);
        System.out.println(Long.BYTES);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.TYPE);
        System.out.println(Integer.class);
    }
}
