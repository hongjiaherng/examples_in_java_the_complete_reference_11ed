package chapter12enumerationsautoboxingannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3 {
    String str();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@What(description = "An annotation test class")
@MyAnno3(str = "Meta3", val = 99)
class Meta3 {

    @What(description = "An annotation test method")
    @MyAnno3(str = "Testing", val = 100)
    public static void myMeth() {
        Meta3 obj = new Meta3();

        try {
            Annotation[] annos = obj.getClass().getAnnotations();

            // Display all annotations for Meta3
            System.out.println("All annotations for Meta3:");
            for (Annotation a : annos) {
                System.out.println(a);
            }

            System.out.println();

            // Display all annotations for myMeth.
            Method m = obj.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("All annotations for myMeth:");
            for (Annotation a : annos) {
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }

    }

    public static void main(String[] args) {
        myMeth();
    }
}
