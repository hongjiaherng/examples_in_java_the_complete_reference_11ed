package chapter12enumerationsautoboxingannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
    String str();
    int val();
}

class Meta2 {

    @MyAnno2(str = "Two Parameters", val = 19)
    public static void myMeth(String str, int i) {
        Meta2 obj = new Meta2();

        try {

            Class<?> c = obj.getClass();
            System.out.println(c);

            Method m = c.getMethod("myMeth", String.class, int.class);
            System.out.println(m);

            MyAnno2 anno = m.getAnnotation(MyAnno2.class);
            System.out.println(anno);

            System.out.println(anno.str() + " " + anno.val());

        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
