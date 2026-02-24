package com.busanit501.jsp_server_project1.SPRING._5_260224.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

//1)페이지네이션 용도
//2)검색, 필터 용도
//현재 Todo만 사용하지만, 추후엔 다른 도메인도 활용할 예정
//<E>로 제네릭을 쓰는 이유는 여러가지 dto를 받아올수 있게 하려고
@Getter
@ToString
public class PageResponseDTO_0224<E> {
    private int page;
    private int size;
    private int pageSize;
    private int total;

    //시작 페이지번호
    private int start;
    //끝 페이지번호
    private int end;
    //이전 페이지 존재여부
    private boolean prev;
    //다음 페이지 존재여부
    private boolean next;

    //페이지 처리가 된 목록  <E>는 dto타입
    private List<E> dtoList;

    //해당 클래스 객체를 활성화 해줄 생성자를 빌더패턴으로 미리 등록
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO_0224(PageRequestDTO_0224 pageRequestDTO_0224, List<E> dtoList, int total) {
        this.page = pageRequestDTO_0224.getPage();
        this.size = pageRequestDTO_0224.getSize();
        this.pageSize = pageRequestDTO_0224.getPageSize();
        this.total = total;
        this.dtoList = dtoList;

        //start, end, total, last, prev, next의 활성화 및 수식조건
        //end는 10개의 size로 한다고 칠때
        this.end = (int)(Math.ceil(this.page / (double)this.pageSize)) * pageSize;
        this.start = this.end - this.pageSize + 1;
        int last = (int)(Math.ceil(total / (double)size));  //마지막 페이지 숫자
        this.end = end > last ? last : end; //보여지는 끝 페이지 숫자(20) > 마지막 페이지 숫자(21) ? 21 : 20
        this.prev = this.start > 1; //보여지는 시작 페이지가 1다 크면 이전으로가기 가능
//        this.next = total > this.end * this.size;
        this.next = this.end < last;    //다음으로가기가 보여지는 끝페이지가 마지막 페이지보다 작으면 가능
    }
}
