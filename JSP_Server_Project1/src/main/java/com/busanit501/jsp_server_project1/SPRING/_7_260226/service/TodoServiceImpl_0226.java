package com.busanit501.jsp_server_project1.SPRING._7_260226.service;

import com.busanit501.jsp_server_project1.SPRING._7_260226.domain.TodoVO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageRequestDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageResponseDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.TodoDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.mapper.TodoMapper_0226;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl_0226 implements TodoService_0226 {

    //서비스는 직접적으로 DB에 insert 기능이 없고 DAO를 사용함
    //1)TodoMapper 2)ModelMapper: DTO <-> VO
    //다른 객체를 가져와 연결
    //1)AutoWired 2)Lombok을 이용한 생성자 주입
    private final TodoMapper_0226 todoMapper_0226;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO_0226 todoDTO_0226) {
        log.info("서비스 작업: insert기능 작업 시작");
        TodoVO_0226 todoVO_0226 = modelMapper.map(todoDTO_0226, TodoVO_0226.class);
        log.info("서비스 작업: insert기능 변환된 todoVO_0226 : " + todoVO_0226);
        todoMapper_0226.insert(todoVO_0226);
    }

    @Override
    public List<TodoDTO_0226> getAll() {
        // todoMapper.selectAll() : DB로 부터 전달받은 정보를 TodoVO 타입을 요소로 가지는 리스트로 받기.
        // .stream() : 병렬처리, 중간 작업, 최종 작업,
        // 중간 작업 : .map(vo -> modelMapper.map(vo, TodoDTO.class)) , 리스트에서 요소를 하나 꺼내서, VO -> DTO 타입로 변환
        // 최종 작업 : 변환된 DTO를 리스트화 시키기.
        // 최종은 :  List<TodoDTO> dtoList, 변환된 요소들이 리스트로 반환되었다.
        List<TodoDTO_0226> dtoList = todoMapper_0226.selectAll().stream()
            .map(vo -> modelMapper.map(vo, TodoDTO_0226.class))
            .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO_0226 getOne(Long tno) {
        TodoVO_0226 todoVO = todoMapper_0226.selectOne(tno);
        TodoDTO_0226 todoDTO = modelMapper.map(todoVO, TodoDTO_0226.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper_0226.delete(tno);
    }

    @Override
    public void modify(TodoDTO_0226 todoDTO_0226) {
        TodoVO_0226 todoVO = modelMapper.map(todoDTO_0226, TodoVO_0226.class);
        todoMapper_0226.update(todoVO);
    }

    @Override
    public PageResponseDTO_0226<TodoDTO_0226> getList(PageRequestDTO_0226 pageRequestDTO_0226) {
        //반화해야할 내용물 : PageResponseDTO_0226을 만들기 위한 준비물
        //1)PageRequestDTO_0226 pageRequestDTO_0226 : 화면으로부터 전달받음
        //2)List<E> dtoList
        List<TodoVO_0226> voList = todoMapper_0226.selectList(pageRequestDTO_0226);
        List<TodoDTO_0226> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO_0226.class))
                .collect(Collectors.toList());

        //3)int total
        int total = todoMapper_0226.getCount(pageRequestDTO_0226);

        //반환 타입 : PageResponseDTO_0226 -> 객체 생성 : 생성자 호출
        PageResponseDTO_0226<TodoDTO_0226> pageResponseDTO_0226 = PageResponseDTO_0226.<TodoDTO_0226>withAll()
            .dtoList(dtoList)
            .total(total)
            .pageRequestDTO_0226(pageRequestDTO_0226)
            .build();

        return pageResponseDTO_0226;
    }


}
