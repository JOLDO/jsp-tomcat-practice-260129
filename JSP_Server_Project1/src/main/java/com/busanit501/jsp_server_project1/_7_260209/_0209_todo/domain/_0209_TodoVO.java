package com.busanit501.jsp_server_project1._7_260209._0209_todo.domain;

import lombok.*;

import java.time.LocalDate;

@Builder
//@Builder는
/*
_0206_TodoVO todo = _0206_TodoVO.builder()
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
@NoArgsConstructor  //기본 생성자 생성
@AllArgsConstructor //모든 멤버를 매개변수로 가지는 생성자 생성
public class _0209_TodoVO {
    //엔티티클래스 : 데이터베이스에 영향을 주는 클래스(데이터들)
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
