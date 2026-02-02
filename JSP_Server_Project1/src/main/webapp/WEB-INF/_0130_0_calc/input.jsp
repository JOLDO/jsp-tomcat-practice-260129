<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 29.
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>
</head>
<body>
  <h1>get 방식 입력 조회 연습</h1>
  <%--  웹브라우저에서 서버로 전달하는 방법을 get(데이터 공개, 데이터 길이 제한있음)--%>
  <form action="calcResult.jsp">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">전송</button>
  </form>

  <h1>post 방식 입력 조회 연습</h1>
  <%--  웹브라우저에서 서버로 전달하는 방법을 post로 변경(데이터 공개 없고, 데이터 길이도 상관없음)--%>
  <form action="/calc/makeResult" method="post">  <%-- action에 목적지를 적어준다. --%>
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">전송</button>
  </form>
</body>
</html>
