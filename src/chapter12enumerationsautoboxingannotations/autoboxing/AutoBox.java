package chapter12enumerationsautoboxingannotations.autoboxing;

public class AutoBox {
    public static void main(String[] args) {

        Integer iObj = 100; // autobox an int

        int i = iObj; // auto-unbox

        System.out.println(i + " " + iObj);

    }
}
