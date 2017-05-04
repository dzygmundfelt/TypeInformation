package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    Not a clue right now how to generate a result from this method, sitting in this class.

*/


public class UnitCornTestRunner {

    ArrayList<Result> results;

    static String runTest(Class c, String methodName) {
        Object o;
        try {
            o = c.newInstance();
        } catch(Exception e) {
            return "Cannot create new instance of " + c + "\n";
        }

        Method method = getMethod(c, methodName);

        try {
            method.invoke(o);
        } catch (IllegalAccessException e) {
            return "An IllegalAccessException occurred.";
        } catch (IllegalArgumentException e) {
            return "An IllegalArgumentException occurred.";
        } catch (InvocationTargetException e) {
            return "An InvocationTargetException occurred.";
        } catch (Exception e) {
            return "There was a different kind of exception.";
        }

        return "SUCCESS!";

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

    public static void main(String[] args) {
        Method method = getMethod(Dummy.class, "getANumber");
        System.out.println(method.getName());
        Dummy dummy = new Dummy();
        try{method.invoke(dummy);
        } catch (IllegalAccessException e) {
            System.out.print("An IllegalAccessException occurred.");
        } catch (IllegalArgumentException e) {
            System.out.println("An IllegalArgumentException occurred.");
        } catch (InvocationTargetException e) {
            System.out.println("An InvocationTargetException occurred.");
        }


    }
}