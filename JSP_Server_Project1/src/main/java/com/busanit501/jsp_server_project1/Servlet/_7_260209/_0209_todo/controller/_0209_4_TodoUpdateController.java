package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service._0209_TodoService;
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
@WebServlet(name = "_5_todoUpdateController_0209", urlPatterns = "/todo/update_0209")
public class _0209_4_TodoUpdateController extends HttpServlet {

    private _0209_TodoService todoService = _0209_TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //수정 화면

//        req.setCharacterEncoding("UTF-8");
        log.info("/todo/update_0209, 수정 폼 임시화면 get으로 요청 처리함. ");

        try {
            //상세조회에서 tno를 이미 불러왔고 tno를 이용해서 기존 데이터를 화면에 불러옴
            Long tno = Long.parseLong(req.getParameter("tno"));
            _0209_TodoDTO todoDTO = todoService.get(tno);

            //화면에 전달
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/WEB-INF/Servlet/_7_260209/_0209_todo/todoUpdate.jsp").forward(req, resp);

//            resp.setContentType("text/html;charset=UTF-8");
//            resp.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //수정 기능
//        req.setCharacterEncoding("UTF-8");

        //주의)체크박스는 체크되면 문자열 "on"으로 값을 준다.
        String tno = req.getParameter("tno");
        String title = req.getParameter("title");
        String dueDate = req.getParameter("dueDate");
        String finishedStr = req.getParameter("finished");

        //넘어온 데이터 dto에 담기
        _0209_TodoDTO todoDTO = _0209_TodoDTO.builder()
            .tno(Long.parseLong(tno))
            .title(title)
            .dueDate(LocalDate.parse(dueDate, DATEFORMATTER))
            .finished(finishedStr != null && finishedStr.equals("on"))
            .build();

        log.info("화면으로부터 전달받은 수정할 내용 확인 todoDTO : " + todoDTO);

        try {
            todoService.modify(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list_0209");
    }
}
