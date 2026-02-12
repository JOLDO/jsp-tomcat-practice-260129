<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 30.
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL를 c로 사용 implementation를 먼저 해줘야 함--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>read 임시화면입니다.</h1>
    <h3>dto 라는 객체에서 정보를 하나씩 꺼내기</h3>
    <p>_0204_TodoDTO 모델 클래스의 멤버를 getter로 가져옴</p>
    <div>
        ${dto.tno}
    </div>
    <div>
        ${dto.title}
    </div>
    <div>
        ${dto.dueDate}
    </div>
    <div>
        ${dto.finished}
    </div>
</body>
</html>
