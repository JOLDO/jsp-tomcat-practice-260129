package com.busanit501.jsp_server_project1.Servlet._3_260203._1_MariaDBTest;

import com.busanit501.jsp_server_project1.Servlet._3_260203._0203_todo.dao._0203_TodoDAO;
import com.busanit501.jsp_server_project1.Servlet._3_260203._0203_todo.domain._0203_TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

//단위 테스트
public class MariaDBTest {
    //1)DB서버에 연결해서, 시간을 가져오는 기능을 가지고 있는 클래스 이용하기
    //주입
    private _0203_TodoDAO todoDAO;

    //2)테스트 할땐 항상 todoDAO 객체가 필요해서 각 메서들가 실행되기 전에 미리 생성하는 코드
    @BeforeEach
    public void ready() {
        //각각의 단위테스트가 메서드가 실행되기전에 생성자 호출해서 객체를 인스턴스화 한다(객체 생성한다.).
        todoDAO = new _0203_TodoDAO();
    }

    //3)실제 테스트
    @Test
    public void testTime() throws Exception {
        System.out.println("현재 시간 : " + todoDAO.getTime2());
//        todoDAO.getTimePrac();
//        todoDAO.getTimePrac1();
    }

    //등록하기
    @Test
    public void testInsert() throws Exception {
        //화면에서 전달받은 데이터를 임시 데이터로 전달
        //객체 생성은 _0203_TodoVO는 @Builder어노테이션이 있어서 builder 패턴을 쓴다.
        _0203_TodoVO vo = _0203_TodoVO.builder()
            .title("샘플제목22")
            .dueDate(LocalDate.now())
            .build();
        todoDAO.insert(vo);
    }

    //목록 전체 조회
    @Test
    public void testSelectAll() throws Exception {
        List<_0203_TodoVO> list = todoDAO.selectAll();
        //System.out.println(vo)는 _0203_TodoVO의 @ToString 어노테이션이 있기 때문에 원하는 toString 생성한 것과 같이 나옴
        list.forEach(vo -> System.out.println(vo));
    }

    //한개만 조회(조회할 tno번호)
    @Test
    public void testSelectOne() throws Exception {
        //조회할 tno번호
        Long tno = 4L;
        _0203_TodoVO vo = todoDAO.selectOne(tno);
        System.out.println("하나 조회 결과 : " + vo);
    }

    //수정하기
    @Test
    public void testUpdateOne() throws Exception {
        _0203_TodoVO todoVO = _0203_TodoVO.builder()
            .tno(4L)
            .title("수정 테스트")
            .dueDate(LocalDate.of(2026, 2, 2))
            .finished(true)
            .build();
        todoDAO.updateOne(todoVO);
    }

    //삭제하기
    @Test
    public void testDeleteOne() throws Exception {
        Long tno = 4L;
        todoDAO.deleteOne(tno);
    }
}
