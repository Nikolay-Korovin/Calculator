package by.tms.calculator.dao;

import by.tms.calculator.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private static final String DATABASE = "jdbc:mysql://localhost:3306/calculator_data";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void createUser(User user){
        String username = user.getUsername();
        String login = user.getLogin();
        String password = user.getPassword();
        final String sql = "INSERT INTO users (username,login, password) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
