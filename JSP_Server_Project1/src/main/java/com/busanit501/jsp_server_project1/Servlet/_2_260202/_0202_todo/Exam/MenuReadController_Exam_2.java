package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.Exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuReadController_Exam_2", urlPatterns = "/todo/read/menu/exam2")
public class MenuReadController_Exam_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.parseLong(req.getParameter("tno"));
        MenuDto_Exam_2 dto = MenuService_Exam_2.INSTANCE.get(tno);
        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/Exam/read_menu_Exam2.jsp").forward(req, resp);
    }
}
