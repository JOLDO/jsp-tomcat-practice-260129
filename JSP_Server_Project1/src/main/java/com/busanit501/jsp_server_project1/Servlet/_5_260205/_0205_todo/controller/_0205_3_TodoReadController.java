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

@Log4j2
@WebServlet(name = "_3_todoReadController_0205", urlPatterns = "/todo/read_0205")
public class _0205_3_TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //현재 작업하는 파일 위치를 서버 콘솔에 출력
        log.info("/todo/read_0205, 상세정보 폼 임시화면 get으로 요청 처리함. ");

        //임시로 조회할 하나의 더미 데이터 지정
        //웹브라우저에서 주소요청: http://localhost:8080/todo/read_0205?tno=100
        //서버는 웹에서 전달한 데이터 가져오기
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));    //문자열 형태로 데이터 읽어옴
            _0205_TodoDTO todoDTO = _0205_TodoService.INSTANCE.get(tno);
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/WEB-INF/Servlet/_5_260205/_0205_todo/todoRead.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }
}
