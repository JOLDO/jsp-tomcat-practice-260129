package com.busanit501.jsp_server_project1._7_260209._0209_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class _0209_MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
