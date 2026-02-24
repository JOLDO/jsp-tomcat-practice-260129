package com.busanit501.jsp_server_project1.Spring._5_260224;

import com.busanit501.jsp_server_project1.SPRING._5_260224.domain.TodoVO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageRequestDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.mapper.TodoMapper_0224;
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
public class TodoMapperTests_0224 {
    @Autowired(required = false)
    //해당 객체를 활성화를 못하더라도 예외 발생 없이 null로 할당
    private TodoMapper_0224 todoMapper_0224;

    @Test
    public void testGetTime() {
        log.info("출력 - 시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper_0224.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO_0224 todoVO_0224 = TodoVO_0224.builder()
            .title("뭐!!")
            .dueDate(LocalDate.now())
            .finished(false)
            .writer("오태흔")
            .build();
        todoMapper_0224.insert(todoVO_0224);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO_0224> voList = todoMapper_0224.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoVO_0224 todoVO = todoMapper_0224.selectOne(32L);
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        todoMapper_0224.delete(63L);
    }

    @Test
    public void testUpdate() {
        TodoVO_0224 todoVO_0224 = TodoVO_0224.builder()
            .tno(1L).title("ㅋㅋㄹㅃㅃ")
            .dueDate(LocalDate.now().plusDays(2L))
            .writer("졸졸")
            .finished(false)
            .build();
        todoMapper_0224.update(todoVO_0224);
    }

    //페이징 처리가 된 목록 조회
    @Test
    public void testSelectList() {
        PageRequestDTO_0224 pageRequestDTO_0224 = PageRequestDTO_0224.builder()
            .page(1)
            .size(10)
            .build();
        List<TodoVO_0224> voList = todoMapper_0224.selectList(pageRequestDTO_0224);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectListCount() {
        PageRequestDTO_0224 pageRequestDTO_0224 = PageRequestDTO_0224.builder()
                .page(1)
                .size(10)
                .build();
        int resultCount = todoMapper_0224.getCount(pageRequestDTO_0224);
        log.info("전체 갯수 : " + resultCount);
    }
}
