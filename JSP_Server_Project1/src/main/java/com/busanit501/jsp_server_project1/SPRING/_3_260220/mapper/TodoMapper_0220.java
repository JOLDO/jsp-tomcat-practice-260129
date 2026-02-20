package com.busanit501.jsp_server_project1.SPRING._3_260220.mapper;

import com.busanit501.jsp_server_project1.SPRING._3_260220.domain.TodoVO_0220;

import java.util.List;

public interface TodoMapper_0220 {
    String getTime();

    //CRUD - C
    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void insert(TodoVO_0220 todoVO_0220);

    //전체 목록 조회
    List<TodoVO_0220> selectAll();
}
