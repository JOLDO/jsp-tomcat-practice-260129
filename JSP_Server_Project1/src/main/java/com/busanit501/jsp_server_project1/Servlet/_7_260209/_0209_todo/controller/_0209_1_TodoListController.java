package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.controller;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service._0209_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "_1_todoListController_0209", urlPatterns = "/todo/list_0209")
@Log4j2 //로그를 중요도에 따라서 다르게 기록하는 방법
public class _0209_1_TodoListController extends HttpServlet {
    //controller <- service <- dao(controller는 service에 의존하고, service는 dao에 의존해서 사용중)(나중에 DI)
    //서비스의 기능을 사용
    private _0209_TodoService todoService = _0209_TodoService.INSTANCE;

    //웹 브라우저에서 웹주소 쳐서 화면 요청(get방식) -> doGet

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setCharacterEncoding("UTF-8");
        //log.info("sout대신 사용");
        log.info("=====전체 목록 조회=====");
        try {
            // 1. ServletContext 객체 얻기
            ServletContext context = getServletContext();

            // 2. web.xml에 설정된 파라미터 읽기
            String adminEmail = context.getInitParameter("adminEmail");
            String myEmail = context.getInitParameter("myEmail");

            // 3. 데이터 저장 (공유 목적)
            context.setAttribute("globalMessage", "안녕하세요, 모두와 공유하는 메시지입니다.");

            req.setAttribute("adminEmailDirect", adminEmail);
            req.setAttribute("myEmailDirect", myEmail);


            //service를 이용해 DB 데이터를 가져옴
            List<_0209_TodoDTO> dtoList = todoService.listAll();

            //서버에서 받아온 객체를 담아서 결과화면에 전달
            req.setAttribute("dtoList", dtoList);

            //결과화면으로 이동
            req.getRequestDispatcher("/WEB-INF/Servlet/_7_260209/_0209_todo/todoList.jsp")
                .forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
