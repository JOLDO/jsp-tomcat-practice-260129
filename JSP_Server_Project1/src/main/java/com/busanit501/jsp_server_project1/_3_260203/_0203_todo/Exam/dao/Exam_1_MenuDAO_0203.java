package com.busanit501.jsp_server_project1._3_260203._0203_todo.Exam.dao;

import com.busanit501.jsp_server_project1._3_260203._0203_todo.Exam.domain.Exam_1_MenuVO_0203;
import com.busanit501.jsp_server_project1._3_260203._0203_todo.domain._0203_TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Exam_1_MenuDAO_0203 {
    /*
    실습
    참고 파일.
    패키지(폴더) :_0203_todo

    1.
    _0203_1_TodoVO
    파일명 : MenuVO
    내용물 동일
    lombok 라이브러리 설치
    롬복을 이용해서, 각각의 @Getter , @ToString, @Builder
    이용하기

    2.
    _0203_3_ConnectionUtil
    재사용 : ConnectionUtil
    Hikari 라이브러리 설치, 설정 및 적용 가능한지

    3.
    _0203_4_TodoDAO
    파일명 : MenuDAO, 변경,
    내용물 거의 동일.
            클래스안에서,
    자바 -> 데이터베이스로, 명령어를 전달해서,
    데이터베이스의 내용을 crud 확인이 가능한지. 확인.

    4.
    위의 구조로 변경후,
    단위 테스트 하기.
    src -> test -> java ->
    패키지 : dao
    클래스명() : MenuDAOTests

    새로운 프로젝트 생성해서, 연습.
    */

    public String getTime() throws SQLException {
        try(
            Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTime2() throws Exception {
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return null;
        }
    }

    public void insert(Exam_1_MenuVO_0203 vo) throws Exception{
        String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ?, ?)";
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());
        int insertCount = preparedStatement.executeUpdate();
        if(insertCount > 0) {
            System.out.println("추가 성공" + insertCount);
        } else {
            System.out.println("추가 실패" + insertCount);
        }
    }

    public List<Exam_1_MenuVO_0203> selectAll() throws Exception {
        String sql = "select * from tbl_todo";
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<Exam_1_MenuVO_0203> voList = new ArrayList<>();
        while(resultSet.next()) {
            Exam_1_MenuVO_0203 vo = Exam_1_MenuVO_0203.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

            voList.add(vo);
        }
        return voList;
    }

    public Exam_1_MenuVO_0203 selectOne(long tno) throws Exception {
        String sql = "select * from tbl_todo where tno = ?";
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Exam_1_MenuVO_0203 vo = Exam_1_MenuVO_0203.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            return vo;
        } else {
            return null;
        }
    }

    public void updateOne(Exam_1_MenuVO_0203 menuVo) throws Exception {
        String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, menuVo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(menuVo.getDueDate()));
        preparedStatement.setBoolean(3, menuVo.isFinished());
        preparedStatement.setLong(4, menuVo.getTno());
        int updateCount = preparedStatement.executeUpdate();
        if(updateCount > 0) {
            System.out.println("수정 성공" + updateCount);
        } else {
            System.out.println("수정 실패" + updateCount);
        }
    }

    public void deleteOne(Long tno) throws Exception {
        String sql = "delete from tbl_todo where tno = ?";
        @Cleanup Connection connection = Exam_1_ConnectionUtil_0203.EXAM.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        int deleteCount = preparedStatement.executeUpdate();
        if(deleteCount > 0) {
            System.out.println("삭제 성공" + deleteCount);
        } else {
            System.out.println("삭제 실패" + deleteCount);
        }
    }
}
