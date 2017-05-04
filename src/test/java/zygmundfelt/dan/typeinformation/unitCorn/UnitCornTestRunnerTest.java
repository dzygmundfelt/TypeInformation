package zygmundfelt.dan.typeinformation.unitCorn;
import org.junit.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class UnitCornTestRunnerTest {

    UnitCornTestRunner unitCorn;
    DummyTest dummyTest;


    @Before
    public void initialize() {
        unitCorn = new UnitCornTestRunner();
        dummyTest = new DummyTest();
    }

    @Test
    public void runTestTest() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "setANumberTest";
            Exception expected = null;

            Exception actual = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertEquals(expected, actual);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    /*This test would pass if I could instantiate an InvocationTargetException.
    @Test
    public void runTestTestFail() {
        Class cl = null;
        try {
            Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
        } catch (Exception e){
            Assert.assertTrue("Couldn't create instance of DummyTest.", false);
        }
        String methodName = "setANumberTestFail";
        Exception expected = new InvocationTargetException();

        Exception actual = UnitCornTestRunner.runTest(cl, methodName);

        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void testAbilityToCatchIndexOutOfBoundsException() {
        Class clazz = null;
        try {
            clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
        } catch (Exception e){
            Assert.assertTrue("Couldn't create instance of DummyTest.", false);
        }
        String methodName = "throwsIndexOutOfBoundsException";
        Exception expected = new IndexOutOfBoundsException();

        Exception actual = UnitCornTestRunner.runTest(clazz, methodName);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getJUnitAnnotatedMethodsTest() {
        Class clazz = null;
        try {
            clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
        } catch (Exception e){
            Assert.assertTrue("Couldn't create instance of DummyTest.", false);
        }
        Method[] methods = clazz.getDeclaredMethods();
        ArrayList<String> expected = new ArrayList<String>();

        for(Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations) {
                if(a.toString().equals("@org.junit.Test")) {
                    expected.add(m.toString());
                }
            }
        }

        ArrayList<String> actual = new ArrayList<String>();
        actual.add("setANumberTest");
        actual.add("setANumberTestFail");

        boolean result = true;

        if(actual.size() != expected.size()) {
            result = false;
        } else {
            for(int i = 0; i < actual.size(); i++) {
                if (!expected.get(i).equals(actual.get(i))) {
                    result = false;
                }
            }
        }

        Assert.assertTrue(result);
    }

}
