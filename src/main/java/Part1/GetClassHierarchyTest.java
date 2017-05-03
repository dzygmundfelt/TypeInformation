package Part1;
import org.junit.*;

public class GetClassHierarchyTest {

    @Test
    public void GetClassHierarchyIntegerTest() {
        //Given
        Integer integer = 30;
        String expected = "java.lang.Object\n  java.lang.Number\n    java.lang.Integer\n";
        //When
        String actual = GetClassHierarchy.getClassHierarchy(integer);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetClassHierarchyObjectTest() {
        //Given
        Object o = new Object();
        String expected = "java.lang.Object\n";
        //When
        String actual = GetClassHierarchy.getClassHierarchy(o);
        //Then
        Assert.assertEquals(expected, actual);
    }

}
