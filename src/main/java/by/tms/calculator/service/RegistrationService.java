package by.tms.calculator.service;

import by.tms.calculator.dao.UserDao;
import by.tms.calculator.entity.User;

public class RegistrationService {
    private final UserDao userDao = new UserDao();

    public void createUser(User user) {
        if (userDao.findUserByLog(user.getLogin()).isEmpty()) {
            userDao.createUser(user);
        }
    }
}
