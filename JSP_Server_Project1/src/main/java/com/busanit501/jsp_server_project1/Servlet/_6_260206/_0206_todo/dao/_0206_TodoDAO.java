package com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.dao;

import com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.domain._0206_TodoVO;
import com.busanit501.jsp_server_project1.Servlet._6_260206._0206_todo.util._0206_ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class _0206_TodoDAO {
    //dao 클래스 : 데이터베이스 연결 기능을 모아둔 클래스

    //DB서버에 연결해서 현재 시간 조회하는 쿼리 전달 -> 현재 시간을 받아오기
    public String getTime() {
        //현재 시간을 받아올 임시 변수
        String now = null;
        //try resource with : 자동으로 객체 닫기(.close())
        try(
                Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection(); //DB서버에 연결하는 오구(DB서버 주소, 계정정보, 나머지 캐시옵션이 설정정된 객체)
                PreparedStatement preparedStatement = connection.prepareStatement("select now()");  //현재 시간을 조회하는 쿼리
                ResultSet resultSet = preparedStatement.executeQuery(); //DB서버에 쿼리 전달 후 결과를 받아옴
                //select의 경우 excuteQuery()를 사용하고, ResultSet으로 반환됨
                //(insert, update, delete)는 excuteUpdate()를 사용하고, int로 반환되고 각각 추가된 행의 수, 업데이트된 행의 수, 지워진 행의 수를 나타냄
                //Connection, PreparedStatement, ResultSet은 닫아줘야함, ResultSet은 실행 후에 나오기때문에 try(ResultSet resultSet) {}으로 내부에 중첩해서 사용하기도 함
        ) {
            //resultSet에 담겨진 시간 조회
            resultSet.next();   //처음 받아온 resultSet에서 커서가 before first(첫째줄 이전)에 위치해서 next()로 첫째줄로 이동해줌, 이유는 데이터가 없을수도 있기 때문에 데이터가 없을때 .next()가 false가 나올수 있게
            //while(resultSet.next())로 여러줄을 받을수도 있다.
            now = resultSet.getString(1);   //여기서 1은 컬럼의 순번(1부터 시작), 권장되는 방식은 숫자 대신 "컬럼명"을 권장함
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    //try catch 대신에 어노테이션(@Cleanup) 사용
    public String getTime2() throws Exception {
        //@Cleanup을 지역변수에 사용하면 사용후 함수가 끝나면 .close()해줌
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String now = resultSet.getString(1);
        return now;
    }

    //등록하기
    //_0203_TodoVO vo 객체는 화면에서 입력한 내용을 담고 있음
    //화면상에는 제목만 입력할 예정(수동), tno번호(자동), 완료여부(수동), 날짜(수동)
    public void insert(_0206_TodoVO vo) throws Exception {
        //sql문 작성
        String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ?, ?)";

        //DB서버에 연결하는 도구 설정
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();

        //sql문장을 담아두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());

        //sql문장을 DB 서버에 전달
        preparedStatement.executeUpdate();
    }

    //목록 기능 구현
    public List<_0206_TodoVO> selectAll() throws Exception {
        //sql문 작성
        String sql = "select * from tbl_todo order by tno desc";

        //DB서버에 연결하는 도구 설정
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();

        //sql문장을 담아두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //sql문장을 DB 서버에 전달 후 데이터 받아와서 담아두기(ResultSet은 가상테이블)
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        //임시로 담아둘 리스트 선언
        List<_0206_TodoVO> list = new ArrayList<>();

        //반목문으로 데이터베이스 내용을 리스트의 요소 객체에 각각 담기
        //resultSet은 0행부터 준비하고 데이터가 있으면 다음행으로 넘어감
        while (resultSet.next()) {
            //_0203_TodoVO는 @Builder 어노테이션이 붙어 있어서 builder 패턴으로 객체 생성
            _0206_TodoVO vo = _0206_TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

            //데이터베이스의 내용 -> 객체로 변경한 요소를 리스트에 담기
            list.add(vo);
        }
        return list;
    }

    //한개만 조회(조회할 tno번호)
    //조회할 todo를 클릭을 하면 클릭한 todo의 tno 번호를 화면으로 부터 전달 받음
    public _0206_TodoVO selectOne(Long tno) throws Exception {
        //sql문 작성
        String sql = "select * from tbl_todo where tno = ?";

        //DB서버에 연결하는 도구 설정
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();

        //sql문장을 담아두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);

        //sql문장을 DB 서버에 전달 후 데이터 받아와서 담아두기(ResultSet은 가상테이블)
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        //데이터베이스로 받아온 내용을 하나의 객체로 변환하는 작업
        if(resultSet.next()) {
            _0206_TodoVO vo = _0206_TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

            return vo;
        }
        return null;
    }

    //수정하기
    //수정할 내용을 담을 데이터를 받아왔다고 가정
    //나중엔, 화면에서 수정할 내용을 받아오면 그 데이터를 _0203_TodoVO todoVo에 담음
    //_0203_TodoVO todoVo에서 변경할 내용을 꺼내서 데이터 베이스를 수정
    public void updateOne(_0206_TodoVO todoVo) throws Exception {
        //sql문 작성
        String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";

        //DB서버에 연결하는 도구 설정
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();

        //sql문장을 담아두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todoVo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVo.getDueDate()));
        preparedStatement.setBoolean(3, todoVo.isFinished());
        preparedStatement.setLong(4, todoVo.getTno());

        //sql문장을 DB 서버에 전달
        preparedStatement.executeUpdate();
    }

    //삭제하기
    //삭제할 tno번호를 알고있음
    public void deleteOne(Long tno) throws Exception {
        //tno 4번 삭제
        //sql문 작성
        String sql = "delete from tbl_todo where tno = ?";

        //DB서버에 연결하는 도구 설정
        @Cleanup Connection connection = _0206_ConnectionUtil.INSTANCE.getConnection();

        //sql문장을 담아두는 기능
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);

        //sql문장을 DB 서버에 전달
        preparedStatement.executeUpdate();
    }
}
