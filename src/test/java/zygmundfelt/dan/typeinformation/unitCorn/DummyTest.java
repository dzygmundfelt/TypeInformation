package zygmundfelt.dan.typeinformation.unitCorn;

import org.junit.*;

/**
 * Created by danzygmund-felt on 5/3/17.
 */
public class DummyTest {

    Dummy dummy;

    @Before
    public void initialize() {
        dummy = new Dummy();
    }

    @Test
    public void setANumberTest() {
        dummy.setANumber(81.18);
        double expected = 81.18;

        double actual = 81.18;

        Assert.assertEquals("The samesies", expected, actual, 0);
    }

    @Test
    public void setANumberTestFail() {
        dummy.setANumber(81.18);
        double expected = -81.18;

        double actual = dummy.getANumber();

        Assert.assertEquals("The samesies", expected, actual, 0);
    }

    public void printalicious() {
        System.out.println(".paak");
    }

}
