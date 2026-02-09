package com.busanit501.jsp_server_project1._7_260209._0_MemberDAOTests;

import com.busanit501.jsp_server_project1._7_260209._0209_todo.dao._0209_MemberDAO;
import com.busanit501.jsp_server_project1._7_260209._0209_todo.domain._0209_MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class _0_MemberDAOTests {
    private _0209_MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
        memberDAO = new _0209_MemberDAO();
    }

    @Test
    public void testGetOneUser() throws Exception {
        String mid = "aa";
        String mpw = "aa";

        _0209_MemberVO memberVO = memberDAO.getWithPassword(mid, mpw);
        log.info("임시 로그인, 유저 조회 결과 : " + memberVO);
    }

    @Test
    public void testGetOneUserWithUUID() throws Exception {
        String uuid = "f3982507-66d2-4cd2-80e5-e5f206a82376";

        _0209_MemberVO memberVO = memberDAO.selectUUID(uuid);
        log.info("UUID 이용해서 조회, 임시 로그인, 유저 조회 결과2 : " + memberVO);
    }
}
