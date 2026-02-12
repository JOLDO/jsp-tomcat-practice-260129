package com.busanit501.jsp_server_project1.Servlet._2_260202._0202_todo.Practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "practiceController", urlPatterns = "/practice")
public class PracticeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int count = Integer.parseInt(req.getParameter("num"));
        List<PracticeDTO> practiceDTOS = PracticeService.PRACTICE.getList();
        PracticeDTO practiceDTO = PracticeService.PRACTICE.get(count);
        req.setAttribute("practice", practiceDTO);
        req.setAttribute("practiceList", practiceDTOS);

        req.getRequestDispatcher("/WEB-INF/Servlet/_2_260202/Practice/practice.jsp").forward(req, resp);
    }
}
