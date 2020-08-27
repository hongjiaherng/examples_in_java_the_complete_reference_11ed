package chapter12enumerationsautoboxingannotations.autoboxing.typewrappers;

public class Wrap {
    public static void main(String[] args) {

        Integer iObj = Integer.valueOf(100); // boxing
        int i = iObj.intValue(); // unboxing

        System.out.println(i + " " + iObj);
    }
}
