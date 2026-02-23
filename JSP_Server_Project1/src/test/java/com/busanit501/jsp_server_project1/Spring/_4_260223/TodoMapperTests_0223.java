package com.busanit501.jsp_server_project1.Spring._4_260223;

import com.busanit501.jsp_server_project1.SPRING._4_260223.domain.TodoVO_0223;
import com.busanit501.jsp_server_project1.SPRING._4_260223.mapper.TodoMapper_0223;
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
public class TodoMapperTests_0223 {
    @Autowired(required = false)
    //해당 객체를 활성화를 못하더라도 예외 발생 없이 null로 할당
    private TodoMapper_0223 todoMapper_0223;

    @Test
    public void testGetTime() {
        log.info("출력 - 시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper_0223.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO_0223 todoVO_0223 = TodoVO_0223.builder()
            .title("뭐!!")
            .dueDate(LocalDate.now())
            .writer("오태흔")
            .build();
        todoMapper_0223.insert(todoVO_0223);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO_0223> voList = todoMapper_0223.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoVO_0223 todoVO = todoMapper_0223.selectOne(32L);
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        todoMapper_0223.delete(63L);
    }

    @Test
    public void testUpdate() {
        TodoVO_0223 todoVO_0223 = TodoVO_0223.builder()
                .tno(1L).title("ㅋㅋㄹㅃㅃ").dueDate(LocalDate.now().plusDays(2L)).writer("졸졸").finished(false).build();
        todoMapper_0223.update(todoVO_0223);
    }
}
