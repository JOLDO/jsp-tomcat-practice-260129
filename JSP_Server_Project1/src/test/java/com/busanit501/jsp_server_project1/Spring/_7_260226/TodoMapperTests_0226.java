package com.busanit501.jsp_server_project1.Spring._7_260226;

import com.busanit501.jsp_server_project1.SPRING._7_260226.domain.TodoVO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageRequestDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.mapper.TodoMapper_0226;
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
public class TodoMapperTests_0226 {
    @Autowired(required = false)
    //해당 객체를 활성화를 못하더라도 예외 발생 없이 null로 할당
    private TodoMapper_0226 todoMapper_0226;

    @Test
    public void testGetTime() {
        log.info("출력 - 시간 확인으로 마이바티스 임시 연결 확인 : " + todoMapper_0226.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO_0226 todoVO_0226 = TodoVO_0226.builder()
            .title("뭐!!")
            .dueDate(LocalDate.now())
            .finished(false)
            .writer("오태흔")
            .build();
        todoMapper_0226.insert(todoVO_0226);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO_0226> voList = todoMapper_0226.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        // 각자 데이터베이스에 있는 tno 번호 확인 후 , 테스트 진행하기.
        TodoVO_0226 todoVO = todoMapper_0226.selectOne(32L);
        log.info(todoVO);
    }

    @Test
    public void testDelete() {
        todoMapper_0226.delete(63L);
    }

    @Test
    public void testUpdate() {
        TodoVO_0226 todoVO_0226 = TodoVO_0226.builder()
            .tno(1L).title("ㅋㅋㄹㅃㅃ")
            .dueDate(LocalDate.now().plusDays(2L))
            .writer("졸졸")
            .finished(false)
            .build();
        todoMapper_0226.update(todoVO_0226);
    }

    //페이징 처리가 된 목록 조회
    @Test
    public void testSelectList() {
        PageRequestDTO_0226 pageRequestDTO_0226 = PageRequestDTO_0226.builder()
            .page(1)
            .size(10)
            .build();
        List<TodoVO_0226> voList = todoMapper_0226.selectList(pageRequestDTO_0226);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectListCount() {
        PageRequestDTO_0226 pageRequestDTO_0226 = PageRequestDTO_0226.builder()
                .page(1)
                .size(10)
                .build();
        int resultCount = todoMapper_0226.getCount(pageRequestDTO_0226);
        log.info("전체 갯수 : " + resultCount);
    }

    //타입에 따른 검색 연습
    @Test
    public void testSelectSearch() {
        //검색시 준비물
        //1)검색어, 2)타입
        PageRequestDTO_0226 pageRequestDTO_0226 = PageRequestDTO_0226.builder()
            .page(1)
            .size(10)
            .pageSize(10)
            .types(new String[]{"t", "w"})
            .keyword("A")
            .finished(true)
            .from(LocalDate.of(2026, 02, 01))
            .to(LocalDate.of(2026, 02, 28))
            .build();

        List<TodoVO_0226> voList = todoMapper_0226.selectList(pageRequestDTO_0226);
        voList.forEach(vo -> log.info(vo));

        //전체 갯수
        log.info(todoMapper_0226.getCount(pageRequestDTO_0226));
    }
}
