package com.busanit501.jsp_server_project1.SPRING._7_260226.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정을 담당하는 클래스라고, 스프링(시스템)에 전달
@Configuration
public class ModelMapperConfig_0226 {
    // 일반 클래스 객체를  스프링(시스템)에 전달
    @Bean   //ModelMapper는 외부 라이브러리라서 어노테이션으로 정의하지 못하기때문에 Bean객체로 만들어서 autowired로 호출 가능하도록 함
    //autowired는 싱글톤(하나의 객체로 돌려쓰는거)으로 된 객체를 쓸때 사용
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
        // dto <-> vo 클래스의 멤버의 일치 여부를 체크함.
        .setFieldMatchingEnabled(true)
        // 접근은 private 까지 가능하게
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        // 매칭시, 검사시, 엄격하게 검사함.
        .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
    //이렇게 쓰는 이유는 외부라이브러리를 등록해놓고 쓰고 싶은데 외부 라이브러리라 클래스코드를 내가 가지고 있지 않아서
    //@Configuration이라는 어노테이션으로 클래스를 만들고 외부라이브러리의 객체를 bean으로 등록하기 위해서이다.
    //다른 @Component인 @Service같은 부분에서 써도 객체를 하나만 생성해서 써도 되지만 그러면 나중에 다른곳에서도 써야 될수도 있는 라이브러리라면
    //bean으로 등록해놓는게 마음편함. 그래서 프로그램에서 하나만 있어야 하거나, 설정이 필요한 거나, 상태가 없는거(암호화, 타입변환)
    //이런거는 내가 만들었던, 외부라이브러리이던 그냥 @Configuration @Bean으로 등록해서 쓰는게 맘편함
}
