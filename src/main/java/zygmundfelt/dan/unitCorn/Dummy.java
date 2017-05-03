package zygmundfelt.dan.unitCorn;
import org.junit.*;

public class Dummy {

    private boolean amIAtest;
    private String name;
    private double aNumber;

    Dummy() {
        amIAtest = false;
        name = "Dummy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setANumber(double number) {
        aNumber = number;
    }

    public double getANumber() {
        return aNumber;
    }

}
