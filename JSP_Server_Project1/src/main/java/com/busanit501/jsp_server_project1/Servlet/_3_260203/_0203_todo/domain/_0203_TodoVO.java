package com.busanit501.jsp_server_project1.Servlet._3_260203._0203_todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
//@Builder는
/*
_0203_TodoVO todo = _0203_TodoVO.builder()
    .tno(0L)
    .title("타이틀")
    .dueDate(LocalDate.now())
    .finished(false)
    .build();
*/
//이렇게 사용할수 있게 해주는데 이건 여러 생성자를 따로 만들필요 없고, 가독성과 순서를 마음대로, 원하는 것만 넣을수 있는 유연성이 있어서 좋음
@Getter     //getter 생성하는 것과 같은 효과(메모리 상에 만들어짐)
@Setter
@ToString   //toString을 생성하는 것과 같은 효과(메모리 상에 만들어짐)
public class _0203_TodoVO {
    //엔티티클래스 : 데이터베이스에 영향을 주는 클래스(데이터들)
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
