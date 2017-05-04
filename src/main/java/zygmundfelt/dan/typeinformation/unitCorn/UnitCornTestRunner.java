package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.*;


public class UnitCornTestRunner {

    ArrayList<Result> results;

    static Exception runTest(Class c, String methodName) {

        Object o;
        try {
            o = c.newInstance();
        } catch(Exception e) {
            return e;
        }

        Method method = getMethod(c, methodName);

        try {
            method.invoke(o);
        } catch (Exception e) {
            return e;
        }

        return null;

    }

    static Method getMethod(Class c, String methodName) {
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods) {
            if(m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    String runTests(Class c) {

        return null;
    }

    @Test
    String[] getJUnitAnnotatedMethods(Class c) {
        return null;
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