package com.busanit501.jsp_server_project1.SPRING._2_260219._1_bootStrap.controller;

import com.busanit501.jsp_server_project1.SPRING._2_260219._1_bootStrap.dto.TodoDTO_BootStrap_0219;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/_2_260219/bootstrap")    //http://localhost:8080/_2_260219/bootstrap/ 이후의 라우팅은 여기서 처리
@Log4j2
public class TodoController_BootStrap_0219 {
    @RequestMapping("/list")    //http://localhost:8080/_2_260219/bootstrap/list로 라우팅
    //추가로 뷰 리졸버가 연결되어서 bootstrap/list -> /WEB-INF/Spring/views/_2_260219/bootstrap/list.jsp
    public void list() {
        log.info("출력 todo list....");
    }

//    @RequestMapping(value="/register", method = RequestMethod.GET)  //http://localhost:8080/_2_260219/bootstrap/register로 라우팅
    @GetMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 bootstrap/list -> /WEB-INF/Spring/views/_2_260219/bootstrap/register.jsp
    public void getRegister() {
        log.info("출력 todo register..get!");
    }

    @PostMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 bootstrap/list -> /WEB-INF/Spring/views/_2_260219/bootstrap/register.jsp
    //화면에서 컴포넌트의 이름을 dto와 맞추고 dto로 받으면 dto객체로 자동적으로 생성해줌 spring mvc를 사용했기때문에
    //dto에 setter와 noArgsConstructor 어노테이션이 있기 때문에
    public void postRegister(TodoDTO_BootStrap_0219 todoDTO_BootStrap_0219) {
        //자동으로(@Data(Setter),@NoArgsConstructor를 이용해)
        //  TodoDTO_BootStrap_0219 dto = new TodoDTO_BootStrap_0219();
        //  dto.setTitle(title);
        //  dto.setWriter(writer);
        log.info("출력 todo register..post!");
        log.info("todoDTO 출력 : " + todoDTO_BootStrap_0219);
    }
}
