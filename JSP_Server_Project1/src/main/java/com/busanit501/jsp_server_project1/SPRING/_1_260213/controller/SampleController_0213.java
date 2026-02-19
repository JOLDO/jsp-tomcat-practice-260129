package com.busanit501.jsp_server_project1.SPRING._1_260213.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/_1_260213")
@Log4j2
public class SampleController_0213 {

    @GetMapping("/hello")
    public void hello() {
        log.info("출력hello spring mvc!!");
    }

    //화면에서 get 데이터를 서버에게 전달하는 방법
    //쿼리 스트링 이용
    //http://localhost:8080/_1_260213/ex1?name=오태흔&age=37
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("출력 ex1 !!!!");
        log.info("출력 데이터 수집 : name : " + name);
        log.info("출력 데이터 수집 : age : " + age);
    }

    //http://localhost:8080/_1_260213/ex2
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name", defaultValue="뭐???") String name,
                    @RequestParam(name="age", defaultValue="3045") int age) {
        log.info("출력 ex2 !!!!");
        log.info("출력 데이터 수집 : name : " + name);
        log.info("출력 데이터 수집 : age : " + age);
    }

    //http://localhost:8080/_1_260213/ex3?dueDate=2026-02-13
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        //servlet-context.xml에서 com.busanit501.jsp_server_project1.SPRING._1_260213.controller.formatter.LocalDateFormatter_0213
        //의 설정한 클래스를 등록해준 후 실행해야 함
        //parse와 print시에 자동으로 사용이 되기때문에 잘 될듯(LocalDate일때만)
        log.info("출력 ex3 !!!!");
        log.info("출력 데이터 수집 : dueDate : " + dueDate);
    }

    //http://localhost:8080/_1_260213/ex4
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("출력 ex4 !!!!");
        log.info("출력 데이터를 받아서 화면에 전달");
        //화면에 데이터를 model을 이용해서 전달
        model.addAttribute("msg", "hello!!");
        model.addAttribute("msg2", "<script>alert('ㅋ')</script>");
    }
}
