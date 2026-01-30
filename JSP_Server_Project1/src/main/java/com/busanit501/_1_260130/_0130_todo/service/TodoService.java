package com.busanit501._1_260130._0130_todo.service;

import com.busanit501._1_260130._0130_todo.dto.TodoDTO;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;   //static final이 생략되어있음

    //글쓰기
    public void register(TodoDTO todoDTO) {
        System.out.println("서비스 기능, 글쓰기 기능, " +
                "사용자가 일정을 입력하면, todoDTO 라는 객체에 담겨서, 전달을 받습니다." +
                "꺼내서 사용하면됩니다. 뼈대만 구성.");
        System.out.println("todoDTO : " + todoDTO);
    }

    //목록조회
    public List<TodoDTO> getList() {
        //10개의 샘플 등록
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i -> { //숫자가 0~9만큼 10개가 들어감
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());
            return dto; //intstream은 int인데 반환을 dto로 하기 위해 maptoobj로 함
        }).collect(Collectors.toList());    // mapToObj 닫기 태그, 반복문으로 각각의 todo 객체를 생성해서, 리스트로 만들기.
        return todoDTOS;
    }
}
