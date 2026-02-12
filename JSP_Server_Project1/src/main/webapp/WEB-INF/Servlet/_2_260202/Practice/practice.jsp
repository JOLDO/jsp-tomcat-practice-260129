<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 2. 2.
  Time: 오후 4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${practice.count}</h1>
    <h1>${practice.title}</h1>
    <h1>${practice.dueDate}</h1>
    <h1>${practice.isFinish}</h1>
    <br>
    <ol>
        <c:forEach var ="dto" items="${practiceList}">
            <li>
                ${dto}
            </li>
        </c:forEach>
    </ol>
</body>
</html>
