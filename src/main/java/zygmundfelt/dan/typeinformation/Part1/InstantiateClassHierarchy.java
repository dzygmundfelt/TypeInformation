package zygmundfelt.dan.typeinformation.Part1;

import java.util.ArrayList;
import java.util.TreeMap;

public class InstantiateClassHierarchy {

    static ArrayList<Object> instantiateClassHierarchy(Object o) {
        Class cl = o.getClass();
        ArrayList<Object> classInstanceArrayList = new ArrayList<Object>();

        do {
            try{
                Object object = cl.newInstance();
                classInstanceArrayList.add(object);
                cl = cl.getSuperclass();
            }
            catch (Exception e) {
                cl = cl.getSuperclass();
            }
        } while(cl != null);

        for(Object object : classInstanceArrayList) {
            int modifier = object.getClass().getModifiers();
            if(modifier == 0 || modifier == 2) {
                classInstanceArrayList.remove(object);
            }
        }

        return classInstanceArrayList;
    }

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        ArrayList list = new ArrayList();

        ArrayList<Object> forTreeMap = instantiateClassHierarchy(map);
        ArrayList<Object> forList = instantiateClassHierarchy(list);

        for(Object o : forTreeMap) {
            System.out.println(o.getClass());
        }

        System.out.println();

        for(Object o : forList) {
            System.out.println(o.getClass());
        }
    }

}
