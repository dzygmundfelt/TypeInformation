package zygmundfelt.dan.typeinformation.Part1;
import org.junit.*;

/*
I broke up the methods in GetClassHierarchy to adhere to SRP.
As a consequence I had to change the tests slightly, and they're
now aggregate tests for both methods, rather than tests for the
individual methods.
 */

public class GetClassHierarchyTest {

    //Aggregate test
    @Test
    public void printClassHierarchyIntegerTest() {
        //Given
        Integer integer = 30;
        String expected = "java.lang.Object\n  java.lang.Number\n    java.lang.Integer\n";
        //When
        String actual = GetClassHierarchy.printClassHierarchy(GetClassHierarchy.getClassHierarchy(integer));
        //Then
        Assert.assertEquals(expected, actual);
    }

    //Aggregate test
    @Test
    public void printClassHierarchyObjectTest() {
        //Given
        Object o = new Object();
        String expected = "java.lang.Object\n";
        //When
        String actual = GetClassHierarchy.printClassHierarchy(GetClassHierarchy.getClassHierarchy(o));
        //Then
        Assert.assertEquals(expected, actual);
    }

}
