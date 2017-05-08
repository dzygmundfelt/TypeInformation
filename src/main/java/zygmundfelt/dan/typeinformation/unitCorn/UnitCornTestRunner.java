package zygmundfelt.dan.typeinformation.unitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.*;


public class UnitCornTestRunner {

    private ArrayList<Result> results;
    private RunnerTestClass runnerTestClass;
    private Class cls;

    UnitCornTestRunner(Class cls) {
        results = new ArrayList<Result>();
        this.runnerTestClass = new RunnerTestClass(cls);
        this.cls = cls;
    }

    Result runTest(String methodName) {

        Object o;
        try {
            o = cls.newInstance();
        } catch(Exception e) {
            return new Result(methodName, e.toString());
        }

        Method method = getMethod(methodName);

        try {
            method.invoke(o);
        } catch (Exception e) {
            return new Result(methodName, e.toString());
        }

        return new Result(methodName, "success");
    }

    Method getMethod(String methodName) {
        Method[] methods = cls.getDeclaredMethods();
        for(Method m : methods) {
            if(m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    void runTests() {
        ArrayList<String> annotatedMethods = runnerTestClass.getTestMethods();
        for(String s : annotatedMethods) {
            Result result = runTest(s);
            results.add(result);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Result r : results) {
            sb.append(r);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.UnitCornTestRunner");
            UnitCornTestRunner unitCornTestRunner = new UnitCornTestRunner(cls);
            unitCornTestRunner.runTests();
            System.out.println(unitCornTestRunner.toString());
        } catch (Exception e) {
            System.out.println("BOOOO.");
        }

    }

}