package zygmundfelt.dan.typeinformation.unitCorn;

public class Result {

    Exception exception;
    String methodName;

    Result(String methodName) {
        this.methodName = methodName;
    }

    Result(Exception exception, String methodName) {
        this.exception = exception;
        this.methodName = methodName;
    }

    public Exception getException() {
        return exception;
    }


    public String getMethodName() {
        return methodName;
    }

    boolean equals(Result result) {
        return exception.equals(result.getException()) && methodName.equals(result.getMethodName());
    }

    public String toString() {
        return "Exception is a " + exception + "\nMethodName is " + methodName + "\n";
    }

}
