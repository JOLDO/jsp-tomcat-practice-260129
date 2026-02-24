package com.busanit501.jsp_server_project1.SPRING._5_260224.service;

import com.busanit501.jsp_server_project1.SPRING._5_260224.domain.TodoVO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageRequestDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageResponseDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.TodoDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.mapper.TodoMapper_0224;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl_0224 implements TodoService_0224 {

    //서비스는 직접적으로 DB에 insert 기능이 없고 DAO를 사용함
    //1)TodoMapper 2)ModelMapper: DTO <-> VO
    //다른 객체를 가져와 연결
    //1)AutoWired 2)Lombok을 이용한 생성자 주입
    private final TodoMapper_0224 todoMapper_0224;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO_0224 todoDTO_0224) {
        log.info("서비스 작업: insert기능 작업 시작");
        TodoVO_0224 todoVO_0224 = modelMapper.map(todoDTO_0224, TodoVO_0224.class);
        log.info("서비스 작업: insert기능 변환된 todoVO_0224 : " + todoVO_0224);
        todoMapper_0224.insert(todoVO_0224);
    }

    @Override
    public List<TodoDTO_0224> getAll() {
        // todoMapper.selectAll() : DB로 부터 전달받은 정보를 TodoVO 타입을 요소로 가지는 리스트로 받기.
        // .stream() : 병렬처리, 중간 작업, 최종 작업,
        // 중간 작업 : .map(vo -> modelMapper.map(vo, TodoDTO.class)) , 리스트에서 요소를 하나 꺼내서, VO -> DTO 타입로 변환
        // 최종 작업 : 변환된 DTO를 리스트화 시키기.
        // 최종은 :  List<TodoDTO> dtoList, 변환된 요소들이 리스트로 반환되었다.
        List<TodoDTO_0224> dtoList = todoMapper_0224.selectAll().stream()
            .map(vo -> modelMapper.map(vo, TodoDTO_0224.class))
            .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO_0224 getOne(Long tno) {
        TodoVO_0224 todoVO = todoMapper_0224.selectOne(tno);
        TodoDTO_0224 todoDTO = modelMapper.map(todoVO, TodoDTO_0224.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper_0224.delete(tno);
    }

    @Override
    public void modify(TodoDTO_0224 todoDTO_0224) {
        TodoVO_0224 todoVO = modelMapper.map(todoDTO_0224, TodoVO_0224.class);
        todoMapper_0224.update(todoVO);
    }

    @Override
    public PageResponseDTO_0224<TodoDTO_0224> getList(PageRequestDTO_0224 pageRequestDTO_0224) {
        //반화해야할 내용물 : PageResponseDTO_0224을 만들기 위한 준비물
        //1)PageRequestDTO_0224 pageRequestDTO_0224 : 화면으로부터 전달받음
        //2)List<E> dtoList
        List<TodoVO_0224> voList = todoMapper_0224.selectList(pageRequestDTO_0224);
        List<TodoDTO_0224> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO_0224.class))
                .collect(Collectors.toList());

        //3)int total
        int total = todoMapper_0224.getCount(pageRequestDTO_0224);

        //반환 타입 : PageResponseDTO_0224 -> 객체 생성 : 생성자 호출
        PageResponseDTO_0224<TodoDTO_0224> pageResponseDTO_0224 = PageResponseDTO_0224.<TodoDTO_0224>withAll()
            .dtoList(dtoList)
            .total(total)
            .pageRequestDTO_0224(pageRequestDTO_0224)
            .build();

        return pageResponseDTO_0224;
    }


}
