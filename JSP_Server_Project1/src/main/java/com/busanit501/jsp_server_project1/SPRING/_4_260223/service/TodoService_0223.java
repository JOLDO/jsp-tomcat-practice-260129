package com.busanit501.jsp_server_project1.SPRING._4_260223.service;

import com.busanit501.jsp_server_project1.SPRING._4_260223.dto.TodoDTO_0223;

import java.util.List;

public interface TodoService_0223 {

    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void register(TodoDTO_0223 todoDTO_0223);

    //전체 목록
    List<TodoDTO_0223> getAll();

    // 하나 조회
    TodoDTO_0223 getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO_0223 todoDTO_0223);
}
