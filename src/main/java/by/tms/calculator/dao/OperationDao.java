package by.tms.calculator.dao;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDao {
    private final UserDao userDao = new UserDao();
    private static final String DATABASE = "jdbc:mysql://localhost:3306/calculator_data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void writeOperation(User user, Operation operation) {
        final String sql = "INSERT INTO operations (num1,action,num2,result,userID) VALUES (?, ?, ?, ?, ?)";
        String userID = String.valueOf(userDao.getIDFromUser(user));
        String num1 = operation.getNum1();
        String action = operation.getAction();
        String num2 = operation.getNum2();
        String result = operation.getResult();
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, num1);
            statement.setString(2, action);
            statement.setString(3, num2);
            statement.setString(4, result);
            statement.setString(5, userID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operation> getOperationHistory(User user){
        List<Operation> operations = new ArrayList<>();
        int userID = userDao.getIDFromUser(user);
        final String sql = "SELECT num1, action, num2, result FROM operations WHERE userID = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, userID);
            while (resultSet.next()) {
                operations.add(new Operation(
                        resultSet.getString("num1"),
                        resultSet.getString("num2"),
                        resultSet.getString("action"),
                        resultSet.getString("result")));
            }
            return operations;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
