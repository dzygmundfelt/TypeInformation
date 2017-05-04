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
            String result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertEquals(result, null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    @Test
    public void runTestTestFail() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "setANumberTestFail";
            String actual = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertNotEquals(actual, null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    @Test
    public void testIndexOutOfBoundsExceptionInTestMethod() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "throwsIndexOutOfBoundsException";
            String actual = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertNotEquals(actual, null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    //This test is designed to fail. Be happy!
    @Test
    public void runTestTestWhichShouldFail() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "setANumberTest";
            String result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertNotEquals(result, null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
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
        ArrayList<String> expected = UnitCornTestRunner.getJUnitAnnotatedMethods(clazz);

        ArrayList<String> actual = new ArrayList<String>();
        actual.add("setANumberTest");
        actual.add("setANumberTestFail");

        boolean result = true;

        if(actual.size() != expected.size()) {
            result = false;
        } else {
            for(String s : actual) {
                if(!expected.contains(s)) {
                    result = false;
                }
            }
        }

        Assert.assertTrue(result);
    }

}
