package com.busanit501.jsp_server_project1._7_260209._0209_todo.controller;

import com.busanit501.jsp_server_project1._7_260209._0209_todo.dto._0209_MemberDTO;
import com.busanit501.jsp_server_project1._7_260209._0209_todo.service._0209_MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet(name = "_6_loginController_0209", urlPatterns = "/login_0209")
public class _0209_6_LoginController extends HttpServlet {
    //멤버 서비스 객체 가져오기
    _0209_MemberService memberService = _0209_MemberService.INSTANCE;

    //로그인 화면
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그인 화면을 제공하는 컨트롤러입니다.");
        req.getRequestDispatcher("/WEB-INF/_7_260209/login.jsp").forward(req, resp);
    }

    //로그인 기능 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그인 처리를 담당하는 doPost입니다.");

        //화면에서 전달받은 mid, mpw 정보를 가져오기(기본적으로 문자열).
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String auto = req.getParameter("auto"); //체크의 경우 "on", 체크가 아닐경우 null

        //자동로그인 상태 체크 변수
        boolean rememberMe = auto != null && auto.equals("on");
        try {
            _0209_MemberDTO memberDTO = memberService.login(mid, mpw);
            if(rememberMe) {
                //uuid 클래스를 이용해서 랜덤 문자열 생성
                String uuid = UUID.randomUUID().toString();
                log.info("생성된 uuid 값 확인 : " + uuid);

                memberService.updateUuid(mid, uuid);

                //멤버 테이블에 업데이트된 내용을 로그인한 유저의 상태에도 똑같이 적용
                memberDTO.setUuid(uuid);

                //쿠키전달  서버 : 쿠키 생성, 서버가 웹브라우저에게 쿠키를 전달
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                //유효기간 7일
                rememberCookie.setMaxAge(60 * 60 * 24 * 7);
                rememberCookie.setPath("/");

                //서버에 전달
                resp.addCookie(rememberCookie);
            }
            //세션에 기록
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list_0209");
        } catch (Exception e) {
            resp.sendRedirect("/login_0209?result=error");
        }
    }
}
