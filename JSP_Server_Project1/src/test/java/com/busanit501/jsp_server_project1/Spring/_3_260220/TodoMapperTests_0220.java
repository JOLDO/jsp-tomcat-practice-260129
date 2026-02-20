package com.busanit501.jsp_server_project1.Spring._3_260220;

import com.busanit501.jsp_server_project1.SPRING._3_260220.domain.TodoVO_0220;
import com.busanit501.jsp_server_project1.SPRING._3_260220.mapper.TodoMapper_0220;
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
public class TodoMapperTests_0220 {
    @Autowired(required = false)
    //해당 객체를 활성화를 못하더라도 예외 발생 없이 null로 할당
    private TodoMapper_0220 todoMapper_0220;

    @Test
    public void testGetTime() {
        log.info("출력 - 시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper_0220.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO_0220 todoVO_0220 = TodoVO_0220.builder()
            .title("뭐!!")
            .dueDate(LocalDate.now())
            .writer("오태흔")
            .build();
        todoMapper_0220.insert(todoVO_0220);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO_0220> voList = todoMapper_0220.selectAll();
        voList.forEach(vo -> log.info(vo));
    }
}
