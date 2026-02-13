<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 2. 13.
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>ex4</h1>
    <h1>서버에서 model 객체를 이용해서 화면에 데이터 전달하고</h1>
    <h1>화면에서는 전달받은 데이터를 사용</h1>
    <h2>EL표기법으로 간단히 표현 : ${msg}</h2>
    <h2>EL표기법으로 간단히 표현 : ${msg2}</h2>
    <h2>EL의 위험한 점은 예전에 eval()처럼 알람창이 뜰수 있음</h2>
    <h2>JSTL 표현식으로 안전하게 출력</h2>
    <h2>JSTL은 문자열로 바꾸기 떼문에 그냥 문자열로 적힘</h2>
    <h2>
        <c:out value="${msg}"/>
    </h2>
    <h2>
        <c:out value="${msg2}"/>
    </h2>
</body>
</html>
