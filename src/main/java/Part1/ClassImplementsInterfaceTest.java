package Part1;
import org.junit.*;
import java.util.*;

public class ClassImplementsInterfaceTest {

    @Test
    public void classImplementsInterfaceTrueTest () {
        //Given
        Class implementor = ArrayList.class;
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void classImplementsInterfaceFalseTest() {
        //Given
        Class implementor = Math.class;
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertFalse(result);
    }
}
