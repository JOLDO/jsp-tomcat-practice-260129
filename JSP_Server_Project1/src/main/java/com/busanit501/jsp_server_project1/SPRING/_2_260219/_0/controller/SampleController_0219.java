package com.busanit501.jsp_server_project1.SPRING._2_260219._0.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/_2_260219")
@Log4j2
public class SampleController_0219 {

    @GetMapping("/hello")
    public void hello() {
        log.info("출력hello spring mvc!!");
    }

    //화면에서 get 데이터를 서버에게 전달하는 방법
    //쿼리 스트링 이용
    //http://localhost:8080/_2_260219/ex1?name=오태흔&age=37
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("출력 ex1 !!!!");
        log.info("출력 데이터 수집 : name : " + name);
        log.info("출력 데이터 수집 : age : " + age);
    }

    //http://localhost:8080/_2_260219/ex2
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name", defaultValue="뭐???") String name,
                    @RequestParam(name="age", defaultValue="3045") int age,
                    Model model) {
        log.info("출력 ex2 !!!!");
        log.info("출력 데이터 수집 : name : " + name);
        log.info("출력 데이터 수집 : age : " + age);
        //쿼리 스트링으로 값을 준다면 jsp에서 ${param.name}과 ${param.age}로 값을 받을수 있지만
        //쿼리 스트링없이는 param을 사용할수가 없음
        //쿼리스트링이 없을때 나오는 기본값을 받으려면 Model 객체를 이용해 jsp에서 값을 사용할수 있게해야함
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

    //http://localhost:8080/_2_260219/ex3?dueDate=2026-02-19
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        //servlet-context.xml에서 com.busanit501.jsp_server_project1.SPRING._2_260219.controller.formatter.LocalDateFormatter_0219
        //의 설정한 클래스를 등록해준 후 실행해야 함
        //parse와 print시에 자동으로 사용이 되기때문에 잘 될듯(LocalDate일때만)
        log.info("출력 ex3 !!!!");
        log.info("출력 데이터 수집 : dueDate : " + dueDate);
    }

    //http://localhost:8080/_2_260219/ex4
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("출력 ex4 !!!!");
        log.info("출력 데이터를 받아서 화면에 전달");
        //화면에 데이터를 model을 이용해서 전달
        model.addAttribute("msg", "hello!!");
        model.addAttribute("msg2", "<script>alert('ㅋ')</script>");
    }

    //http://localhost:8080/_2_260219/ex5
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5 ~~~");
        log.info("데이터 받아서 화면에 전달 1) 쿼리스트링으로 전달 2) 1회용으로 전달  ");
        //1)쿼리스트링
        redirectAttributes.addAttribute("name","TEST EX5");

        //2)1회용
        redirectAttributes.addFlashAttribute("result","success");

        //리다이렉트
        return "redirect:/_2_260219/ex6";
        //ex5로 라우팅하면 ex6으로 리다이렉트하기 때문에 ex5의 화면은 없다.
    }
    @GetMapping("/ex6")
    public void ex6() {
        //ex6에서 새로고침을 하면 쿼리스트링은 계속 유지 되지만 1회용으로 보낸값은 없어진다.
    }

    //http://localhost:8080/_2_260219/ex7?p1=asd&p2=qwe
    @GetMapping("/ex7")
    //쿼리스트링으로 값을 보내면 문자열로 받아오기때문에 숫자타입에서 에러가 발생
    public void ex7(String p1, int p2) {
        log.info("p1 : " + p1);
        log.info("p2 : " + p2);
    }
}
