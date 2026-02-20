package com.busanit501.jsp_server_project1.Spring._3_260220;

import com.busanit501.jsp_server_project1.SPRING._3_260220.dto.TodoDTO_0220;
import com.busanit501.jsp_server_project1.SPRING._3_260220.service.TodoService_0220;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2 //로그를 기록하는 로그레벨 기준에따라 로그를 기록
@ExtendWith(SpringExtension.class)  //Junit5 단위 테스트 기능 통합 설정   스프링기능(@Autowired)추가 해서 테스트할때 사용
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")  //스프링 기능을 테스트하기 위해 스프링의 bean설정된 파일을 지정해줌
public class TodoServiceTests_0220 {
    //autowired보다는 생성자로 주입하는게 더 좋은 방식이지만
    //test에서 생성자 주입이 안되서(Spring이 아니라 JUnit단위에서 테스트 해서)
    //final로 만들었던 bean으로 등록된 것을 가져오지 못함 그래서 autowired로 가져와서 사용
    //결론은 test에서는 통상적으로 autowired로 간단하게 사용하고 실제 사용에는 객체 생성해서 주입해서 사용
    @Autowired
    TodoService_0220 todoService_0220;  //autowired보다는 생성자로 주입하는게 더 좋은 방식이지만

    @Test
    public void testRegister() {
        TodoDTO_0220 todoDTO_0220 = TodoDTO_0220.builder()
            .title("뭐!!2")
            .dueDate(LocalDate.now())
            .writer("오태흔")
            .build();
        todoService_0220.register(todoDTO_0220);
    }
}
