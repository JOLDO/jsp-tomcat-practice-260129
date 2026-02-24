package com.busanit501.jsp_server_project1.SPRING._5_260224.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO_0224 {
    //준비물
    //1)페이지 번호
    @Builder.Default    //기본값을 1로 지정
    @Min(value = 1) //유효성(최소값)
    @Positive   //유효성(양수)
    private int page = 1;

    //2)페이지 당 보여줄 갯수
    @Builder.Default    //기본값을 1로 지정
    @Min(value = 1) //유효성(최소값)
    @Max(value = 100)   //유효성(최대값)  //get으로 준 쿼리스트링을 조작해서 유효성이 없다면 10000으로 바꿀수 있음
    @Positive   //유효성(양수)
    private int size = 10;

    //보여줄 페이지 수
    @Builder.Default
    @Min(value = 5)
    @Max(value = 10)
    private int pageSize = 10;

    //3)몇개를 skip할지
    public int getSkip() {
        return (page - 1) * size;
    }

    //page 1당 size 마큼의 데이터 수를 보여줄려는데 page1에 limit 0(page - 1) 10(size), page2에 limit 10(page - 1) 10(size) 이런식이라
    //select한 후 limit (스킵할 수) (가져올 수)를 할때
    //(page - 1) * size로 스킵할 수를 구할수 있음
}
