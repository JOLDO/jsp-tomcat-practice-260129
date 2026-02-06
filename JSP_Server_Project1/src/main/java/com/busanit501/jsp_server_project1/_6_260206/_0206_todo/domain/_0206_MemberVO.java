package com.busanit501.jsp_server_project1._6_260206._0206_todo.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class _0206_MemberVO {
    //vo는 보통 setter를 따로 함수로 만들기 때문에 @Setter 어노테이션을 사용하지 않을때가 많다.
    //데이터베이스의 컬럼명과 동일
    private String mid;
    private String mpw;
    private String mname;
}
