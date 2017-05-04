package zygmundfelt.dan.unitCorn;
import org.junit.Assert;

import java.lang.reflect.Method;

/*
    Not a clue right now how to generate a result from this method, sitting in this class.

*/


public class UnitCornTestRunner {

    Result runTest(Class c, String methodName) {
        Method[] methods = c.getDeclaredMethods();
        Result result = null;
        for(Method m : methods) {
            if(m.getName().equals(methodName)) {
                return new Result(Assert.assertTrue(m), m.getName());
            }
        }
        return null;
    }

    String runTests(Class c) {

        return null;
    }
}
