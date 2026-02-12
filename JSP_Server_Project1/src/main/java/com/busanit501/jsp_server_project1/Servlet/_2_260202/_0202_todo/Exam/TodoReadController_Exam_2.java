package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.Exam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController_Exam_2", urlPatterns = "/todo/read/exam2")
public class TodoReadController_Exam_2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        실습2
        1. _4_TodoService 작업확인
        2. _3_TodoReadController 작업확인
        3. _3_todoRead.jsp 작업확인
        4. 웹브라우저에서 호출해서, 확인.

        5. 추가로
        각각의 이름만 변경해서, 작업하기. 내용은 동일하게,

        _4_TodoService : _4_MenuService
        _3_TodoReadController : _3_MenuReadController
        _3_todoRead.jsp : _3_menuRead.jsp
        _3_TodoDTO : _3_MenuDTO
        */
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoDTO_Exam_1_2 dto = TodoService_Exam_1_2.INSTANCE.get(tno);
        req.setAttribute("dto", dto);
        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/Exam/read_Exam2.jsp").forward(req, resp);

    }
}
