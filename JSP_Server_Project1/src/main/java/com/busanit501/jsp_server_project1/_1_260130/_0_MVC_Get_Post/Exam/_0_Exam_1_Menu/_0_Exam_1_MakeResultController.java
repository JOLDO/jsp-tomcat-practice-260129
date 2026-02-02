package com.busanit501.jsp_server_project1._1_260130._0_MVC_Get_Post.Exam._0_Exam_1_Menu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "makeResultController", urlPatterns = "/menu/makeResult")
public class _0_Exam_1_MakeResultController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("textInput"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/_1_menu/makeResultMenu.jsp");
        dispatcher.forward(req, resp);
    }
}
