package com.busanit501._0_260129._0_Exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "exam1", value = "/exam1")
public class _0_Exam_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        1. 새 프로젝트 생성, 톰캣 서버 설정하기. 실행해서 기본 출력해보기.

        2. 나의 서블릿 클래스 파일 : MyServlet2 등 만들어서,
        서버에서, html 문서를 만들어서, 웹브라우저에게 전달해서, 출력하기.
        내용은 간단히 본인 소개.
        */
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp. getWriter();
        out.println("<html><body>");
        out.println("<h1>!!!<h1>");
        out.println("</body><html>");

    }
}
