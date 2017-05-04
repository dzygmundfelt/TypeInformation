package zygmundfelt.dan.typeinformation.unitCorn;

public class Dummy {

    private boolean amIAtest;
    private String name;
    private double aNumber;

    Dummy() {
        amIAtest = false;
        name = "Dummy";
        aNumber = 0.0;
    }

    public void setANumber(double number) {
        aNumber = number;
    }

    public double getANumber() {
        return aNumber;
    }

}
