package com.busanit501.jsp_server_project1.Servlet._5_260205._0205_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._5_260205._0205_todo.dto._0205_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._5_260205._0205_todo.service._0205_TodoService;
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
@WebServlet(name = "_2_todoRegController_0205", urlPatterns = "/todo/register_0205")
public class _0205_2_TodoRegController extends HttpServlet {
    //1)화면 제공 2)글쓰기 작업 수행

    private _0205_TodoService todoService = _0205_TodoService.INSTANCE;
    //HH는 24시간,a hh는 (오전/오후) 12시간
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //화면 응답
        log.info("/todo/register_0205, 글작성 폼 임시화면 get으로 요청 처리함.");

        req.getRequestDispatcher("/WEB-INF/Servlet/_5_260205/_0205_todo/todoReg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //P:doPost
        //기능 처리
        //받을때 한글설정
        req.setCharacterEncoding("UTF-8");
        log.info("todo/register 글쓰기 로직 처리하는 곳입니다.");
        log.info("PRG 패턴");

        try {
            //화면으로 부터 받은 데이터를 dto에 담음
            _0205_TodoDTO todoDTO = _0205_TodoDTO.builder()
                    .title(req.getParameter("title"))
                    .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                    .build();

            //서비스로 전달
            //보낼때 한글설정(없어도 되긴하던데)
            resp.setContentType("text/htnl;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            todoService.register(todoDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("regist error");
        }

        //R:sendRedirect
        //G:"/todo/list_0205"(get)
        resp.sendRedirect("/todo/list_0205");
    }
}
