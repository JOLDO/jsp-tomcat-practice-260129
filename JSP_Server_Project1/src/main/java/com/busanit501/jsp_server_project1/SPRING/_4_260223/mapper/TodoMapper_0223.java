package com.busanit501.jsp_server_project1.SPRING._4_260223.mapper;

import com.busanit501.jsp_server_project1.SPRING._4_260223.domain.TodoVO_0223;

import java.util.List;

public interface TodoMapper_0223 {
    String getTime();

    //CRUD - C
    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void insert(TodoVO_0223 todoVO_0223);

    //전체 목록 조회
    List<TodoVO_0223> selectAll();

    // 하나 조회
    TodoVO_0223 selectOne(Long tno);

    //삭제
    void delete(Long tno);

    void update(TodoVO_0223 vo);
}
