package by.tms.calculator.servlets;

import by.tms.calculator.entity.Operation;
import by.tms.calculator.entity.User;
import by.tms.calculator.service.CalcService;
import by.tms.calculator.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    CalcService calcService = new CalcService();
    OperationService operationService = new OperationService();
    Operation operation;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String action = req.getParameter("action");
        String num2 = req.getParameter("num2");
        String login = (String) req.getSession().getAttribute("login");
        String message = num1 + action + num2 + "= ";
        String result = String.valueOf(calcService.calculate(num1, action, num2, login));
        operation = new Operation(num1,num2,action,result);
        operationService.createOperation((User)req.getSession().getAttribute("user"),operation);
        req.setAttribute("message", message);
        req.setAttribute("result",result);
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
