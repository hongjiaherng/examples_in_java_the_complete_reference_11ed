package chapter12enumerationsautoboxingannotations.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// An annotation type declaration.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

class Meta {

    // Annotate a method
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        Meta obj = new Meta();

        // Obtain the annotation for this method
        // and display the values of the members.

        try {
            // First, get a Class object that represents this class.
            Class<?> c = obj.getClass(); // Class<?> c = Meta.class;
            System.out.println(c);

            // Now, get a Method object that represents this method.
            Method m = c.getMethod("myMeth");
            System.out.println(m);

            // Next, get the annotation for this class.
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno);

            // Finally, display the values.
            System.out.println(anno.str() + " " + anno.val());

        } catch (NoSuchMethodException | NullPointerException e) {
            System.out.println("Method Not Found.");
        }

    }

    public static void main(String[] args) {
        myMeth();
    }

}

