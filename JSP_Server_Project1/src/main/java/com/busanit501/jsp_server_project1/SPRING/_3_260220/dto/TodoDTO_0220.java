package com.busanit501.jsp_server_project1.SPRING._3_260220.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO_0220 {
    private Long tno;
    @NotBlank
    private String title;
    @Future
    private LocalDate dueDate;
    private boolean finished;
    @NotBlank
    private String writer;
}
