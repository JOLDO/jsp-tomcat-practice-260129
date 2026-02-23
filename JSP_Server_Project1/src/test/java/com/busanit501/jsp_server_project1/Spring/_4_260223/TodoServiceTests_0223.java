package com.busanit501.jsp_server_project1.Spring._4_260223;

import com.busanit501.jsp_server_project1.SPRING._4_260223.dto.TodoDTO_0223;
import com.busanit501.jsp_server_project1.SPRING._4_260223.service.TodoService_0223;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2 //로그를 기록하는 로그레벨 기준에따라 로그를 기록
@ExtendWith(SpringExtension.class)  //Junit5 단위 테스트 기능 통합 설정   스프링기능(@Autowired)추가 해서 테스트할때 사용
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")  //스프링 기능을 테스트하기 위해 스프링의 bean설정된 파일을 지정해줌
public class TodoServiceTests_0223 {
    //autowired보다는 생성자로 주입하는게 더 좋은 방식이지만
    //test에서 생성자 주입이 안되서(Spring이 아니라 JUnit단위에서 테스트 해서)
    //final로 만들었던 bean으로 등록된 것을 가져오지 못함 그래서 autowired로 가져와서 사용
    //결론은 test에서는 통상적으로 autowired로 간단하게 사용하고 실제 사용에는 객체 생성해서 주입해서 사용
    @Autowired
    TodoService_0223 todoService_0223;  //autowired보다는 생성자로 주입하는게 더 좋은 방식이지만

    @Test
    public void testRegister() {
        TodoDTO_0223 todoDTO_0223 = TodoDTO_0223.builder()
            .title("뭐!!2")
            .dueDate(LocalDate.now())
            .writer("오태흔")
            .build();
        todoService_0223.register(todoDTO_0223);
    }

    @Test
    public void testGetAll() {
        List<TodoDTO_0223> dtoList = todoService_0223.getAll();
        dtoList.forEach(dto -> log.info(dto));
    }

    @Test
    public void testGetOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoDTO_0223 todoDTO = todoService_0223.getOne(32L);
        log.info(todoDTO);
    }

    @Test
    public void testDelete() {
        todoService_0223.remove(62L);
        log.info("출력 삭제완료");
    }

    @Test
    public void testModify() {
        TodoDTO_0223 todoDTO_0223 = TodoDTO_0223.builder()
                .tno(1L).title("ㅋㅋㄹㅃㅃ2").dueDate(LocalDate.now().plusDays(2L)).writer("졸졸").finished(false).build();
        todoService_0223.modify(todoDTO_0223);
    }
}
