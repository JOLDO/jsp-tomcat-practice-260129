package com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   //@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor(꼭 필요한 필드(final이나 notnull이어야 하는 변수)만 골라서 생성자 생성)(Spring의 의존성 주입에서 중요하다함)
@Builder    //builder모델 사용
@NoArgsConstructor  //기본 생성자 생성, 일부 라이브러리에서 기본 생성자가 필요하기 때문에 사용
@AllArgsConstructor //모든 멤버를 매개변수로 가지는 생성자 생성, @NoArgsConstructor를 사용하면 @Builder에서 필요한 전체 맨버 생성자가 없어지므로 강제적으로 생성하기 위해
//@Builder, @NoArgsConstructor, @AllArgsConstructor이거는 세트로 사용하는게 좋음
public class _0204_TodoDTO {
    //dto클래스 : 클래스끼리 데이터 전달용 클래스
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
