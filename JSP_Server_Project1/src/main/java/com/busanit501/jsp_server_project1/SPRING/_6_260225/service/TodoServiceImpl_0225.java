package com.busanit501.jsp_server_project1.SPRING._6_260225.service;

import com.busanit501.jsp_server_project1.SPRING._6_260225.domain.TodoVO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.PageRequestDTO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.PageResponseDTO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.TodoDTO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.mapper.TodoMapper_0225;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl_0225 implements TodoService_0225 {

    //서비스는 직접적으로 DB에 insert 기능이 없고 DAO를 사용함
    //1)TodoMapper 2)ModelMapper: DTO <-> VO
    //다른 객체를 가져와 연결
    //1)AutoWired 2)Lombok을 이용한 생성자 주입
    private final TodoMapper_0225 todoMapper_0225;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO_0225 todoDTO_0225) {
        log.info("서비스 작업: insert기능 작업 시작");
        TodoVO_0225 todoVO_0225 = modelMapper.map(todoDTO_0225, TodoVO_0225.class);
        log.info("서비스 작업: insert기능 변환된 todoVO_0225 : " + todoVO_0225);
        todoMapper_0225.insert(todoVO_0225);
    }

    @Override
    public List<TodoDTO_0225> getAll() {
        // todoMapper.selectAll() : DB로 부터 전달받은 정보를 TodoVO 타입을 요소로 가지는 리스트로 받기.
        // .stream() : 병렬처리, 중간 작업, 최종 작업,
        // 중간 작업 : .map(vo -> modelMapper.map(vo, TodoDTO.class)) , 리스트에서 요소를 하나 꺼내서, VO -> DTO 타입로 변환
        // 최종 작업 : 변환된 DTO를 리스트화 시키기.
        // 최종은 :  List<TodoDTO> dtoList, 변환된 요소들이 리스트로 반환되었다.
        List<TodoDTO_0225> dtoList = todoMapper_0225.selectAll().stream()
            .map(vo -> modelMapper.map(vo, TodoDTO_0225.class))
            .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO_0225 getOne(Long tno) {
        TodoVO_0225 todoVO = todoMapper_0225.selectOne(tno);
        TodoDTO_0225 todoDTO = modelMapper.map(todoVO, TodoDTO_0225.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper_0225.delete(tno);
    }

    @Override
    public void modify(TodoDTO_0225 todoDTO_0225) {
        TodoVO_0225 todoVO = modelMapper.map(todoDTO_0225, TodoVO_0225.class);
        todoMapper_0225.update(todoVO);
    }

    @Override
    public PageResponseDTO_0225<TodoDTO_0225> getList(PageRequestDTO_0225 pageRequestDTO_0225) {
        //반화해야할 내용물 : PageResponseDTO_0225을 만들기 위한 준비물
        //1)PageRequestDTO_0225 pageRequestDTO_0225 : 화면으로부터 전달받음
        //2)List<E> dtoList
        List<TodoVO_0225> voList = todoMapper_0225.selectList(pageRequestDTO_0225);
        List<TodoDTO_0225> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO_0225.class))
                .collect(Collectors.toList());

        //3)int total
        int total = todoMapper_0225.getCount(pageRequestDTO_0225);

        //반환 타입 : PageResponseDTO_0225 -> 객체 생성 : 생성자 호출
        PageResponseDTO_0225<TodoDTO_0225> pageResponseDTO_0225 = PageResponseDTO_0225.<TodoDTO_0225>withAll()
            .dtoList(dtoList)
            .total(total)
            .pageRequestDTO_0225(pageRequestDTO_0225)
            .build();

        return pageResponseDTO_0225;
    }


}
