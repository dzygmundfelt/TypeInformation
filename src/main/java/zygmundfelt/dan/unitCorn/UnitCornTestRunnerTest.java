package zygmundfelt.dan.unitCorn;
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
        //Given
        Result expected = new Result(true, "setANumberTest");
        //When
        Result actual = runTest(dummyTest, "setANumberTest");
        //Then
        Assert.assertTrue(expected.methodName.equals(actual.methodName) && expected.wasSuccess && actual.wasSuccess);
    }

}
