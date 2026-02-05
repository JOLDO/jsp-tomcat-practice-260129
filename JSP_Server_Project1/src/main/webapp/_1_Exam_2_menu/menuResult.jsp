<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 29.
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--임시로 한글 안깨지게 설정--%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<head>
    <title>menuResult</title>
</head>
<body>
    <h1>a ${param.a_count}개, b ${param.b_count}개, c ${param.c_count}개</h1>
    <h1>${
    3000 * Integer.parseInt(param.a_count) +
    3200 * Integer.parseInt(param.b_count) +
    4400 * Integer.parseInt(param.c_count)}원</h1>
    <h1>주문 내역</h1>
    <h2>주문 메뉴 : ${param.menuName}</h2>
    <h2>가격 : 10000원</h2>
</body>
</html>
