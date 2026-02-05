package com.busanit501.jsp_server_project1._4_260204._0_TodoServiceTest;

import com.busanit501.jsp_server_project1._4_260204._0204_todo.dto._0204_TodoDTO;
import com.busanit501.jsp_server_project1._4_260204._0204_todo.service._0204_TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class _0_TodoServiceTest {

    //서비스 클래스 선언
    private _0204_TodoService todoService;

    @BeforeEach
    public void ready() {
        //서비스 클래스(enum클래스) 초기화
        todoService = _0204_TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        //서비스의 기능을 dao와 연동해서 사용
        //화면에서 데이터 받음 -> dto에 데이터 담음 -> 서비스에 전달해 기능(dto를 vo로 변환 후 dao의 기능 사용) 사용 -> db에 데이터 적용
        _0204_TodoDTO todoDto = _0204_TodoDTO.builder()
            .title("샘플 제목, 오늘 점심 뭐 먹지?")
            .dueDate(LocalDate.now())
            .finished(true)
            .build();

        log.info("로그 라이브러리 log4j2 테스트");
        log.info(todoDto);
        todoService.register(todoDto);
    }

    @Test
    public void testGetList() throws Exception {

    }
}
