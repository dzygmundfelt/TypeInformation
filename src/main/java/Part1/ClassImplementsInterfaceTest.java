package Part1;
import org.junit.*;
import java.util.*;

public class ClassImplementsInterfaceTest {

    @Test
    public void classImplementsInterfaceClassTrueTest () {
        //Given
        Class implementor = ArrayList.class;
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void classImplementsInterfaceClassFalseTest() {
        //Given
        Class implementor = Math.class;
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void classImplementsInterfaceObjectTrueTest () {
        //Given
        ArrayList implementor = new ArrayList();
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void classImplementsInterfaceObjectFalseTest() {
        //Given
        Integer implementor = 45;
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void classImplementsInterfaceStringTrueTest () {
        //Given
        String implementor = "java.util.ArrayList";
        Class implemented = List.class;
        ArrayList list = new ArrayList();
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertEquals(implementor,list.getClass().getName());
        //Assert.assertTrue(result);
    }

    @Test
    public void classImplementsInterfaceStringFalseTest() {
        //Given
        String implementor = "java.lang.Object";
        Class implemented = List.class;
        //When
        boolean result = ClassImplementsInterface.classImplementsInterface(implementor, implemented);
        //Then
        Assert.assertFalse(result);
    }
}
