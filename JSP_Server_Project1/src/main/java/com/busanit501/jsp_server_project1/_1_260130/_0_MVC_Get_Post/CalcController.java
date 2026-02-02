package com.busanit501.jsp_server_project1._1_260130._0_MVC_Get_Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //클라이언트에 값 전달받아 사용
        //전달 받은 값은 req에서 꺼내 쓴다.
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        System.out.println(num1 + "   " + num2);
    }
}
