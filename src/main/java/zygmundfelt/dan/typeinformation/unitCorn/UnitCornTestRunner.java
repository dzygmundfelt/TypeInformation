package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.*;


public class UnitCornTestRunner {

    static ArrayList<Result> results;

    static Result runTest(Class cls, String methodName) {

        Object o;
        try {
            o = cls.newInstance();
        } catch(Exception e) {
            return new Result(methodName, e.toString());
        }

        Method method = getMethod(cls, methodName);

        try {
            method.invoke(o);
        } catch (Exception e) {
            return new Result(methodName, e.toString());
        }

        return new Result(methodName, "success");
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

    /*
    For testing in test class and testing in main class below
     */
    @Test
    static String runTests(Class cls) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> annotatedMethods = getJUnitAnnotatedMethods(cls);

        for(String s : annotatedMethods) {
            Result result = runTest(cls, s);
            results.add(result); //Added this line to store results. Otherwise all this does is make a string.
            sb.append(result.toString());
        }

        return sb.toString();
    }

    /*
    For testing in test class and testing in main class below
     */
    @Test
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
            System.out.println(runTests(cls));
        } catch (Exception e) {
            System.out.println("BOOOO.");
        }

    }

}