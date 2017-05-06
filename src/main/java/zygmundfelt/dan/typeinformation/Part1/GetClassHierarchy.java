package zygmundfelt.dan.typeinformation.Part1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetClassHierarchy {

    static ArrayList<Class> getClassHierarchy(Object o) {
        Class cl = o.getClass();
        ArrayList<Class> classArrayList = new ArrayList<Class>();

        do {
            classArrayList.add(cl);
            cl = cl.getSuperclass();
        } while(cl != null);

        return classArrayList;
    }

    static String printClassHierarchy(ArrayList<Class> classArrayList) {
        int len = classArrayList.size();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                sb.append("  ");
            }
            sb.append(classArrayList.get(len - 1 - i).getName() + "\n");
        }

        return sb.toString();
    }
}
