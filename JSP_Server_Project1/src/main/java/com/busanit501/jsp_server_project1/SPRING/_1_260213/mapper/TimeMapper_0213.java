package com.busanit501.jsp_server_project1.SPRING._1_260213.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper_0213 {
    @Select("select now()")
    String getTime();
}
