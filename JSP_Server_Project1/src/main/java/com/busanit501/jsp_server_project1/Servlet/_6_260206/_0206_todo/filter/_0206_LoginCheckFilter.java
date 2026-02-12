package com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//오늘 이해해보기
@Log4j2
//@WebFilter(urlPatterns = "/todo/*") //주소에 root주소/todo/ 가 있는 모든 주소
public class _0206_LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //실제 동작을 정의 및 체크
        log.info("로그인 체크 필터1, 테스트");

        //컨트롤러에 가서 라우팅 및 원래 하던 일 처리

        // ServletRequest : 범위가 좀더 커서, 기능이 추상적이라서,
        // 좀더 구체적인 타입으로 변경해서 작업, HttpServletRequest 으로 타입을 변경.
        // ServletResponse : 범위가 좀더 커서, 기능이 추상적이라서,
        // 좀더 구체적인 타입으로 변경해서 작업, HttpServletResponse 으로 타입을 변경.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //기존 글쓰기 폼화면에서 작업한 코드 주입
        //////////////////////////////
        //화면 응답
        log.info("임시화면 get으로 요청 처리함.");

        //화면 접근 전 세션에서 로그인 유저 체크
        //JSESSIONID를 체크 후 있으면 진행, 없으면 로그인화면으로 이동
        HttpSession session = req.getSession(); //세션 객체 생성

        //기존 사용자인지 새로운 사용자인지 확인
        if(session.isNew()) {
            //새로운 이용자
            //서버 : JSESSIONID 생성, 서버 메모리에 저장 후 웹브라우저(클라이언트)에게 쿠키에 담아서 보냄
            log.info("JSESSIONID 쿠키가 새롭게 만들어진 사용자");

            //로그인 화면으로 이동
            resp.sendRedirect("/login_0206");
        }

        // JSESSIONID 있고, loginInfo(명단), 로그인한 유저 정보가 있어요, -> 로그인 되었다고 가정.

        //임시 로그인 처리
        //세션이라는 공간에 로그인한 유저를 loginInfo라는 이름으로 저장
        if(session.getAttribute("loginInfo") == null) {
            log.info("로그인 정보가 없는 사용자입니다.");
            resp.sendRedirect("/login_0206");
            return;
        }

        //필터 적용 후 다음으로 진행
        chain.doFilter(request, response);
        //////////////////////////////
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
