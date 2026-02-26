package com.busanit501.jsp_server_project1.SPRING._7_260226.controller;

import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageRequestDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageResponseDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.TodoDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.service.TodoService_0226;
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

@Controller
@RequestMapping("/_7_260226/todo")    //http://localhost:8080/_7_260226/todo/ 이후의 라우팅은 여기서 처리
@Log4j2
@RequiredArgsConstructor
public class TodoController_0226 {

    private final TodoService_0226 todoService_0226;

//    페이징 처리 전 목록 조회
//    @RequestMapping("/list")    //http://localhost:8080/_7_260226/todo/list로 라우팅
//    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_7_260226/todo/list.jsp
//    public void list(Model model) {
//        log.info("todo list....");
//        List<TodoDTO_0226> dtoList = todoService_0226.getAll();
//        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dtoList, 내용물: DB에서 받아온 목록들
//        model.addAttribute("dtoList",dtoList);
//    }

    //페이징 처리 후 목록 조회
    //화면으로부터 보고있는 page와 size를 DTO로 받음
    @RequestMapping("/list")    //http://localhost:8080/_7_260226/todo/list로 라우팅
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_7_260226/todo/list.jsp
    //http://localhost:8080/_7_260226/todo/list?page=1&size=20&pageSize=7 이렇게 페이지와 사이즈를 지정해서 뿌려줄수도 있는데
    //기본적으로 dto에서 default로 지정한 page=1, size=10으로 들어감
    //http://localhost:8080/_7_260226/todo/list?page=1&size=10&pageSize=10으로 되고 이건 http://localhost:8080/_7_260226/todo/list와 같음
    //스프링은 화면에 기본적으로 매게변수의 값을 전달해준다.
    public void list(@Valid PageRequestDTO_0226 pageRequestDTO_0226, BindingResult bindingResult, Model model) {
        log.info("pageRequestDTO_0226 : " + pageRequestDTO_0226);
        log.info("todo list....페이징 처리가 된 리스트 조회");

        //유효성 체크에 걸림
        if(bindingResult.hasErrors()) {
            pageRequestDTO_0226 = PageRequestDTO_0226.builder().build();
        }

        PageResponseDTO_0226<TodoDTO_0226> responseDTO_0226 = todoService_0226.getList(pageRequestDTO_0226);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dtoList, 내용물: DB에서 받아온 목록들
        model.addAttribute("responseDTO",responseDTO_0226);
    }

    //http://localhost:8080/_7_260226/todo/read?tno=38  //하나 조회
    //http://localhost:8080/_7_260226/todo/modify?tno=38  //하나 수정
    //주소가 거의 비슷해서 두개를 다 쓸수 있게 코드 재사용
    //화면도 거의 비슷함
    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO_0226 pageRequestDTO_0226, Model model) {
        log.info("todo read...");
        TodoDTO_0226 todoDTO = todoService_0226.getOne(tno);
        // 서버 -> 화면에 데이터 목록들을 전달. 박스 이름 : dto, 내용물: DB에서 받아온 목록들
        model.addAttribute("dto", todoDTO);
        log.info("출력");
    }

    //------------------------------------실습
    @PostMapping("/modify")
    public String postModify(@Valid TodoDTO_0226 dto,
                         BindingResult bindingResult,
                         PageRequestDTO_0226 pageRequestDTO_0226,
                         RedirectAttributes redirectAttributes) {
        log.info("출력 todo modify..." + dto);

        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다.");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", dto.getTno());
            //        redirectAttributes.addAttribute("page", 1);
            redirectAttributes.addAttribute("page", pageRequestDTO_0226.getPage());
            redirectAttributes.addAttribute("size", pageRequestDTO_0226.getSize());
            return "redirect:/_7_260226/todo/modify";
        }

        todoService_0226.modify(dto);
//        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("tno", dto.getTno());
        redirectAttributes.addAttribute("page",pageRequestDTO_0226.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO_0226.getSize());
        return "redirect:/_7_260226/todo/read";
    }

    //------------------------------------실습
    @PostMapping("/delete")
    // 수정 화면에서, 삭제시 -> 히든으로 숨겨둔 페이지, 사이즈 정보를 , page, size 전달을 하면,
    // PageRequestDTO 자동으로 데이터를 맵핑을 함.
    public String delete(Long tno, PageRequestDTO_0226 pageRequestDTO_0226, RedirectAttributes redirectAttributes) {
        log.info("삭제 포스트 처리 작업");
        log.info("출력 삭제할 tno번호 확인 : " + tno);

        todoService_0226.remove(tno);

        // 서버에서 -> 화면으로 데이터를 전달시, 쿼리 스트링으로 전달하는 방법.
//        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("page", pageRequestDTO_0226.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO_0226.getSize());


        return "redirect:/_7_260226/todo/list?" + pageRequestDTO_0226.getLink();
    }

//    @RequestMapping(value="/register", method = RequestMethod.GET)  //http://localhost:8080/_7_260226/todo/register로 라우팅
    @GetMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_7_260226/todo/register.jsp
    public void getRegister() {
        log.info("출력 todo register..get!");
    }

    @PostMapping("/register")
    //추가로 뷰 리졸버가 연결되어서 todo/list -> /WEB-INF/Spring/views/_7_260226/todo/register.jsp
    //화면에서 컴포넌트의 이름을 dto와 맞추고 dto로 받으면 dto객체로 자동적으로 생성해줌 spring mvc를 사용했기때문에
    //dto에 setter와 noArgsConstructor 어노테이션이 있기 때문에
    //유효성 체크시 주의 사항은 @Valid가 붙은 객체 이후엔 바로 BindingResult가 와야함(순서)
    public String postRegister(@Valid TodoDTO_0226 todoDTO_0226,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        //자동으로(@Data(Setter),@NoArgsConstructor를 이용해)
        //  TodoDTO_0226 dto = new TodoDTO_0226();
        //  dto.setTitle(title);
        //  dto.setWriter(writer);
        log.info("todo register..post!");
        log.info("todoDTO : " + todoDTO_0226);

        //유효성 체크
        if(bindingResult.hasErrors()) {
            log.info("유효성 오류가 있습니다.");
            //"errors"란 이름으로 오류 이유들을 담아서 서버에서 화면으로 임시 데이터로 전달
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/_7_260226/todo/register";
        }

        //서비스의 도움을 받아서, 화면으로 부터 전달 받은 데이터를 전달
        todoService_0226.register(todoDTO_0226);
        log.info("유효성 통과한 데이터.");
        return "redirect:/_7_260226/todo/list";
    }
}
