package com.busanit501.jsp_server_project1.Servlet._1_260130._0_MVC_Get_Post.Exam._0_Exam_1_Menu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menuInputController", urlPatterns = "/menu/input")
public class _0_Exam_1_MenuInputController extends HttpServlet {
    /*
    실습1

    doGet용
    1) 패키지명 : ex1_menu
    2) 클래스 : MenuInputController
       컨트롤러의 경로 : urlPatterns = "/menu/input")
    3) 화면 : /WEB-INF/_0130_1_menu/menuInput.jsp
       menuInput.jsp -> 메뉴명 : 입력을 받아서, 입력란 1개와 버튼 구성.
       form 방식으로 구성.

    doPost 용
    1) 패키지명 : ex1_menu
    2) 클래스 : MakeResultController
    3) 화면 : makeResultMenu.jsp (화면은 더미)
    4) 결과 화면: 콘솔에 로그 기록으로 남김.
       결과 : 주문 받은 메뉴 : ~~~ 입니다.
       버튼을 추가, 주문버튼, 클릭시, post 로 전달
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/Servlet/_1_260130/_0130_1_menu/menuInput.jsp");
        dispatcher.forward(req, resp);
    }
}
