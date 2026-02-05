package com.busanit501.jsp_server_project1._5_260205._0205_todo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_4_todoUpdateController_0205", urlPatterns = "/todo/delete_0205")
public class _0205_5_TodoDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/_5_260205/_0205_todo/todoUpdate.jsp").forward(req, resp);
    }
}
