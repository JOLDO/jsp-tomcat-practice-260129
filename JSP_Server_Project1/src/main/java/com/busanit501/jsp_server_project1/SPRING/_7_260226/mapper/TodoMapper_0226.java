package com.busanit501.jsp_server_project1.SPRING._7_260226.mapper;

import com.busanit501.jsp_server_project1.SPRING._7_260226.domain.TodoVO_0226;
import com.busanit501.jsp_server_project1.SPRING._7_260226.dto.PageRequestDTO_0226;

import java.util.List;

public interface TodoMapper_0226 {
    String getTime();

    //CRUD - C
    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void insert(TodoVO_0226 todoVO_0226);

    //전체 목록 조회
    List<TodoVO_0226> selectAll();

    // 하나 조회
    TodoVO_0226 selectOne(Long tno);

    //삭제
    void delete(Long tno);

    //수정
    void update(TodoVO_0226 todoVO);

    //페이지네이션 처리가 된 목록 조회
    List<TodoVO_0226> selectList(PageRequestDTO_0226 pageRequestDTO_0226);

    //전체 갯수 구하기
    int getCount(PageRequestDTO_0226 pageRequestDTO_0226);
}
