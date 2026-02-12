package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.Exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController_Exam_1", urlPatterns = "/todo/list/exam1")
public class TodoListController_Exam_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        실습1
        현재까지 작업을 , 새로운 jsp 프로젝트 만들고, 톰캣 서버 연결.
        기존에 작업하는 자바코드, 화면코드를 이용해서, 화면에 표시, 참고 코드 참고해서, 작업 하기.
        1) _1_TodoListController 작업, 자바
        2) _3_TodoDTO 자바
        3) _4_TodoService 자바
        4) todoList.jsp 화면
        */
        List<TodoDTO_Exam_1_2> dtoList = TodoService_Exam_1_2.INSTANCE.getList();
        req.setAttribute("list", dtoList);

        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/Exam/list_Exam1.jsp").forward(req, resp);
    }
}
