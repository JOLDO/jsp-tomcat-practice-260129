<%--
  Created by IntelliJ IDEA.
  User: joldo
  Date: 26. 1. 29.
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
    <%--실습2
    메뉴를 입력 받는 jsp 파일 만들기. /menu/menu.jsp , form 방식 이용하고,
    화면에서, 입력란 1개, 버튼 1개(주문),

    처리는 post 형식으로
    주문 받은 메뉴를, 영수증, 주문 받은 메뉴 이름과, 가격을 알려주는 결과 페이지 만들기.
    /menu/menuResult.jsp
    주문 메뉴 : , 가격 : 입니다.
    출력이 되는 화면 구성해보기.--%>
    <h1>메뉴</h1>
    <form action="menuResult.jsp" method="post">
        <h3>a : 3000원</h3>
        <input type="number" name="a_count">
        <h3>b : 3200원</h3>
        <input type="number" name="b_count">
        <h3>c : 4400원</h3>
        <input type="number" name="c_count">
        <br>
        메뉴 : <input type="text" name="menuName">
        <button type="submit">주문</button>
    </form>
</body>
</html>
