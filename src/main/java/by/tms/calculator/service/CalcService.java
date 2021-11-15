package by.tms.calculator.service;

import by.tms.calculator.dao.OperationDao;
import by.tms.calculator.entity.Operation;

public class CalcService {
    OperationDao operationDao = new OperationDao();

    public double calculate(String num1, String action, String num2, String login) {
        Double result = null;
        switch (action) {
            case ("+"):
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case ("-"):
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case ("*"):
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case ("/"):
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
            default:
        }
        return result;
    }
}
