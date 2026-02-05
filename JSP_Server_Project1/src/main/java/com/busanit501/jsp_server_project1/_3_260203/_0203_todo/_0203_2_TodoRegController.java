package com.busanit501.jsp_server_project1._3_260203._0203_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_2_todoRegController_0203", urlPatterns = "/todo/register_0203")
public class _0203_2_TodoRegController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/register_0203, 글작성 폼 임시화면 get으로 요청 처리함. ");

        req.getRequestDispatcher("/WEB-INF/_3_260203/_0203_todo/todoReg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("todo/register 글쓰기 로직 처리하는 곳입니다.");
        System.out.println("PRG");
        resp.sendRedirect("/todo/list_0203");
    }
}
