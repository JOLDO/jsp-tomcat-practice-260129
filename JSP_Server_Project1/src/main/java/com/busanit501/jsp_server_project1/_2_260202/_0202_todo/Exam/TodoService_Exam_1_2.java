package com.busanit501.jsp_server_project1._2_260202._0202_todo.Exam;

import com.busanit501.jsp_server_project1._2_260202._0202_todo.dto._0202_TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService_Exam_1_2 {
    INSTANCE;

    public List<TodoDTO_Exam_1_2> getList() {
        List<TodoDTO_Exam_1_2> dtoList = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO_Exam_1_2 dto = new TodoDTO_Exam_1_2();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now().plusDays((long)i));
            if(i % 2 != 0) {
                dto.setFinished(true);
            } else {
                dto.setFinished(false);
            }
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    public TodoDTO_Exam_1_2 get(Long tno) {
        TodoDTO_Exam_1_2 dto = new TodoDTO_Exam_1_2();
        dto.setTno(tno);
        dto.setTitle("실습 Todo 더미 데이터1");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}
