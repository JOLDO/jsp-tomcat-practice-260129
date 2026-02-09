package com.busanit501.jsp_server_project1._7_260209._0209_todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "_7_logoutController_0209", urlPatterns = "/logout_0209")
public class _0209_7_LogoutController extends HttpServlet {
    //로그아웃 기능 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("로그아웃 처리를 담당하는 doPost입니다.");

        //임시 로그아웃 효과
        HttpSession session = req.getSession();

        //세션의 loginInfo라는 키를 삭제
        //세션은 서버에 저장되어있고 클라이언트에 쿠키로 저장되는데 그래서 요청을 받을때 세션을 읽고 지우고 invalidate로 다시 sync를 맞추면 됨
        //즉, 세션은 서버에 있기 때문에 지우고 싱크 맞춤
        session.removeAttribute("loginInfo");

        //쿠키삭제(maxage를 0으로 설정 하고 쿠키를 넣어줌)(클라이언트에 저장해 놓는 것이 쿠키이기 때문에 쿠키를 response에서 add로 보내서 없애야함)
        //쿠키는 서버에만 저장되기때문에 세팅값을 보내줘서 지우게 해야함
        Cookie cookie = findCookie(req.getCookies(), "remember-me");
        resp.addCookie(cookie);

        //적용
        session.invalidate();

        //리다이렉트
        resp.sendRedirect("/login_0209");
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        Cookie targetCookie = null;

        //전체 목록의 기본 유효성 체크, (not null, length > 0)
        if(cookies != null && cookies.length > 0) {
            for(Cookie ck : cookies) {
                if(ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }
        }

        if(targetCookie != null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");  //root경로로 지정
            targetCookie.setMaxAge(0);   //24시간동안 유지
        }

        return targetCookie;
    }
}
