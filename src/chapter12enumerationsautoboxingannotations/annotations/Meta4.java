package chapter12enumerationsautoboxingannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno4 {
    String str() default "Testing";
    int val() default 90;
}

class Meta4 {

    // Annotate a method using the default values.
    @MyAnno4()
    public static void myMeth() {
        Meta4 obj = new Meta4();

        try {
            // Obtain the annotation for this method and display the values of the members.
            Class<?> c = obj.getClass();

            Method m = c.getMethod("myMeth");

            MyAnno4 anno = m.getAnnotation(MyAnno4.class);

            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
