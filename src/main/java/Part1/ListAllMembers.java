package Part1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class ListAllMembers {

    static String listAllMembers(Object o) {
        String summary = "";
        Class cl = o.getClass();
        do {
            summary += cl + "\n";
            Field[] fields = cl.getDeclaredFields();
            for(Field f : fields) {
                summary += f + "\n";
            }
            Constructor[] constructors = cl.getConstructors();
            for(Constructor c : constructors) {
                summary += c + "\n";
            }
            Method[] methods = cl.getDeclaredMethods();
            for(Method m : methods) {
                summary += m + "\n";
            }
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
