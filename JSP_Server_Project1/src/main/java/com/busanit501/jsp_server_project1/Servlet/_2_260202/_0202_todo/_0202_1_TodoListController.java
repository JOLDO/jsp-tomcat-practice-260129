package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo;

import com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.dto._0202_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.service._0202_TodoService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "_1_todoListController_0202", urlPatterns = "/todo/list_0202")
public class _0202_1_TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("여기 왔다는 건, 클라이언트, url 주소 요청하고, 서버가 응답을 한다. ");
        System.out.println("서버가 일을 하고 있다. 조금 있다 화면을 웹브라우저에게 던져준다. ");
        System.out.println("/todo/list_0202, get으로 요청 처리함. ");

        List<_0202_TodoDTO> dtoList = _0202_TodoService.INSTANCE.getList();
        req.setAttribute("list", dtoList);

        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/_0202_todo/todoList.jsp").forward(req, resp);
    }
}
