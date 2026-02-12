<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 30.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>register 임시화면입니다.</h1>
    <div>
        <a href="/todo/list_0209">목록가기</a>
    </div>
    <form action="/todo/register_0209" method="post">
        <div>
            <input type="text" name="title" placeholder="todo 제목을 입력해주세요.">
        </div>
        <div>
            <input type="date" name="dueDate">
        </div>
        <button type="reset">초기화</button>
        <button type="submit">등록처리</button>
    </form>
</body>
</html>
