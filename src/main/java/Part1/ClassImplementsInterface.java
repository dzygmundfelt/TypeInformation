package Part1;

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
}
