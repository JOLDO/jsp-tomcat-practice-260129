package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.filter;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_MemberDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service._0209_MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//오늘 이해해보기
@Log4j2
@WebFilter(urlPatterns = "/todo/*") //주소에 root주소/todo/ 가 있는 모든 주소
public class _0209_LoginCheckFilter implements Filter {

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
            resp.sendRedirect("/login_0209");
        }

        // JSESSIONID 있고, loginInfo(명단), 로그인한 유저 정보가 있어요, -> 로그인 되었다고 가정.

        //임시 로그인 처리
        //세션이라는 공간에 로그인한 유저를 loginInfo라는 이름으로 저장
        if(session.getAttribute("loginInfo") != null) {
            log.info("로그인 정보가 없는 사용자입니다.");
//            resp.sendRedirect("/login_0209");
            chain.doFilter(request, response);
            return;
        }

        //로그인 시, 자동 로그인 체크 유무 1)멤버 테이블 uuid 생성 2)메모리의 로그인한 유저도 같은 uuid로 변경 3)같은 uuid, 쿠키에 담아서 웹브라우저에 전달
        //자동 로그인 체크가 된 상태에서 다시 목록 접근시, 필터가 동작을 해서 쿠키의 remember-me 값이 같다면 정상 로그인 처리하고, 없으면 다시 로그인
        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        //쿠키가 없으면 : 자동 로그인 체크 안했다는 뜻으로 그냥 로그인 화면으로 이동
        if(cookie == null) {
            resp.sendRedirect("/login_0209");
            return;
        }

        //쿠키가 있다면 테이터베이스에서 일치하는 uuid를 찾아서 로그인 처리
        String uuid = cookie.getValue();
        try {
            _0209_MemberDTO memberDTO = _0209_MemberService.INSTANCE.getByUUID(uuid);
            log.info("필터 검사에서 자동로그인 체크후 uuid로 유저 검색 결과 확인 : " + memberDTO);
            if(memberDTO == null) {
                resp.sendRedirect("/login_0209");
//                throw new Exception("쿠키 값 uuid 값이 유효하지 않아요!!");
            }

            //uuid 일치
            session.setAttribute("loginInfo", memberDTO);

            //필터 적용 후 다음으로 진행
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/login_0209");
        }

        //////////////////////////////
    }

    //쿠키를 찾는 메서드
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

        return targetCookie;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
