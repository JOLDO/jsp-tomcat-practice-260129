package com.busanit501.jsp_server_project1.SPRING._6_260225.mapper;

import com.busanit501.jsp_server_project1.SPRING._6_260225.domain.TodoVO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.PageRequestDTO_0225;

import java.util.List;

public interface TodoMapper_0225 {
    String getTime();

    //CRUD - C
    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void insert(TodoVO_0225 todoVO_0225);

    //전체 목록 조회
    List<TodoVO_0225> selectAll();

    // 하나 조회
    TodoVO_0225 selectOne(Long tno);

    //삭제
    void delete(Long tno);

    //수정
    void update(TodoVO_0225 todoVO);

    //페이지네이션 처리가 된 목록 조회
    List<TodoVO_0225> selectList(PageRequestDTO_0225 pageRequestDTO_0225);

    //전체 갯수 구하기
    int getCount(PageRequestDTO_0225 pageRequestDTO_0225);
}
