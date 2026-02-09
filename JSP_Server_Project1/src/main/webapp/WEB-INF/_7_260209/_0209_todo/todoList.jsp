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
        <a href="/todo/register_0209">글쓰기</a>
    </div>
    <div>
        <h1>로그인한 유저 정보 나타내기 : ${loginInfo.mname}</h1>
        <h1>로그인한 유저 정보 나타내기2, uuid: ${loginInfo.uuid}</h1>
        <h2>서블릿 컨텍스트에 저장된 데이터 불러와서 화면에 표현하기</h2>
        <%-- 서블릿에서 설정한 데이터 가져오기 --%>
        <p>메시지: <%= application.getAttribute("globalMessage") %></p>
        <p>관리자 이메일: <%= application.getInitParameter("adminEmail") %></p>   <%-- 이것도 el과 비슷 하지만 el이 더 최신 버전 --%>
        <p>내 이메일: ${initParam.myEmail}</p>  <%-- el로 쓰려면 예전방식과 다른 방법으로 사용해야 함 --%>
        <h3>직접 가져오기.</h3>
        <h3>관리자 이메일2 : ${adminEmailDirect}</h3>
        <h3>내 이메일2 : ${myEmailDirect}</h3>
    </div>
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>
                <span><a href="/todo/read_0209?tno=${dto.tno}">${dto.title}</a></span>
                <span>${dto.tno}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished ? "완료" : "미완료"}</span>
            </li>
        </c:forEach>
    </ul>

    <form action="/logout_0209" method="post">
        <button>로그아웃</button>
    </form>
</body>
</html>
