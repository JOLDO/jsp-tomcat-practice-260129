package com.busanit501.jsp_server_project1._2_260202._0_DB_Connect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTest {

    @Test
    public void test1() {
        //테스트 할땐 테스트 어노테이션 붙여야 함
        //확인 하려면 줄 번호 있는곳 오른쪽에 재생 혹은 체크, 엑스를 누르고 재생(실행)하면 됨
        int v1 = 10;
        int v2 = 10;

        //Assertion은 테스트 할때 해당 값이 되는지 확인
        Assertions.assertEquals(v1,v2); //같아야만 한다는 명령어
    }

    @Test
    public void testConnection() throws Exception {
        // 1 드라이버 연결.
        Class.forName("org.mariadb.jdbc.Driver");

        // 2 연결 커넥션 객체 도구 이용.
        // 접근 하는 디비 서버 1) 주소 2) 계정 3) 패스워드
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );

        // 3. 연결 도구의 객체가 유효한지, 체크
        Assertions.assertNotNull(connection);

        // 4. 확인 후, 자원 반납
        connection.close();
    }
}
