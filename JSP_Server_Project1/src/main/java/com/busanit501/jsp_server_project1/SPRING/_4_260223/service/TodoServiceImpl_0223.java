package com.busanit501.jsp_server_project1.SPRING._4_260223.service;

import com.busanit501.jsp_server_project1.SPRING._4_260223.domain.TodoVO_0223;
import com.busanit501.jsp_server_project1.SPRING._4_260223.dto.TodoDTO_0223;
import com.busanit501.jsp_server_project1.SPRING._4_260223.mapper.TodoMapper_0223;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl_0223 implements TodoService_0223 {

    //서비스는 직접적으로 DB에 insert 기능이 없고 DAO를 사용함
    //1)TodoMapper 2)ModelMapper: DTO <-> VO
    //다른 객체를 가져와 연결
    //1)AutoWired 2)Lombok을 이용한 생성자 주입
    private final TodoMapper_0223 todoMapper_0223;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO_0223 todoDTO_0223) {
        log.info("서비스 작업: insert기능 작업 시작");
        TodoVO_0223 todoVO_0223 = modelMapper.map(todoDTO_0223, TodoVO_0223.class);
        log.info("서비스 작업: insert기능 변환된 todoVO_0223 : " + todoVO_0223);
        todoMapper_0223.insert(todoVO_0223);
    }

    @Override
    public List<TodoDTO_0223> getAll() {
        // todoMapper.selectAll() : DB로 부터 전달받은 정보를 TodoVO 타입을 요소로 가지는 리스트로 받기.
        // .stream() : 병렬처리, 중간 작업, 최종 작업,
        // 중간 작업 : .map(vo -> modelMapper.map(vo, TodoDTO.class)) , 리스트에서 요소를 하나 꺼내서, VO -> DTO 타입로 변환
        // 최종 작업 : 변환된 DTO를 리스트화 시키기.
        // 최종은 :  List<TodoDTO> dtoList, 변환된 요소들이 리스트로 반환되었다.
        List<TodoDTO_0223> dtoList = todoMapper_0223.selectAll().stream()
            .map(vo -> modelMapper.map(vo, TodoDTO_0223.class))
            .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO_0223 getOne(Long tno) {
        TodoVO_0223 todoVO = todoMapper_0223.selectOne(tno);
        TodoDTO_0223 todoDTO = modelMapper.map(todoVO, TodoDTO_0223.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper_0223.delete(tno);
    }

    @Override
    public void modify(TodoDTO_0223 todoDTO_0223) {
        TodoVO_0223 vo = modelMapper.map(todoDTO_0223, TodoVO_0223.class);
        todoMapper_0223.update(vo);
    }
}
