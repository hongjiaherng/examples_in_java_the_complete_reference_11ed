package chapter12enumerationsautoboxingannotations.autoboxing;

class AutoBox4 {
    public static void main(String[] args) {

        Integer iObj = 100;
        Double dObj = 98.6;

        dObj = dObj + iObj;
        System.out.println("dObj after expression: " + dObj);

    }
}
