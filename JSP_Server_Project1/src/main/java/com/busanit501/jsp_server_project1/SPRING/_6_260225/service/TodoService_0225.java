package com.busanit501.jsp_server_project1.SPRING._6_260225.service;

import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.PageRequestDTO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.PageResponseDTO_0225;
import com.busanit501.jsp_server_project1.SPRING._6_260225.dto.TodoDTO_0225;

import java.util.List;

public interface TodoService_0225 {

    //화면에서 입력된 정보를 받기 -> DTO 담기 -> VO 변환 -> DB에 전달
    void register(TodoDTO_0225 todoDTO_0225);

    //전체 목록
    List<TodoDTO_0225> getAll();

    // 하나 조회
    TodoDTO_0225 getOne(Long tno);

    //삭제
    void remove(Long tno);

    //수정
    void modify(TodoDTO_0225 todoDTO_0225);

    //페이지 처리가 된 목록 조회, 부가적으로 페이징 춘비물 재료들도 같이 전달
    PageResponseDTO_0225<TodoDTO_0225> getList(PageRequestDTO_0225 pageRequestDTO_0225);

}
