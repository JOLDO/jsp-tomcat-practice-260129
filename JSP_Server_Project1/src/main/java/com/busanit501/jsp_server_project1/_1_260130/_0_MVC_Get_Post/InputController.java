package com.busanit501.jsp_server_project1._1_260130._0_MVC_Get_Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//컨트롤러가 클라이언트 역할로 /calc/input찾고
//서버 InputController클래스로 안내함
@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    //화면제공을 하는데 이유는 클라이언트가 화면 요구해서


    //화면 제공하는 역할
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.요청이 왔는지 확인
        System.out.println("InputController의 doGet 메서드에 요청이 도착");
        //2.어느 화면으로 이동할지 결정
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/_0130_0_calc/input.jsp");
        //dispatcher는 화면이동
        dispatcher.forward(req, resp);

        // 확인.
        // 웹브라우저에서,
        // http://localhost:8080/calc/input
        // 서버, 자바 코드 작업 후, 반드시 모두 배포 해주세요.,
        // 나중에, 자동 리로드가 됩니다. 일단, 지금은 수동으로.,
    }
}
