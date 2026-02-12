package com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.service;

import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.dao._0204_TodoDAO;
import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.domain._0204_TodoVO;
import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.dto._0204_TodoDTO;
import com.busanit501.jsp_server_project1.Servlet._4_260204._0204_todo.util._0204_MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//log4j2 외부 라이브러리 사용 main -> resources -> log4j2.xml을 만들어서 설정내용 적고 log.info(메세지)로 사용
@Log4j2
public enum _0204_TodoService {
    INSTANCE;   //static final이 생략되어있음
    //DB서버에 작업을 시키는 클래스
    private _0204_TodoDAO dao;

    //dto <-> vo 변환 클래스
    private ModelMapper modelMapper;

    //생성자로 dao와 modelMapper를 초기화
    _0204_TodoService() {
        dao = new _0204_TodoDAO();
        modelMapper = _0204_MapperUtil.INSTANCE.get();
    }

    //등록 기능 구현
    public void register(_0204_TodoDTO _0204_todoDTO) throws Exception {
        //dto -> vo 변환
        _0204_TodoVO todoVO = modelMapper.map(_0204_todoDTO, _0204_TodoVO.class);

        //변환 확인
        log.info("_0204_TodoService에서 register 작업중, 변환 결과 확인 todoVO : " + todoVO);
        //dao로 DB에 쓰기 작업
        dao.insert(todoVO);
    }

    //전체 목록조회 수정
    public List<_0204_TodoDTO> listAll() throws Exception {
        //_0204_TodoVO형태로 데이터를 받아옴(dao.selectAll()의 리턴 타입이 _0204_TodoVO)
        List<_0204_TodoVO> voList = dao.selectAll();
        log.info("voList 확인 : " + voList);

        //vo -> dto 변환
        List<_0204_TodoDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo, _0204_TodoDTO.class))
            .collect(Collectors.toList());

        //dto형태로 반환
        return dtoList;
    }

    //등록


    //Todo 조회
    public _0204_TodoDTO get(Long tno) {
        //반환할 임시 객체 생성
        _0204_TodoDTO dto = new _0204_TodoDTO();
        //전달 받은 tno 번호로 임시 번호설정
        dto.setTno(tno);
        //임시 제목
        dto.setTitle("샘플 Todo 더미 데이터1");
        //임시 날짜
        dto.setDueDate(LocalDate.now());
        //임시 완료여부
        dto.setFinished(true);

        return dto;
    }
}
