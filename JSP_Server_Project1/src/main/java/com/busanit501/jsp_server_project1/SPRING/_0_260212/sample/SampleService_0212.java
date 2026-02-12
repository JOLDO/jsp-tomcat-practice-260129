package com.busanit501.jsp_server_project1.SPRING._0_260212.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service    //시스템에 등록해서 서버를 시작하면 해당 클래스를 Service객체로 미리 등록해서 사용(Ioc: inversion of control)
@ToString
@RequiredArgsConstructor    //final이 붙은 것들(필수값)을 생성자의 매개변수로 만들어줌
public class SampleService_0212 {
    private final SampleDAO_0212 sampleDAO_0212;    //이후 실행시 Spring의 bean으로 관리 되고 있는지 확인 후 있으면 되고 없으면 에러가 나옴)
    //final은 처음 생성후 바로 값을 넣거나, 생성자의 매게변수로 넣을때 값을 넣는것이 가능하다.
}
