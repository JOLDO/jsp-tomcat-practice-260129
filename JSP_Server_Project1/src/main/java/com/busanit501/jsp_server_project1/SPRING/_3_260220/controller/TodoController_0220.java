package com.busanit501.jsp_server_project1.SPRING._3_260220.controller;

import com.busanit501.jsp_server_project1.SPRING._3_260220.dto.TodoDTO_0220;
import com.busanit501.jsp_server_project1.SPRING._3_260220.service.TodoService_0220;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/_3_260220/todo")    //http://localhost:8080/_3_260220/todo/ 이후의 라우팅은 여기서 처리
@Log4j2
@RequiredArgsConstructor
public class TodoController_0220 {

    private final TodoService_0220 todoService_0220;

    @RequestMapping("/list")    //http://localhost:8080/_3_260220/todo/list로 라우팅
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_3_260220/todo/list.jsp
    public void list() {
        log.info("출력 todo list....");
    }

//    @RequestMapping(value="/register", method = RequestMethod.GET)  //http://localhost:8080/_3_260220/todo/register로 라우팅
    @GetMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_3_260220/todo/register.jsp
    public void getRegister() {
        log.info("출력 todo register..get!");
    }

    @PostMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_3_260220/todo/register.jsp
    //화면에서 컴포넌트의 이름을 dto와 맞추고 dto로 받으면 dto객체로 자동적으로 생성해줌 spring mvc를 사용했기때문에
    //dto에 setter와 noArgsConstructor 어노테이션이 있기 때문에
    //유효성 체크시 주의 사항은 @Valid가 붙은 객체 이후엔 바로 BindingResult가 와야함(순서)
    public String postRegister(@Valid TodoDTO_0220 todoDTO_0220,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        //자동으로(@Data(Setter),@NoArgsConstructor를 이용해)
        //  TodoDTO_0220 dto = new TodoDTO_0220();
        //  dto.setTitle(title);
        //  dto.setWriter(writer);
        log.info("출력 todo register..post!");
        log.info("todoDTO 출력 : " + todoDTO_0220);

        //유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다.");
            //"errors"란 이름으로 오류 이유들을 담아서 서버에서 화면으로 임시 데이터로 전달
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/_3_260220/todo/register";
        }

        //서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달
        todoService_0220.register(todoDTO_0220);
        log.info("유효성 통과한 데이터.");
        return "redirect:/_3_260220/todo/list";
    }
}
