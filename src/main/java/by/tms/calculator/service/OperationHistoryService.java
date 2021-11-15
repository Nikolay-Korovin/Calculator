package by.tms.calculator.service;

import by.tms.calculator.dao.OperationDao;
import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;

import java.util.List;

public class OperationHistoryService {
    OperationDao operationDao = new OperationDao();

    public List<Operation> getOperations(User user) {
        return operationDao.getOperationHistory(user);
    }
}
