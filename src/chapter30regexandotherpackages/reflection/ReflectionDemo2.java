// Show public methods.

package chapter30regexandotherpackages.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class ReflectionDemo2 {
    public static void main(String[] args) {
        A a = new A();
        Class<?> c = a.getClass();
        System.out.println("Public methods:");
        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            int modifiers = methods[i].getModifiers();
            if (Modifier.isPublic(modifiers)) {
                System.out.println(" " + methods[i].getName());
            }
        }
    }
}

class A {
    public void a1() {
    }

    public void a2() {
    }

    protected void a3() {
    }

    private void a4() {
    }
}
