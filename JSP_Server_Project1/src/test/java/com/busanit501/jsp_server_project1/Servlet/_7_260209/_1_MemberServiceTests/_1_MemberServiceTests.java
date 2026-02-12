package com.busanit501.jsp_server_project1.Servlet._7_260209._1_MemberServiceTests;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_MemberDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service._0209_MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class _1_MemberServiceTests {

    private _0209_MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = _0209_MemberService.INSTANCE;
    }

    @Test
    public void testLogin() throws Exception {
        String mid = "aa";
        String mpw = "aa";
        _0209_MemberDTO memberDTO = memberService.login(mid, mpw);
        log.info("멤버 서비스 로그인 테스트 memberDTO : " + memberDTO);
    }

    @Test
    public void testLogin2() throws Exception {
        String uuid = "f3982507-66d2-4cd2-80e5-e5f206a82376";

        _0209_MemberDTO memberDTO = memberService.getByUUID(uuid);
        log.info("UUID 이용해서 조회, 멤버 서비스 로그인 테스트2 memberDTO : " + memberDTO);
    }
}
