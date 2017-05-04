package zygmundfelt.dan.typeinformation.unitCorn;
import org.junit.*;

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
        Class cl = DummyTest.class;
        String methodName = "setANumberTest";
        String expected = "SUCCESS!";

        String actual = UnitCornTestRunner.runTest(cl, methodName);

        Assert.assertEquals(expected, actual);
    }

}
