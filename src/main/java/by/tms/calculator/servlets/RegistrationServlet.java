package by.tms.calculator.servlets;

import by.tms.calculator.dao.UserDao;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService registrationService = new RegistrationService();
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> userByLog = userDao.findUserByLog(login);
        if(userByLog.isEmpty()){
            registrationService.createUser(new User(name,login,password));
            resp.sendRedirect("/");
            return;
        }else{
            req.setAttribute("message", "user already exists");
        }
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }
}
