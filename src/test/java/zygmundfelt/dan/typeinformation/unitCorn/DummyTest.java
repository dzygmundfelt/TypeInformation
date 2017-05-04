package zygmundfelt.dan.typeinformation.unitCorn;

import org.junit.*;


public class DummyTest {

    @Test
    public void setANumberTest() {
        double expected = 81.18;
        double actual = 81.18;

        Assert.assertEquals("The samesies", expected, actual, 0);
    }

    @Test
    public void setANumberTestFail() {
        double expected = -81.18;
        double actual = 81.18;

        Assert.assertEquals("The samesies", expected, actual, 0);
    }

    public void throwsIndexOutOfBoundsException() {
        int[] arr = new int[10000];
        int thisShouldBeAnException = arr[arr.length + 3];
        return;
    }

}
