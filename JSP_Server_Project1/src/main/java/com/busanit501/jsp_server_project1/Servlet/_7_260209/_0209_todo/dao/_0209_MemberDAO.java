package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dao;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.domain._0209_MemberVO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.util._0209_ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _0209_MemberDAO {
    //ID와 PW를 이용해서 해당 유저를 조회하는 기능
    public _0209_MemberVO getWithPassword(String mid, String mpw) throws Exception {
        //SQL 문장 선언
        String sql = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";

        //DB데이터를 담을 객체 생성
        _0209_MemberVO memberVO = null;

        //DB 서버 연결
        @Cleanup Connection connection = _0209_ConnectionUtil.INSTANCE.getConnection();

        //SQL 당기
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //mid, mpw를 와일드카드 ?에 값 넣기
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);

        //DB 정보 임시보관
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        //받아온 DB정보를 객체에 담기
        if(resultSet.next()) {
            memberVO = _0209_MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();
        }

        return memberVO;
    }

    //임시로 생성된 uuid를 업데이트하는 기능
    public void updateUuid(String mid, String uuid) throws Exception {
        //SQL 문장 선언
        String sql = "update tbl_member set uuid = ? where mid = ?";

        //DB 서버 연결
        @Cleanup Connection connection = _0209_ConnectionUtil.INSTANCE.getConnection();

        //SQL 당기
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //mid, mpw를 와일드카드 ?에 값 넣기
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, mid);

        //DB 정보 임시보관
        int updateCount = preparedStatement.executeUpdate();
    }

    //uuid로 유저 조회 기능 추가
    public _0209_MemberVO selectUUID(String uuid) throws Exception {
        //SQL 문장 선언
        String sql = "select  mid, mpw, mname, uuid from tbl_member where uuid = ?";

        //DB 서버 연결
        @Cleanup Connection connection = _0209_ConnectionUtil.INSTANCE.getConnection();

        //SQL 당기
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //mid, mpw를 와일드카드 ?에 값 넣기
        preparedStatement.setString(1, uuid);
        _0209_MemberVO memberVO = null;

        //DB 정보 임시보관
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            memberVO = _0209_MemberVO.builder()
                .mid(resultSet.getString(1))
                .mpw(resultSet.getString(2))
                .mname(resultSet.getString(3))
                .uuid(resultSet.getString(4))
                .build();
        }
        return memberVO;
    }
}
