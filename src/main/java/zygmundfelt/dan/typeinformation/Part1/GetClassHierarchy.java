package zygmundfelt.dan.typeinformation.Part1;

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
}
