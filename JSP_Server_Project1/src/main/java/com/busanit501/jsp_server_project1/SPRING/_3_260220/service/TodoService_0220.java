package com.busanit501.jsp_server_project1.SPRING._3_260220.service;

import com.busanit501.jsp_server_project1.SPRING._3_260220.dto.TodoDTO_0220;

import java.util.List;

public interface TodoService_0220 {

    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void register(TodoDTO_0220 todoDTO_0220);

    //전체 목록
    List<TodoDTO_0220> getAll();
}
