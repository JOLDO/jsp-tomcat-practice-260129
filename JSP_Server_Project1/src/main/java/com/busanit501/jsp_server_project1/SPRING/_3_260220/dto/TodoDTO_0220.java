package com.busanit501.jsp_server_project1.SPRING._3_260220.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO_0220 {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}
