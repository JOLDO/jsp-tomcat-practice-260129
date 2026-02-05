<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 30.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jstl 이란 도구 이용해서, 자바 문법를 간소화해서, 반복문 이용해서, --%>
    <%--html 태그도 같이 이용해서, 하나씩 조회 해보기. --%>
    <div>
        <a href="/todo/register_0205">글쓰기</a>
    </div>
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>
                <span><a href="/todo/read_0205?tno=${dto.tno}">${dto.title}</a></span>
                <span>${dto.tno}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished ? "완료" : "미완료"}</span>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
