package com.busanit501.jsp_server_project1.Spring._0_260212.sample;

import com.busanit501.jsp_server_project1.SPRING._0_260212.sample.SampleService_0212;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2 //로그를 기록하는 로그레벨 기준에따라 로그를 기록
@ExtendWith(SpringExtension.class)  //Junit5 단위 테스트 기능 통합 설정   스프링기능(@Autowired)추가 해서 테스트할때 사용
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")  //스프링 기능을 테스트하기 위해 스프링의 bean설정된 파일을 지정해줌
//빈을 등록한 파일의 위치를 지정, 단위 테스트 할때, 해당파일을 참고해서 테스트해줘
public class SampleTests_0212 {

    @Autowired  //의존성 주입(자동으로 해당 객체(Bean)를 연결)
    //(root-context.xml, 객체 등록했고, 서버시작시 활성화(객체로는 생성자 호출)
    private SampleService_0212 sampleService_0212;

    //데이터베이스 연결 캑체는 서버시작시 활성화가 됨, 그래서 연결만 하면 됨
    @Autowired
    private DataSource dataSource;  //느슨한 결합

    @Test
    public void testService1() {
        log.info("실제 객체가 활성화 되었는지 여부를 객체가 조회해보기" + sampleService_0212);
        Assertions.assertNotNull(sampleService_0212);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("testConnection : " + connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }
}
