package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.*;


public class UnitCornTestRunner {

    ArrayList<Result> results;

    static String runTest(Class cls, String methodName) {

        Object o;
        try {
            o = cls.newInstance();
        } catch(Exception e) {
            return e.toString();
        }

        Method method = getMethod(cls, methodName);

        try {
            method.invoke(o);
        } catch (Exception e) {
            return e.toString();
        }

        return null;
    }

    static Method getMethod(Class cls, String methodName) {
        Method[] methods = cls.getDeclaredMethods();
        for(Method m : methods) {
            if(m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    @Test
    String runTests(Class cls) {

        return null;
    }

    static ArrayList<String> getJUnitAnnotatedMethods(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<String> annotatedMethods = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().equals("@org.junit.Test")) {
                    annotatedMethods.add(m.getName());
                }
            }
        }

        return annotatedMethods;
    }

    public static void main(String[] args) {
        Method[] methods = UnitCornTestRunner.class.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println(m.getName());
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                System.out.println(a.toString());
            }
        }

    }

}