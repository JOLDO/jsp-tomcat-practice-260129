package com.busanit501.jsp_server_project1.SPRING._5_260224.mapper;

import com.busanit501.jsp_server_project1.SPRING._5_260224.domain.TodoVO_0224;
import com.busanit501.jsp_server_project1.SPRING._5_260224.dto.PageRequestDTO_0224;

import java.util.List;

public interface TodoMapper_0224 {
    String getTime();

    //CRUD - C
    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void insert(TodoVO_0224 todoVO_0224);

    //전체 목록 조회
    List<TodoVO_0224> selectAll();

    // 하나 조회
    TodoVO_0224 selectOne(Long tno);

    //삭제
    void delete(Long tno);

    //수정
    void update(TodoVO_0224 todoVO);

    //페이지네이션 처리가 된 목록 조회
    List<TodoVO_0224> selectList(PageRequestDTO_0224 pageRequestDTO_0224);

    //전체 갯수 구하기
    int getCount(PageRequestDTO_0224 pageRequestDTO_0224);
}
