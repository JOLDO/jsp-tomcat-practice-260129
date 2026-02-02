package com.busanit501.jsp_server_project1._2_260202._0202_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_4_todoUpdateController_0202", urlPatterns = "/todo/delete_0202")
public class _0202_5_TodoDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/_2_260202/_0202_todo/todoUpdate.jsp").forward(req, resp);
    }
}
