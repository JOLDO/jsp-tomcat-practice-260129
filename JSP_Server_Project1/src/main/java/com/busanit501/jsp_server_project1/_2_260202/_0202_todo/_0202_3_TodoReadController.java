package com.busanit501.jsp_server_project1._2_260202._0202_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_3_todoReadController_0202", urlPatterns = "/todo/read_0202")
public class _0202_3_TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/read, 글작성 폼 임시화면 get으로 요청 처리함. ");

        req.getRequestDispatcher("/WEB-INF/_2_260202/_0202_todo/todoRead.jsp").forward(req, resp);
    }
}
