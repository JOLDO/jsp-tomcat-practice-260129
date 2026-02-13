package com.busanit501.jsp_server_project1.SPRING._1_260213.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
//@Primary    //interface를 2개의 클래스에 주입하면 시스템상 알수 없으므로 주로 사용하는 클래스를 선택
@Qualifier("event")
public class EventSampleDAOImpl_0213 implements SampleDAO_0213 {

}
