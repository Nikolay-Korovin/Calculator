package by.tms.calculator.servlets;

import by.tms.calculator.entity.User;
import by.tms.calculator.service.OperationHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/operationHistory", name = "OperationHistoryServlet")
public class OperationHistoryServlet extends HttpServlet {
    private final OperationHistoryService historyService = new OperationHistoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("operationList", historyService.getOperations((User) req.getSession().getAttribute("user")));
        req.getRequestDispatcher("operationHistory.jsp").forward(req, resp);
    }
}