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
@WebServlet(name = "_7_logoutController_0206", urlPatterns = "/logout_0206")
public class _0206_7_LogoutController extends HttpServlet {
    //로그아웃 기능 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그아웃 처리를 담당하는 doPost입니다.");

        //임시 로그아웃 효과
        HttpSession session = req.getSession();

        //세션의 loginInfo라는 키를 삭제
        session.removeAttribute("loginInfo");

        //적용
        session.invalidate();

        //리다이렉트
        resp.sendRedirect("/login_0206");
    }
}
