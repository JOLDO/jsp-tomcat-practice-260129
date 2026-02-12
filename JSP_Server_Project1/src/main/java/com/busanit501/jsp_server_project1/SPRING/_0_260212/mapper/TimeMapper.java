package com.busanit501.jsp_server_project1.SPRING._0_260212.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("select now()")
    String getTime();
}
