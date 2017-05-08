package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RunnerTestClass {

    private Class cls;
    private ArrayList<String> testMethods;
    private ArrayList<String> beforeMethods;
    private ArrayList<String> afterMethods;

    RunnerTestClass(Class cls) {
        this.cls = cls;
        chooseJUnitTestMethods();
        chooseJUnitBeforeMethods();
        chooseJUnitAfterMethods();
    }

    void chooseJUnitTestMethods() {
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<String> testMethods = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().substring(0, 15).equals("@org.junit.Test")) {
                    testMethods.add(m.getName());
                }
            }
        }

        this.testMethods = testMethods;
    }

    void chooseJUnitBeforeMethods() {
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<String> beforeMethods = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().substring(0, 17).equals("@org.junit.Before")) {
                    beforeMethods.add(m.getName());
                }
            }
        }

        this.beforeMethods = beforeMethods;
    }

    void chooseJUnitAfterMethods() {
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<String> afterMethods = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().substring(0, 16).equals("@org.junit.After")) {
                    afterMethods.add(m.getName());
                }
            }
        }

        this.afterMethods = afterMethods;
    }

    ArrayList<String> getTestMethods() {
        return testMethods;
    }

    ArrayList<String> getBeforeMethods() {
        return beforeMethods;
    }

    ArrayList<String> getAfterMethods() {
        return afterMethods;
    }
}
