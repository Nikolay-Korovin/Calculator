package by.tms.calculator.entity;

public class Operation {
    private String num1;
    private String num2;
    private String action;
    private String result;

    public Operation(String num1, String num2, String action, String result) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
        this.result = result;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
