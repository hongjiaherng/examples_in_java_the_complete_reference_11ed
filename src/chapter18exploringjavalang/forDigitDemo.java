package chapter18exploringjavalang;

class forDigitDemo {
    public static void main(String[] args) {

        int num = 15;
        char digit = Character.forDigit(num, 16);
        System.out.println("Char representation of " + num + " in radix 16 is " + digit);

        int num2 = 1;
        char digit2 = Character.forDigit(num2, 2);
        System.out.println("Char representation of " + num2 + " in radix 2 is " + digit2); // 0 <= num2 < radix

        char digit3 = 'F';
        int num3 = Character.digit(digit3, 16);
        System.out.println(num3);

    }
}
