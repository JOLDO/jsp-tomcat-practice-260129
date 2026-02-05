package com.busanit501.jsp_server_project1._4_260204._0204_todo.controller;

import com.busanit501.jsp_server_project1._4_260204._0204_todo.dto._0204_TodoDTO;
import com.busanit501.jsp_server_project1._4_260204._0204_todo.service._0204_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "_2_todoRegController_0204", urlPatterns = "/todo/register_0204")
public class _0204_2_TodoRegController extends HttpServlet {
    //1)화면 제공 2)글쓰기 작업 수행

    private _0204_TodoService todoService = _0204_TodoService.INSTANCE;
    //HH는 24시간,a hh는 (오전/오후) 12시간
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/register_0204, 글작성 폼 임시화면 get으로 요청 처리함.");

        req.getRequestDispatcher("/WEB-INF/_4_260204/_0204_todo/todoReg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        log.info("todo/register 글쓰기 로직 처리하는 곳입니다.");
        log.info("PRG 패턴");

        //화면으로 부터 받은 데이터를 dto에 담음
        _0204_TodoDTO todoDTO = _0204_TodoDTO.builder()
            .title(req.getParameter("title"))
            .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
            .build();

        //서비스로 전달
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/todo/list_0204");
    }
}
