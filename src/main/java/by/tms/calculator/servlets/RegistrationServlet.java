package by.tms.calculator.servlets;

import by.tms.calculator.entity.User;
import by.tms.calculator.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        registrationService.createUser(new User(name,login,password));

        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }
}
