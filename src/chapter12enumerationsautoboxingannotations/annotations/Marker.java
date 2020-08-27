package chapter12enumerationsautoboxingannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {}

class Marker {

    @MyMarker
    public static void myMeth() {
        Marker obj = new Marker();

        try {
            Method m = obj.getClass().getMethod("myMeth");

            if (m.isAnnotationPresent(MyMarker.class)) {
                System.out.println("MyMarker is present.");

                MyMarker anno = m.getAnnotation(MyMarker.class);

                System.out.println(anno);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
