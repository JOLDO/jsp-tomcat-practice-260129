package com.busanit501.jsp_server_project1._3_260203._0203_todo.Exam.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class Exam_1_MenuVO_0203 {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
