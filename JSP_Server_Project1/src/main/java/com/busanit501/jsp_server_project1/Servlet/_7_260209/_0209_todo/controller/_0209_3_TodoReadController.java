package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service._0209_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "_3_todoReadController_0209", urlPatterns = "/todo/read_0209")
public class _0209_3_TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //현재 작업하는 파일 위치를 서버 콘솔에 출력
        log.info("/todo/read_0209, 상세정보 폼 임시화면 get으로 요청 처리함. ");

        //임시로 조회할 하나의 더미 데이터 지정
        //웹브라우저에서 주소요청: http://localhost:8080/todo/read_0209?tno=100
        //서버는 웹에서 전달한 데이터 가져오기
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));    //문자열 형태로 데이터 읽어옴
            _0209_TodoDTO todoDTO = _0209_TodoService.INSTANCE.get(tno);
            req.setAttribute("dto", todoDTO);

            //웹 브라우저에서 쿠키를 찾고 없으면 생성, 있으면 유지하고 기록
            //findCookie 메서드를 이용해서 쿠기 목록을 찾고, 쿠키의 이름(viewTodos)으로 검색
            Cookie viewTodosCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodosCookie.getValue();    //예시 : "25-3-" tno : 25, todo를 조회하고 tno : 3 todo를 하나 조회함

            //상테 변수
            boolean exist = false;
            if(todoListStr != null && todoListStr.indexOf(tno+"-") >= 0) {
                exist = true;
            }
            log.info("exist : " + exist);

            //만약 기록이 없다면, 새로 문자열ㄹ에 내용을 추가   예시 : "25-3-"
            if(!exist) {
                todoListStr += tno + "-";
                viewTodosCookie.setValue(todoListStr);
                viewTodosCookie.setMaxAge(60 * 60 * 24);
                viewTodosCookie.setPath("/");

                //응답 객체로 웹브라우저에 쿠키 전달
                resp.addCookie(viewTodosCookie);
            }

            req.getRequestDispatcher("/WEB-INF/Servlet/_7_260209/_0209_todo/todoRead.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
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
        if(targetCookie == null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");  //root경로로 지정
            targetCookie.setMaxAge(60 * 60 * 24);   //24시간동안 유지
        }

        return targetCookie;
    }
}
