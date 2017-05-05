package zygmundfelt.dan.typeinformation.unitCorn;

public class Result {

    String methodName;
    String result;

    Result(String methodName, String result) {
        this.methodName = methodName;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getMethodName() {
        return methodName;
    }

    public String toString() {
        return "The result of testing " + methodName + " was " + result + ".\n";
    }

}
