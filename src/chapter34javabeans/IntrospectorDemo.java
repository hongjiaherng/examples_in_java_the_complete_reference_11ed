package chapter34javabeans;

import java.beans.*;

public class IntrospectorDemo {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("chapter34javabeans.Colors");
            BeanInfo beanInfo = Introspector.getBeanInfo(c);

            System.out.println("Properties:");
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (int i = 0; i < propertyDescriptors.length; i++) {
                System.out.println("\t" + propertyDescriptors[i].getName());
            }
            System.out.println("Events:");
            EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
            for (int i = 0; i < eventSetDescriptors.length; i++) {
                System.out.println("\t" + eventSetDescriptors[i].getName());
            }

            System.out.println("Methods:");
            MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();

            for (MethodDescriptor methodDescriptor : methodDescriptors) {
                System.out.println("\t" + methodDescriptor.getName());
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }

}
