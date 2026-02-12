package com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.service._0206_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "_4_todoDeleteController_0206", urlPatterns = "/todo/delete_0206")
public class _0206_5_TodoDeleteController extends HttpServlet {

    private _0206_TodoService todoService = _0206_TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //화면 없음
    //삭제 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //삭제시 알고 있는 tno번호로 삭제
        String tnoStr = req.getParameter("tno");
        Long tno = Long.parseLong(tnoStr);

        try {
            todoService.remove(tno);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("delete error");
        }
        resp.sendRedirect("/todo/list_0206");
    }
}
