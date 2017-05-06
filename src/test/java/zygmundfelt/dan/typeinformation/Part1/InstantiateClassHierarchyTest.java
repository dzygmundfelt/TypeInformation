package zygmundfelt.dan.typeinformation.Part1;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

/* Need to work out these tests. Instantiating objects and adding them to an
   ArrayList won't lead to the .contains() method returning true, because, duh,
   they're different instances of the same class.

   This may not be too much trouble but I want to move on to something else.
 */



public class InstantiateClassHierarchyTest {

    @Test
    public void instantiateClassHierarchyTrueTest() {
        //Given
        TreeMap map = new TreeMap();
        Object object = new Object();
        ArrayList<Object> expected = new ArrayList<Object>();
        expected.add(map);
        expected.add(object);
        //When
        ArrayList<Object> actual = InstantiateClassHierarchy.instantiateClassHierarchy(map);
        //Then
        boolean result = true;

        for(Object o : expected) {
            if(!actual.contains(o)) {
                result = false;
            }
        }

        for(Object o : actual) {
            if(!expected.contains(o)) {
                result = false;
            }
        }

        Assert.assertTrue(result);
    }


    @Test
    public void instantiateClassHierarchyFalseTest() {
        //Given
        LinkedList list = new LinkedList();
        ArrayList<Object> expected = new ArrayList<Object>();
        expected.add(list);
        //When
        ArrayList<Object> actual = InstantiateClassHierarchy.instantiateClassHierarchy(list);
        //Then
        boolean result = true;

        for(Object o : actual) {
            actual.add(o.getClass());
        }

        for(Object o : expected) {
            if(!actual.contains(o)) {
                result = false;
            }
        }

        for(Object o : actual) {
            if(!expected.contains(o)) {
                result = false;
            }
        }

        Assert.assertFalse(result);

    }
}
