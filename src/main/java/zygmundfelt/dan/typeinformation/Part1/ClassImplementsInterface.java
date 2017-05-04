package zygmundfelt.dan.typeinformation.Part1;

public class ClassImplementsInterface {

    static boolean classImplementsInterface(Class implementor, Class implemented) {
        Class[] interfaces = implementor.getInterfaces();
        for (Class cl : interfaces) {
            if (cl == implemented) {
                return true;
            }
        }
        return false;
    }

    static boolean classImplementsInterface(Object implementor, Class implemented) {
        Class[] interfaces = implementor.getClass().getInterfaces();
        for (Class cl : interfaces) {
            if (cl == implemented) {
                return true;
            }
        }
        return false;
    }

    static boolean classImplementsInterface(String implementor, Class implemented) {
        try {
            Class[] interfaces = Class.forName(implementor).getInterfaces();
            for (Class cl : interfaces) {
                if (cl == implemented) {
                    return true;
                }
            }
        } catch(Exception e) {
            return false;
        }
        return false;
    }

}
