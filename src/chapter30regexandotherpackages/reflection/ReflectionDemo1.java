// Demonstrate reflection.

package chapter30regexandotherpackages.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectionDemo1 {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.awt.Dimension");

            System.out.println("Constructors:");
            Constructor<?>[] constructor = c.getConstructors();
            for (Constructor<?> value : constructor) {
                System.out.println(" " + value);
            }

            System.out.println("Fields:");
            Field[] fields = c.getFields();
            for (Field field : fields) {
                System.out.println(" " + field);
            }

            System.out.println("Methods:");
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                System.out.println(" " + method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
