package zygmundfelt.dan.typeinformation.unitCorn;
import org.junit.*;
import java.util.ArrayList;


public class UnitCornTestRunnerTest {

    UnitCornTestRunner unitCorn;


    @Before
    public void initialize() {
        try {
            Class clazz = Class.forName("zygmundfelt.dan.typeinformation.unitCorn.DummyTest");
            unitCorn = new UnitCornTestRunner(clazz);
        } catch (Exception e){
            Assert.fail("Couldn't create DummyTest." + e.getMessage());
        }

    }

    @Test
    public void runTestTest() {
        String methodName = "setANumberTest";
        Result result = unitCorn.runTest(methodName);
        Assert.assertEquals(result.getResult(), "success");
    }

    @Test
    public void runTestTestFail() {
        String methodName = "setANumberTestFail";
        Result result = unitCorn.runTest(methodName);

        Assert.assertNotEquals(result.getResult(), null);
    }

    @Test
    public void testIndexOutOfBoundsExceptionInTestMethod() {
        String methodName = "throwsIndexOutOfBoundsException";
        Result result = unitCorn.runTest(methodName);

        Assert.assertNotEquals(result.getResult(), null);
    }

    /*
    This test is designed to fail. Be happy!
     */
    @Test
    public void runTestTestWhichShouldFail() {
        String methodName = "setANumberTest";
        Result result = unitCorn.runTest(methodName);

        Assert.assertEquals(result.getResult(), null);
    }

    @Test
    public void getJUnitAnnotatedMethodsTest() {
        ArrayList<String> expected = unitCorn.getJUnitAnnotatedMethods();

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
        String expected = "The result of testing setANumberTest was success.\n" +
                "The result of testing setANumberTestFail was java.lang.reflect.InvocationTargetException.\n" +
                "The result of testing anotherTestPass was success.\n" +
                "The result of testing anotherTestFail was java.lang.reflect.InvocationTargetException.\n";

        String actual = unitCorn.runTests();

        Assert.assertEquals(expected,actual);
    }

}
