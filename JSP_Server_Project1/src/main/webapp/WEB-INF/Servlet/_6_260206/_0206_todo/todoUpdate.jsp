<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 30.
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>update 임시화면입니다.</h1>
    <a href="/todo/list_0206">목록가기</a>
    <h3>dto 라는 객체에서 정보를 하나씩 꺼내기</h3>
    <p>_0205_TodoDTO 모델 클래스의 멤버를 getter로 가져옴</p>
    <p>수정 화면으로 수정된 내용으로 다시 DB서버를 수정 </p>
    <form id="form1" action="/todo/update_0206" method="post">
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly>
        </div>
        <div>
            <input type="text" name="title" value="${dto.title}">
        </div>
        <div>
            <input type="date" name="dueDate" value="${dto.dueDate}">
        </div>
        <div>
            <input type="checkbox" name="finished" ${dto.finished  ? "checked" : ""}>
        </div>
        <div>
            <button type="submit">수정</button>
        </div>
    </form>

    <form id="form2" action="/todo/delete_0206" method="post">
<%--        삭제할 tno번호를 같이 전달(숨겨서)--%>
        <input type="hidden" name="tno" value="${dto.tno}" readonly>
        <div>
            <button type="submit">삭제</button>
        </div>
    </form>
</body>
</html>
