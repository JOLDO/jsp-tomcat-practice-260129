package com.busanit501.jsp_server_project1._3_260203._0203_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_4_todoUpdateController_0203", urlPatterns = "/todo/delete_0203")
public class _0203_5_TodoDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/_3_260203/_0203_todo/todoUpdate.jsp").forward(req, resp);
    }
}
