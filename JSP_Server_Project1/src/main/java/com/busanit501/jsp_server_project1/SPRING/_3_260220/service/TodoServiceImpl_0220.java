package com.busanit501.jsp_server_project1.SPRING._3_260220.service;

import com.busanit501.jsp_server_project1.SPRING._3_260220.domain.TodoVO_0220;
import com.busanit501.jsp_server_project1.SPRING._3_260220.dto.TodoDTO_0220;
import com.busanit501.jsp_server_project1.SPRING._3_260220.mapper.TodoMapper_0220;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl_0220 implements TodoService_0220 {

    //서비스는 직접적으로 DB에 insert 기능이 없고 DAO를 사용함
    //1)TodoMapper 2)ModelMapper: DTO <-> VO
    //다른 객체를 가져와 연결
    //1)AutoWired 2)Lombok을 이용한 생성자 주입
    private final TodoMapper_0220 todoMapper_0220;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO_0220 todoDTO_0220) {
        log.info("서비스 작업: insert기능 작업 시작");
        TodoVO_0220 todoVO_0220 = modelMapper.map(todoDTO_0220, TodoVO_0220.class);
        log.info("서비스 작업: insert기능 변환된 todoVO_0220 : " + todoVO_0220);
        todoMapper_0220.insert(todoVO_0220);
    }

    @Override
    public List<TodoDTO_0220> getAll() {
        List<TodoDTO_0220> dtoList = todoMapper_0220.selectAll().stream()
            .map(vo -> modelMapper.map(vo, TodoDTO_0220.class))
            .collect(Collectors.toList());
        return dtoList;
    }
}
