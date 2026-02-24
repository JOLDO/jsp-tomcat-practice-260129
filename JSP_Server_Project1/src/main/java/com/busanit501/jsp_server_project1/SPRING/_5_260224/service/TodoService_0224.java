package com.busanit501.jsp_server_project1.SPRING._5_260224.service;

import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageRequestDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageResponseDTO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.TodoDTO_0224;

import java.util.List;

public interface TodoService_0224 {

    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void register(TodoDTO_0224 todoDTO_0224);

    //전체 목록
    List<TodoDTO_0224> getAll();

    // 하나 조회
    TodoDTO_0224 getOne(Long tno);

    //삭제
    void remove(Long tno);

    //수정
    void modify(TodoDTO_0224 todoDTO_0224);

    //페이지 처리가 된 목록 조회, 부가적으로 페이징 춘비물 재료들도 같이 전달
    PageResponseDTO_0224<TodoDTO_0224> getList(PageRequestDTO_0224 pageRequestDTO_0224);

}
