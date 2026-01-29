package com.busanit501._0_260129;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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