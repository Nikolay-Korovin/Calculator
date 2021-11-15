package by.tms.calculator.dao;

import by.tms.calculator.entity.User;

import java.sql.*;
import java.util.Optional;

public class UserDao {

    private static final String DATABASE = "jdbc:mysql://localhost:3306/calculator_data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void createUser(User user) {
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

    public Optional<User> findUserByLog(String log) {
        final String sql = "SELECT * FROM users WHERE login=?";
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,log);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User(resultSet.getString("username"),log,resultSet.getString("password"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public int getIDFromUser(User user){
        String login = user.getLogin();
        int id = 0;
        final String sql = "SELECT ID FROM users WHERE login=?";
        try (Connection connection = DriverManager.getConnection(DATABASE, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("ID");
                return id;
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
