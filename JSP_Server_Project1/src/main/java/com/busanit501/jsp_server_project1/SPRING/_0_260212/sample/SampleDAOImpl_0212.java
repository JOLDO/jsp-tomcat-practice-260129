package com.busanit501.jsp_server_project1.SPRING._0_260212.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("normal")    //이거는 java폴더 바로 아래에 lombok.config파일을 만들고 어노테이션을 넣고 사용할수 있음
public class SampleDAOImpl_0212 implements SampleDAO_0212{

}
