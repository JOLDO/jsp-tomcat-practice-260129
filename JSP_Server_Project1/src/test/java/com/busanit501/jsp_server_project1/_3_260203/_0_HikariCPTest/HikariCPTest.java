package com.busanit501.jsp_server_project1._3_260203._0_HikariCPTest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HikariCPTest {
    @Test
    public void testHikariCP() throws Exception {
        //HikariConfig 클래스 이용해서 옵션 설정
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        ////////////////////////////////////
        //PreparedStatement 캐시 설정
        //데이터베이스에서 사용하는 sql문장을 반복적으로 사용하는 것을 캐시(저장해서) 사용
        //- **개념**: PreparedStatement 캐싱 기능을 활성화하는 기본 옵션입니다.
        config.addDataSourceProperty("cachePrepStmts", "true");
        //- **개념**: 각 연결(Connection)당 캐시할 수 있는 PreparedStatement의 최대 개수입니다.
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        //- **개념**: 캐시할 수 있는 SQL 문의 최대 길이(문자 수)입니다.
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ////////////////////////////////////

        //HikariDataSource 클래스에 위의 설정 클래스를 담아주기
        HikariDataSource ds = new HikariDataSource(config);
        // 연결 커넥션이용해서 확인하기.
        Connection connection = ds.getConnection();

        // 해당 connection 있는지 여부 확인.
        System.out.println(connection);

        connection.close();
    }
}
