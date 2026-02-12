package com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.service;

import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dao._0209_MemberDAO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.domain._0209_MemberVO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.dto._0209_MemberDTO;
import com.busanit501.jsp_server_project1.Servlet._7_260209._0209_todo.util._0209_MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum _0209_MemberService {
    INSTANCE;

    private _0209_MemberDAO dao;
    private ModelMapper modelMapper;

    _0209_MemberService() {
        dao = new _0209_MemberDAO();
        modelMapper = _0209_MapperUtil.INSTANCE.get();
    }

    //로그인 기능 메서드
    public _0209_MemberDTO login(String mid, String mpw) throws Exception {
        _0209_MemberVO vo = dao.getWithPassword(mid, mpw);
        _0209_MemberDTO memberDTO = modelMapper.map(vo, _0209_MemberDTO.class);

        return memberDTO;
    }

    //자동 로그인을 위한 uuid 업데이트 기능
    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

    public _0209_MemberDTO getByUUID(String uuid) throws Exception {
        _0209_MemberVO memberVO = dao.selectUUID(uuid);
        _0209_MemberDTO memberDTO = modelMapper.map(memberVO, _0209_MemberDTO.class);
        return memberDTO;
    }
}
