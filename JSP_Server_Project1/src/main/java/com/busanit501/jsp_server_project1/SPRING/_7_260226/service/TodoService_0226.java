package com.busanit501.jsp_server_project1.SPRING._7_260226.service;

import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageRequestDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageResponseDTO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.TodoDTO_0226;

import java.util.List;

public interface TodoService_0226 {

    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void register(TodoDTO_0226 todoDTO_0226);

    //전체 목록
    List<TodoDTO_0226> getAll();

    // 하나 조회
    TodoDTO_0226 getOne(Long tno);

    //삭제
    void remove(Long tno);

    //수정
    void modify(TodoDTO_0226 todoDTO_0226);

    //페이지 처리가 된 목록 조회, 부가적으로 페이징 춘비물 재료들도 같이 전달
    PageResponseDTO_0226<TodoDTO_0226> getList(PageRequestDTO_0226 pageRequestDTO_0226);

}
