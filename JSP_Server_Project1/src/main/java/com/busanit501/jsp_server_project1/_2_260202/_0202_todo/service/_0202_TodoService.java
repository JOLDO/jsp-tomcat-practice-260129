package com.busanit501.jsp_server_project1._2_260202._0202_todo.service;



import com.busanit501.jsp_server_project1._2_260202._0202_todo.dto._0202_TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum _0202_TodoService {
    INSTANCE;   //static final이 생략되어있음

    //글쓰기
    public void register(_0202_TodoDTO a0202TodoDTO) {
        System.out.println("서비스 기능, 글쓰기 기능, " +
                "사용자가 일정을 입력하면, todoDTO 라는 객체에 담겨서, 전달을 받습니다." +
                "꺼내서 사용하면됩니다. 뼈대만 구성.");
        System.out.println("todoDTO : " + a0202TodoDTO);
    }

    //목록조회
    public List<_0202_TodoDTO> getList() {
        //10개의 샘플 등록
        List<_0202_TodoDTO> a0202TodoDTOS = IntStream.range(0, 10).mapToObj(i -> { //숫자가 0~9만큼 10개가 들어감
            _0202_TodoDTO dto = new _0202_TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());
            return dto; //intstream은 int인데 반환을 dto로 하기 위해 maptoobj로 함
        }).collect(Collectors.toList());    // mapToObj 닫기 태그, 반복문으로 각각의 todo 객체를 생성해서, 리스트로 만들기.
        return a0202TodoDTOS;
    }
}
