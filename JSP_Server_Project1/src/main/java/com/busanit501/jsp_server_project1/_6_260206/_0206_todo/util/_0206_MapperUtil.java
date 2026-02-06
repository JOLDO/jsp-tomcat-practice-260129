package com.busanit501.jsp_server_project1._6_260206._0206_todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum _0206_MapperUtil {
    INSTANCE;

    //외부 기능(ModelMapper) 선언
    private ModelMapper modelMapper;

    //기본 생성자
    _0206_MapperUtil() {
        //ModelMapper 초기화
        modelMapper = new ModelMapper();

        //ModelMapper 초기(기본) 설정 후 재사용
        this.modelMapper.getConfiguration()
                //dto와 vo의 멤버의 일치여부 체크(원래는 getter/setter의 메서드 이름으로 매칭 하는데 true로 하면 변수이름만으로도 매칭가능)
                .setFieldMatchingEnabled(true)
                //접근은 private까지 가능하게 설정(접근 지정자 종류 어떤거까지 ModelMapper가 접근할수 있는지 지정)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                //매칭시, 검사시 엄격하게 설정(dto와 entity(vo)의 변수이름의 같음 정도를 설정 strict는 완전히 같아야 함)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //외부에서 ModelMapper를 가져다 사용할수 있게할 함수

    public ModelMapper get() {
        return modelMapper;
    }
}
