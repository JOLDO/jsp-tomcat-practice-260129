package com.busanit501.jsp_server_project1._3_260203._0203_todo;

import com.busanit501.jsp_server_project1._3_260203._0203_todo.dto._0203_TodoDTO;
import com.busanit501.jsp_server_project1._3_260203._0203_todo.service._0203_TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_3_todoReadController_0203", urlPatterns = "/todo/read_0203")
public class _0203_3_TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //현재 작업하는 파일 위치를 서버 콘솔에 출력
        System.out.println("/todo/read_0203, 상세정보 폼 임시화면 get으로 요청 처리함. ");

        //임시로 조회할 하나의 더미 데이터 지정
        //웹브라우저에서 주소요청: http://localhost:8080/todo/read_0203?tno=100
        //서버는 웹에서 전달한 데이터 가져오기
        Long tno = Long.parseLong(req.getParameter("tno"));    //문자열 형태로 데이터 읽어옴
        _0203_TodoDTO dto = _0203_TodoService.INSTANCE.get(tno);

        //데이터 전달 준비
        req.setAttribute("dto", dto);

        //화면에 데이터 전달
        req.getRequestDispatcher("/WEB-INF/_3_260203/_0203_todo/todoRead.jsp").forward(req, resp);
    }
}
