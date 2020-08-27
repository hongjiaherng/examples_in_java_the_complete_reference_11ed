package chapter12enumerationsautoboxingannotations.annotations.repeatingannotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Make MyAnno repeatable.
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000;
}

// This is the container annotation.
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}

class RepeatAnno {

    // Repeat MyAnno on myMeth().
    @MyAnno(str = "First annotation", val = -1)
    @MyAnno(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i) {
        RepeatAnno obj = new RepeatAnno();

        try {
            Class<?> c = obj.getClass();

            // Obtain the annotations for myMeth().
            Method m = c.getMethod("myMeth", String.class, int.class);

            // Display the repeated MyAnno annotations.
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);

            System.out.println();

            Annotation[] anno2 = m.getAnnotationsByType(MyAnno.class);
            for (Annotation a : anno2) {
                System.out.println(a);
            }

            for (i = 0; i < anno2.length; i++) {
                System.out.println(anno2[i]);
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);

    }
}
