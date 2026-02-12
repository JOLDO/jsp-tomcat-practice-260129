package com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.dto._0204_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.service._0204_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "_1_todoListController_0204", urlPatterns = "/todo/list_0204")
@Log4j2 //로그를 중요도에 따라서 다르게 기록하는 방법
public class _0204_1_TodoListController extends HttpServlet {
    //controller <- service <- dao(controller는 service에 의존하고, service는 dao에 의존해서 사용중)(나중에 DI)
    //서비스의 기능을 사용
    private _0204_TodoService todoService = _0204_TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.info("sout대신 사용");
        log.info("=====전체 목록 조회=====");
        try {
            //service를 이용해 DB 데이터를 가져옴
            List<_0204_TodoDTO> dtoList = todoService.listAll();

            //서버에서 받아온 객체를 담아서 결과화면에 전달
            req.setAttribute("dtoList", dtoList);

            //결과화면으로 이동
            req.getRequestDispatcher("/WEB-INF/Servlet/_4_260204/_0204_todo/todoList.jsp")
                .forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
