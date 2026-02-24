package com.busanit501.jsp_server_project1.SPRING._5_260224.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice   //여러 컨트롤러에 걸쳐 범용적으로 적용되는 기능을 모아놓는 클래스
@Log4j2
public class CommonExceptionAdvice_0224 {

    //해결책1
    //예외를 정확히 알면 해당 예외의 담당클래스를 호출해서 처리.
    // 현재는 문자열 데이터로 그대로 전송 하지만,
    // 나중에, JSON 중간 데이터 타입 형태로 전달 할 예정
    @ResponseBody   //리턴값 자체를 Http응답 바디(화면)에 직접 그린다.(innerHtml식으로)
    @ExceptionHandler(NumberFormatException.class)  //해당 예외클래스를 다룸
    public String exceptNumber(NumberFormatException numberFormatException) {
        log.error("================숫자 및 문자열 타입 불일치 예외처리 테스트=======================");
        log.error(numberFormatException.getMessage());
        return "Number Format Exception Test!!";
    }

    // 해결책2
    // 예상치 못한 예외가 발생해서  예외처리를 지정해서 사용하지 못하는 경우
    // 해결책1보다 범위를 넓혀서 일반적으로 처리. Exception-좀더 범위가 큰 클래스를 이용.
    @ResponseBody   //리턴값 자체를 Http응답 바디(화면)에 직접 그린다.(innerHtml식으로)
    @ExceptionHandler(Exception.class)  //Exception이 NumberFormatException보다 큰 범위라서 먼저 반응해서 해결책1과 2를 동시에 사용하면 해결책2가 호출된다.
    public  String exceptCommon(Exception exception) {
        log.error("===============어떤 예외가 발생할지 모르니, 범위가 큰 예외로 처리함. 예외처리 테스트=======================");
        log.error(exception.getMessage());

        // 데이터 전달하기 : 앞에서는 문자열을 그대로 전달.
        // 이번에는 , 문자열 -> html 포맷 형태로 전달.
        // 스트링버퍼라는 문자열 클래스를 이용해서, 여기에 html 태그를 첨부해서, 전달.
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + exception.getMessage() + "</li>");
        // 여기 내용으로 추가로, 트레이스, 추적, 왜 예외가 발생했는지? 어디서 부터 발생했는지의 내용? 같이 추가해보기.
        // 병렬 처리, 1) 전체 예외를 가지고 오고 2) 버퍼 문자열에 하나씩 추가하고,  3) ul 태그를 닫아서, 전달.
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");
        String result = buffer.toString(); // 전체 예외의 발생한 추적 결과가 담겨져 있음.
        return result;
    }

    //해결책3, 404 not found 페이지 예외처리
    ///WEB-INF/Spring/views/custom404.jsp
    //@ControllerAdvice때문에 리턴하는 값이 string이면 화면을 의미함
    //not found(404)(java예외가 아니라 url자체가 없는거라서)만 init-param으로 설정해줘야 되고, 나머지(400, 500...)는 Exception으로 잡아낼수 있음
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "_5_260224/custom404";
    }

}
