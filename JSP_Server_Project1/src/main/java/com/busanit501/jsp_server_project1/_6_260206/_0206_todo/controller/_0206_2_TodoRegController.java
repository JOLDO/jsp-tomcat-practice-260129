package com.busanit501.jsp_server_project1._6_260206._0206_todo.controller;

import com.busanit501.jsp_server_project1._6_260206._0206_todo.dto._0206_TodoDTO;
import com.busanit501.jsp_server_project1._6_260206._0206_todo.service._0206_TodoService;
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
@WebServlet(name = "_2_todoRegController_0206", urlPatterns = "/todo/register_0206")
public class _0206_2_TodoRegController extends HttpServlet {
    //1)화면 제공 2)글쓰기 작업 수행

    private _0206_TodoService todoService = _0206_TodoService.INSTANCE;
    //HH는 24시간,a hh는 (오전/오후) 12시간
    //private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //화면 응답
//        log.info("/todo/register_0206, 글작성 폼 임시화면 get으로 요청 처리함.");
//
//        //화면 접근 전 세션에서 로그인 유저 체크
//        //JSESSIONID를 체크 후 있으면 진행, 없으면 로그인화면으로 이동
//        HttpSession session = req.getSession(); //세션 객체 생성
//
//        //기존 사용자인지 새로운 사용자인지 확인
//        if(session.isNew()) {
//            //새로운 이용자
//            //서버 : JSESSIONID 생성, 서버 메모리에 저장 후 웹브라우저(클라이언트)에게 쿠키에 담아서 보냄
//            log.info("JSESSIONID 쿠키가 새롭게 만들어진 사용자");
//
//            //로그인 화면으로 이동
//            resp.sendRedirect("/login_0206");
//        }
//
//        //임시 로그인 처리
//        //세션이라는 공간에 로그인한 유저를 loginInfo라는 이름으로 저장
//        if(session.getAttribute("loginInfo") == null) {
//            log.info("로그인 정보가 없는 사용자입니다.");
//            resp.sendRedirect("/login_0206");
//            return;
//        }
//
//        //JSESSIONID와 loginInfo(명단)이 있을때 글쓰기 페이지로 이동
        req.getRequestDispatcher("/WEB-INF/_6_260206/_0206_todo/todoReg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //P:doPost
        //기능 처리
        //받을때 한글설정
//        req.setCharacterEncoding("UTF-8");
        log.info("todo/register 글쓰기 로직 처리하는 곳입니다.");
        log.info("PRG 패턴");

        try {
            //화면으로 부터 받은 데이터를 dto에 담음
            _0206_TodoDTO todoDTO = _0206_TodoDTO.builder()
                    .title(req.getParameter("title"))
                    .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                    .build();

            //서비스로 전달
            //보낼때 한글설정(없어도 되긴하던데)
//            resp.setContentType("text/htnl;charset=UTF-8");
//            resp.setCharacterEncoding("UTF-8");
            todoService.register(todoDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("regist error");
        }

        //R:sendRedirect
        //G:"/todo/list_0206"(get)
        resp.sendRedirect("/todo/list_0206");
    }
}
