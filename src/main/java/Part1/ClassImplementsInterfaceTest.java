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
        Class[] interfaces = implementor.getInterfaces();
        boolean result = false;
        for(Class cl : interfaces) {
            if(cl == List.class) {
                result = true;
            }
        }
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void classImplementsInterfaceFalseTest() {
        //Given
        Class implementor = Math.class;
        Class implemented = List.class;
        //When
        Class[] interfaces = implementor.getInterfaces();
        boolean result = false;
        for(Class cl : interfaces) {
            if(cl == List.class) {
                result = true;
            }
        }
        //Then
        Assert.assertFalse(false);
    }
}
