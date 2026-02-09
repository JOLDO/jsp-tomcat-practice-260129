package com.busanit501.jsp_server_project1._7_260209._0209_todo.controller;

import com.busanit501.jsp_server_project1._7_260209._0209_todo.service._0209_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "_4_todoDeleteController_0209", urlPatterns = "/todo/delete_0209")
public class _0209_5_TodoDeleteController extends HttpServlet {

    private _0209_TodoService todoService = _0209_TodoService.INSTANCE;

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
        resp.sendRedirect("/todo/list_0209");
    }
}
