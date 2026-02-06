package com.busanit501.jsp_server_project1._5_260205._0205_todo.service;

import com.busanit501.jsp_server_project1._5_260205._0205_todo.dao._0205_TodoDAO;
import com.busanit501.jsp_server_project1._5_260205._0205_todo.domain._0205_TodoVO;
import com.busanit501.jsp_server_project1._5_260205._0205_todo.dto._0205_TodoDTO;
import com.busanit501.jsp_server_project1._5_260205._0205_todo.util._0205_MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

//log4j2 외부 라이브러리 사용 main -> resources -> log4j2.xml을 만들어서 설정내용 적고 log.info(메세지)로 사용
@Log4j2
public enum _0205_TodoService {
    INSTANCE;   //static final이 생략되어있음
    //DB서버에 작업을 시키는 클래스
    private _0205_TodoDAO dao;

    //dto <-> vo 변환 클래스
    private ModelMapper modelMapper;

    //생성자로 dao와 modelMapper를 초기화
    _0205_TodoService() {
        dao = new _0205_TodoDAO();
        modelMapper = _0205_MapperUtil.INSTANCE.get();
    }

    //등록 기능 구현
    public void register(_0205_TodoDTO _0205_todoDTO) throws Exception {
        //dto -> vo 변환
        _0205_TodoVO todoVO = modelMapper.map(_0205_todoDTO, _0205_TodoVO.class);

        //변환 확인
        log.info("_0205_TodoService에서 register 작업중, 변환 결과 확인 todoVO : " + todoVO);
        //dao로 DB에 쓰기 작업
        dao.insert(todoVO);
    }

    //전체 목록조회 수정
    public List<_0205_TodoDTO> listAll() throws Exception {
        //_0204_TodoVO형태로 데이터를 받아옴(dao.selectAll()의 리턴 타입이 _0204_TodoVO)
        List<_0205_TodoVO> voList = dao.selectAll();
        log.info("voList 확인 : " + voList);

        //vo -> dto 변환
        List<_0205_TodoDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, _0205_TodoDTO.class))
            .collect(Collectors.toList());

        //dto형태로 반환
        return dtoList;
    }

    //Todo 조회
    //화면에서 무엇을 조회할지 알고 있는 상황(tno를 알고 있는 상황)
    public _0205_TodoDTO get(Long tno) throws Exception {
        //DB로부터 전달받아서 사용
        _0205_TodoVO todoVO = dao.selectOne(tno);

        //vo -> dto 변환
        _0205_TodoDTO todoDTO = modelMapper.map(todoVO, _0205_TodoDTO.class);

        return todoDTO;
    }

    //수정하기
    public void modify(_0205_TodoDTO todoDTO) throws Exception {
        log.info("todoDTO : " + todoDTO);

        //dto -> vo 변환
        _0205_TodoVO todoVO = modelMapper.map(todoDTO, _0205_TodoVO.class);

        //dao룰 이용해서 DB 데이터 업데이트
        dao.updateOne(todoVO);
    }

    //삭제하기
    public void remove(Long tno) throws Exception {
        log.info("삭제할 tno : " + tno);

        //dao룰 이용해서 DB 데이터 삭제
        dao.deleteOne(tno);
    }
}
