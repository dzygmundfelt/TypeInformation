package Part1;

import java.util.ArrayList;

public class GetClassHierarchy {

    static String getClassHierarchy(Object o) {
        Class cl = o.getClass();
        ArrayList<Class> classArrayList = new ArrayList<Class>();
        String result = "";

        do {
            classArrayList.add(cl);
            cl = cl.getSuperclass();
        } while(cl != null);

        int len = classArrayList.size();

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                result += "  ";
            }
            result += classArrayList.get(len - 1 - i).getName() + "\n";
        }

        return result;
    }

    public static void main(String[] args) {

        Integer integer = 77;
        ArrayList list = new ArrayList();
        Object o = new Object();

        System.out.println(getClassHierarchy(integer));
        System.out.println(getClassHierarchy(list));
        System.out.println(getClassHierarchy(o));
    }
}
