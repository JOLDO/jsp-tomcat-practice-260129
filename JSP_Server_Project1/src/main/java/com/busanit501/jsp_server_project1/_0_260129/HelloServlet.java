package com.busanit501.jsp_server_project1._0_260129;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;
    private String message2;

    public void init() {
        message = "Hello World!!!!!";
        message2 = "오늘 점심 뭐 먹지?";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //한글 안깨지게 설정하려면, utf-8 설정 필요함
        response.setContentType("text/html;charset=UTF-8");
        //응답 문자의 인코딩, utf-8설정 필요함.
        response.setCharacterEncoding("UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message2 + "</h1>");
        out.println("<h1>" + message2 + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}