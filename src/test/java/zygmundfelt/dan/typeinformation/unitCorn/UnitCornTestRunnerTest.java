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
            Result result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertEquals(result.getResult(), "success");
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    @Test
    public void runTestTestFail() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "setANumberTestFail";
            Result result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertNotEquals(result.getResult(), null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    @Test
    public void testIndexOutOfBoundsExceptionInTestMethod() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "throwsIndexOutOfBoundsException";
            Result result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertNotEquals(result.getResult(), null);
        } catch (Exception e){
            Assert.fail("Couldn't create instance of DummyTest." + e.getMessage());
        }
    }

    /*
    This test is designed to fail. Be happy!
     */
    @Test
    public void runTestTestWhichShouldFail() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            String methodName = "setANumberTest";
            Result result = UnitCornTestRunner.runTest(clazz, methodName);

            Assert.assertEquals(result.getResult(), null);
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

        ArrayList<String> expected = UnitCornTestRunner.getJUnitAnnotatedMethods(clazz);

        ArrayList<String> actual = new ArrayList<String>();
        actual.add("setANumberTest");
        actual.add("setANumberTestFail");
        actual.add("anotherTestPass");
        actual.add("anotherTestFail");

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

    @Test
    public void runTestsTestDummy() {
        Class clazz = null;
        try {
            clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
        } catch (Exception e){
            Assert.assertTrue("Couldn't create instance of DummyTest.", false);
        }

        String expected = "The result of testing setANumberTest was success.\n" +
                "The result of testing setANumberTestFail was java.lang.reflect.InvocationTargetException.\n" +
                "The result of testing anotherTestPass was success.\n" +
                "The result of testing anotherTestFail was java.lang.reflect.InvocationTargetException.\n";

        String actual = UnitCornTestRunner.runTests(clazz);

        Assert.assertEquals(expected,actual);
    }

    /*
    This test method sometimes reverses the order of the expected String, but that's OK for now.
     */
    @Test
    public void runTestsTestUnitCornTestRunner() {
        Class clazz = null;
        try {
            clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.UnitCornTestRunner");
        } catch (Exception e) {
            Assert.assertTrue("Couldn't create instance of UnitCornTestRunner", false);
        }

        String expected =
                "The result of testing getJUnitAnnotatedMethods was java.lang.IllegalArgumentException: wrong number of arguments.\n"+
                        "The result of testing runTests was java.lang.IllegalArgumentException: wrong number of arguments.\n";

        String actual = UnitCornTestRunner.runTests(clazz);

        Assert.assertEquals(expected, actual);
    }

}
