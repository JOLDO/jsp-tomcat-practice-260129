package com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "_6_loginController_0206", urlPatterns = "/login_0206")
public class _0206_6_LoginController extends HttpServlet {
    //로그인 화면
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그인 화면을 제공하는 컨트롤러입니다.");
        req.getRequestDispatcher("/WEB-INF/Servlet/_6_260206/login.jsp").forward(req, resp);
    }

    //로그인 기능 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그인 처리를 담당하는 doPost입니다.");

        //화면에서 전달받은 mid, mpw 정보를 가져오기(기본적으로 문자열).
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        //임시로 아이디+패스워드 형식으로 loginInfo 저장
        String mid_mpw = mid + mpw;

        //세션 객체를 이용해서 서버의 세션이라는 저장공간에 키 : loginInfo 저장
        //값 : 아이디_패스워드 저장
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", mid_mpw);

        //세션을 이용해서 불러오기
        Object loginInfo = session.getAttribute("loginInfo");
        String loginInfoStr = (String) loginInfo;

        //저장 후 불러온 값 출력
        log.info("세션에 저장된 loginInfo 불러와서 확인 : " + loginInfoStr);

        resp.sendRedirect("/todo/list_0206");
    }
}
