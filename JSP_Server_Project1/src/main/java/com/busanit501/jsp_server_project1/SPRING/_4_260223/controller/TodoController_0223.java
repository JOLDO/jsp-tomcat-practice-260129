package com.busanit501.jsp_server_project1.SPRING._4_260223.controller;

import com.busanit501.jsp_server_project1.SPRING._4_260223.dto.TodoDTO_0223;
import com.busanit501.jsp_server_project1.SPRING._4_260223.service.TodoService_0223;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/_4_260223/todo")    //http://localhost:8080/_4_260223/todo/ 이후의 라우팅은 여기서 처리
@Log4j2
@RequiredArgsConstructor
public class TodoController_0223 {

    private final TodoService_0223 todoService_0223;

    @RequestMapping("/list")    //http://localhost:8080/_4_260223/todo/list로 라우팅
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_4_260223/todo/list.jsp
    public void list(Model model) {
        log.info("todo list....");
        List<TodoDTO_0223> dtoList = todoService_0223.getAll();
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dtoList, 내용물: DB에서 받아온 목록들
        model.addAttribute("dtoList",dtoList);
    }
    //http://localhost:8080/_4_260223/todo/read?tno=38  //하나 조회
    //http://localhost:8080/_4_260223/todo/modify?tno=38  //하나 수정
    //주소가 거의 비슷해서 두개를 다 쓸수 있게 코드 재사용
    //화면도 거의 비슷함
    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model) {
        log.info("todo read...");
        TodoDTO_0223 todoDTO = todoService_0223.getOne(tno);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dto, 내용물: DB에서 받아온 목록들
        model.addAttribute("dto", todoDTO);
    }

    //------------------------------------실습
    @PostMapping("/modify")
    public String update(TodoDTO_0223 dto) {
        log.info("출력 todo modify..." + dto);
        todoService_0223.modify(dto);
        return "redirect:/_4_260223/todo/list";
    }
    //------------------------------------실습
    @PostMapping("/delete")
    public String delete(Long tno, RedirectAttributes redirectAttributes) {
        log.info("삭제 포스트 처리 작업");
        log.info("출력 삭제할 tno번호 확인 : " + tno);

        todoService_0223.remove(tno);

        return "redirect:/_4_260223/todo/list";
    }

//    @RequestMapping(value="/register", method = RequestMethod.GET)  //http://localhost:8080/_4_260223/todo/register로 라우팅
    @GetMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_4_260223/todo/register.jsp
    public void getRegister() {
        log.info("출력 todo register..get!");
    }

    @PostMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_4_260223/todo/register.jsp
    //화면에서 컴포넌트의 이름을 dto와 맞추고 dto로 받으면 dto객체로 자동적으로 생성해줌 spring mvc를 사용했기때문에
    //dto에 setter와 noArgsConstructor 어노테이션이 있기 때문에
    //유효성 체크시 주의 사항은 @Valid가 붙은 객체 이후엔 바로 BindingResult가 와야함(순서)
    public String postRegister(@Valid TodoDTO_0223 todoDTO_0223,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        //자동으로(@Data(Setter),@NoArgsConstructor를 이용해)
        //  TodoDTO_0223 dto = new TodoDTO_0223();
        //  dto.setTitle(title);
        //  dto.setWriter(writer);
        log.info("todo register..post!");
        log.info("todoDTO : " + todoDTO_0223);

        //유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다.");
            //"errors"란 이름으로 오류 이유들을 담아서 서버에서 화면으로 임시 데이터로 전달
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/_4_260223/todo/register";
        }

        //서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달
        todoService_0223.register(todoDTO_0223);
        log.info("유효성 통과한 데이터.");
        return "redirect:/_4_260223/todo/list";
    }
}
