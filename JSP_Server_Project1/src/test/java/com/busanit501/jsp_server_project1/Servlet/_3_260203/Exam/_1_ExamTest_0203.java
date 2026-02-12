package com.busanit501.jsp_server_project1.Servlet._3_260203.Exam;

import com.busanit501.jsp_server_project1.Servlet._3_260203._0203_todo.Exam.dao.Exam_1_MenuDAO_0203;
import com.busanit501.jsp_server_project1.Servlet._3_260203._0203_todo.Exam.domain.Exam_1_MenuVO_0203;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

public class _1_ExamTest_0203 {
    private Exam_1_MenuDAO_0203 dao;

    @BeforeEach
    public void ready() {
        dao = new Exam_1_MenuDAO_0203();
    }
    @Test
    public void testGetTime() throws SQLException {
        System.out.println(dao.getTime());
    }

    @Test
    public void testGetTime2() throws Exception {
        System.out.println(dao.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        Exam_1_MenuVO_0203 vo = Exam_1_MenuVO_0203.builder()
                .title("실습 테스트")
                .dueDate(LocalDate.of(2026, 1, 10))
                .build();
        dao.insert(vo);
    }

    @Test
    public void testSelectAll() throws Exception {
        dao.selectAll().forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        long tno = 12L;
        System.out.println(dao.selectOne(tno));
    }

    @Test
    public void testUpdateOne() throws Exception {
        Exam_1_MenuVO_0203 vo = Exam_1_MenuVO_0203.builder()
            .tno(12L)
            .title("실습 테스트 수정")
            .dueDate(LocalDate.of(2026, 1, 10))
            .finished(true)
            .build();

        dao.updateOne(vo);
    }

    @Test
    public void testDeleteOne() throws Exception {
        long tno = 12L;
        dao.deleteOne(tno);
    }
}
