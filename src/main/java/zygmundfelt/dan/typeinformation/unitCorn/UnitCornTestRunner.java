package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
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
    static String runTests(Class cls) {

        return null;
    }

    static ArrayList<String> getJUnitAnnotatedMethods(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<String> annotatedMethods = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().substring(0, 15).equals("@org.junit.Test")) {
                    annotatedMethods.add(m.getName());
                }
            }
        }

        return annotatedMethods;
    }

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.UnitCornTestRunner");
            System.out.println(cls.getName());
            ArrayList<String> list = getJUnitAnnotatedMethods(cls);
            for(String s : list) {
                System.out.println(s);
            }
            Method[] methods = cls.getDeclaredMethods();
            for(Method m : methods) {
                System.out.println(m.getName());
                Annotation[] annotations = m.getAnnotations();
                for(Annotation a : annotations) {
                    System.out.println(a.toString());
                }
            }


        } catch (Exception e) {
            System.out.println("BOOOO.");
        }

    }

}