<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>임시리스트</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!--        네비게이션 추가 작업-->
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/_6_260225/todo/list">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/_6_260225/todo/register">글쓰기</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <!--        네비게이션 추가 작업-->
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        검색창 화면
                    </div>
                    <div class="card-body">
                        <form action="/_6_260225/todo/list" method="get">
                            <input type="hidden" name="size" value="${pageRequestDTO_0226.size}">
                            <div class="mb-3">
                                <input type="checkbox" name="finished"
                                ${pageRequestDTO_0226.finished ? "checked" : ""}
                                > 완료여부
                            </div>
                            <div class="mb-3">
                                <input type="checkbox" name="types" value="t"
                                    ${pageRequestDTO_0226.checkType("t") ? "checked" : ""}
                                > 제목
                                <input type="checkbox" name="types" value="w"
                                    ${pageRequestDTO_0226.checkType("w") ? "checked" : ""}
                                > 작성자
<%--                                c:out은 출력시 검색어에 불필요한 자바스크립트 태그가 들어가면 보안상 안좋아서 안전한 출력--%>
                                <input type="text" name="keyword" class="form-control"
                                    value='<c:out value="${pageRequestDTO_0226.keyword}"/>'
                                >
                            </div>
                            <div class="mb-3 input-group dueDateDiv">
<%--                                날짜는 해봤자 정해진 값이 출력되기에 그냥 $중괄호를 써서 넣는다--%>
                                <input type="date" name="from" class="form-control"
                                    value="${pageRequestDTO_0226.from}"
                                >
                                <input type="date" name="to" class="form-control"
                                    value="${pageRequestDTO_0226.to}"
                                >
                            </div>
                            <div class="mb-3 input-group">
                                <div class="float-end">
                                    <button type="submit" class="btn btn-primary">검색하기</button>
                                    <button type="reset" class="btn btn-info clearBtn">초기화하기</button>
                                </div>
                            </div>
                            <script>
                                document.querySelector(".clearBtn").addEventListener("click", function (e) {
                                    e.preventDefault();
                                    e.stopPropagation();
                                    self.location = "/_6_260225/todo/list"
                                })
                            </script>
                        </form>
                    </div>
                </div>
            </div>
        </div>

<%--        검색화면 공간--%>


        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        전체목록
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Tno</th>
                                <th scope="col">Title</th>
                                <th scope="col">Writer</th>
                                <th scope="col">DueDate</th>
                                <th scope="col">Finished</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--<c:forEach items="${dtoList}" var="dto">--%>
<%--                            responseDTO안에 dtoList를 getter로 가져와 dto로 가지고 있음--%>
                            <c:forEach items="${responseDTO.dtoList}" var="dto">
                                <tr>
                                    <th><c:out value="${dto.tno}"/></th>
                                    <td>
                                        <a href="/_6_260225/todo/read?tno=${dto.tno}&${pageRequestDTO_0226.link}" class="text-decoration-none">
                                            <c:out value="${dto.title}"/>
                                        </a>
                                    </td>
                                    <td><c:out value="${dto.writer}"/></td>
                                    <td><c:out value="${dto.dueDate}"/></td>
                                    <td><c:out value="${dto.finished}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
<%--                        float-end : 오른쪽 정렬.
                            d-flex : 디스플레이를 , flex 이용하겠다.
                            justify-content-center : 주축의 정렬을 가운데
                            flex-wrap : 가로 방향으로 나란히 배치시, 그 줄을 넘치는 경우, 다음줄로 이동.--%>
<%--                        <div class="float-end">--%>
<%--                        <div class="float-start">--%>
                        <div class="d-flex justify-content-center">
                            <!--ul이 사이즈로 인해 줄바꿈이 되면 하나로 싸서 2줄로 만들어줌-->
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.start - 1}">Previous</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
<%--                                    active는 page의 번호에 색칠 해주는 기능--%>
                                    <li class="page-item ${responseDTO.page == num ? "active" : ""}">
                                        <a class="page-link" data-num="${num}">${num}</a>
                                    </li>
                                </c:forEach>
<%--                                <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                                <c:if test="${responseDTO.next}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.end + 1}">Next</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                        <script>
<%--                            .pagination은 ul태그--%>
<%--                            ul 태그 안에는 <li>태그와 <a>태그가 있음--%>
                            document.querySelector(".pagination").addEventListener("click", function(e) {
                                e.preventDefault(); //기본동작 막기
                                e.stopPropagation();    //부모요소로 전파 막기, 해당 요소외의 클릭감지x
                                const target = e.target;    //클릭한 <li>태그, <a>태그 요소를 의미
                                if(target.tagName !== 'A') {
                                    return;
                                }
                                const num = target.getAttribute("data-num");
                                self.location = `/_6_260225/todo/list?page=\${num}`;
                                // 연습용
                                <%--let url = "";--%>
                                <%--<c:forEach items="${pageRequestDTO_0226.types}" var="type">--%>
                                <%--    url += "&types=${type}"--%>
                                <%--</c:forEach>--%>
                                <%--self.location = `/_6_260225/todo/list?page=\${num}\${url}&keyword=${pageRequestDTO_0226.keyword}&from=${pageRequestDTO_0226.from}&to=${pageRequestDTO_0226.to}`;--%>
                                //$중괄호 이거는 서버(jsp)에서도 사용 할수 있고, 자바스크립트에서도 사용 가능하기 때문에
                                //앞에 \를 붙여서 자바스크립트의 것을 사용한다고 표시하는것
                            }, false);
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
<%--        <h1>임시리스트</h1>--%>
    </div>
    <div class="row footer">
        <%--        <div class="row fixed-bottom" style="z-index: -100">--%>
        <%--    <div class="row fixed-bottom">--%>
        <footer class="py-3 mt-auto">
            <p class="text-center text-muted mb-0">
                Footer
            </p>
        </footer>
    </div>
    <%--    </div>--%>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>
