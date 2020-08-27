package chapter15lambdaexpression.methodreferences;

interface StringFunc2 {
    String func(String n);
}

class MyStringOps2 {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

class MethodRefDemo2 {

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Lambdas add power to Java";
        String outStr;

        MyStringOps2 strOps2 = new MyStringOps2();

        outStr = stringOp(strOps2::strReverse, inStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);

    }
}
