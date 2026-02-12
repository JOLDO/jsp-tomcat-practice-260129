package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_4_todoUpdateController_0202", urlPatterns = "/todo/update_0202")
public class _0202_4_TodoUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/_0202_todo/todoUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
    }
}
