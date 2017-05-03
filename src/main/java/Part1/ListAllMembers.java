package Part1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/* The Arrays.sort methods below are adapted from
http://stackoverflow.com/questions/1097807/java-reflection-is-the-order-of-class-fields-and-methods-standardized
 */

public class ListAllMembers {

    static String listAllMembers(Object o) {
        String summary = "";
        Class cl = o.getClass();
        do {
            summary += cl + "\n";
            Field[] fields = cl.getDeclaredFields();
            Arrays.sort(fields, new Comparator<Field>() {
                public int compare(Field o1, Field o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for(Field f : fields) {
                summary += f + "\n";
            }
            System.out.println("\n");
            Constructor[] constructors = cl.getConstructors();
            Arrays.sort(constructors, new Comparator<Constructor>() {
                public int compare(Constructor o1, Constructor o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for(Constructor c : constructors) {
                summary += c + "\n";
            }
            System.out.println("\n");
            Method[] methods = cl.getDeclaredMethods();
            Arrays.sort(methods, new Comparator<Method>() {
                public int compare(Method o1, Method o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            for(Method m : methods) {
                summary += m + "\n";
            }
            System.out.println("\n");
            summary += "\n";
            cl = cl.getSuperclass();
        } while (cl != null);

        return summary;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(listAllMembers(list));
    }

}
