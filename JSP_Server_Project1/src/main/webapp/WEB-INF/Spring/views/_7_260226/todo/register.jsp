<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- 한글 깨짐 방지 -->
    <meta charset="utf-8">
    <!-- 모바일 반응형 설정: 화면 너비에 맞게 자동 조절 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS CDN: 부트스트랩 스타일을 인터넷에서 불러옴 (설치 없이 사용 가능) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">


    <title>Todo 등록</title>
    <style>
        /* body: 페이지 전체 배경색 - 상남자는 어두운 배경 */
        body {
            background-color: #1a001a;
        }

        /* .navbar: 부트스트랩 nav 클래스를 덮어쓰기 위해 !important 사용 */
        .navbar {
            background-color: #ff007f !important;
            border-bottom: 4px solid #ff00ff;
        }

        /* 네비게이션 브랜드(로고)와 메뉴 링크 스타일 */
        .navbar-brand, .nav-link {
            color: white !important;
            font-weight: 900;
            font-size: 1.1rem;
            /* text-shadow: x축 y축 번짐범위 색상 - 네온사인 느낌
               여러 개 쉼표로 중첩해서 극강 글로우 표현 가능
               마지막 3px 3px 0px: 오른쪽 아래로 그림자 (입체감) */
            text-shadow: 0 0 8px #ff00ff;
        }

        /* 마우스 올렸을 때 링크 색상 변경 */
        .nav-link:hover {
            color: #ff00ff !important;
        }

        /* .card: 부트스트랩 카드 컴포넌트 커스텀
           box-shadow: x축 y축 번짐 색상 - 여러 개 쉼표로 중첩 가능 */
        .card {
            border: 4px solid #ff007f;
            border-radius: 20px;
            box-shadow: 0 0 30px #ff007f, 0 0 60px #ff00ff;
        }

        /* 카드 상단 헤더 영역
           linear-gradient: 그라데이션 (각도, 시작색, 끝색) */
        .card-header {
            background: linear-gradient(135deg, #ff007f, #ff00ff);
            color: white;
            font-size: 1.6rem;
            font-weight: 900;
            border-radius: 15px 15px 0 0 !important;
            text-align: center;
            letter-spacing: 4px;
            text-shadow: 0 0 10px white;
        }

        /* 카드 본문 영역 */
        .card-body {
            background-color: #2d0020;
            border-radius: 0 0 15px 15px;
        }

        /* .form-label: 인풋 위에 있는 라벨 텍스트 */
        .form-label {
            color: #ff007f;
            font-weight: 900;
            font-size: 1.05rem;
            text-shadow: 0 0 6px #ff007f;
        }

        /* .form-control: 부트스트랩 input 클래스 커스텀 */
        .form-control {
            background-color: #1a001a;
            border: 2px solid #ff007f;
            color: #ff99cc;
        }

        /* ::placeholder: input 안의 힌트 텍스트 색상 */
        .form-control::placeholder {
            color: #aa4466;
        }

        /* :focus - 인풋 클릭해서 활성화됐을 때 스타일 */
        .form-control:focus {
            background-color: #1a001a;
            border-color: #ff00ff;
            color: #ff99cc;
            /* rgba: rgb에 투명도(0~1)를 추가한 색상 표현 */
            box-shadow: 0 0 0 0.25rem rgba(255, 0, 255, 0.4);
        }

        /* 커스텀 버튼: 부트스트랩 기본 btn 클래스에 추가로 쓸 클래스 */
        .btn-pink {
            background: linear-gradient(135deg, #ff007f, #ff00ff);
            color: white;
            border: none;
            font-weight: 900;
            font-size: 1.1rem;
            box-shadow: 0 0 15px #ff007f;
            letter-spacing: 2px;
        }

        /* 버튼에 마우스 올렸을 때
           transform: scale(1.05) - 버튼 크기를 1.05배로 키워서 튀어오르는 느낌 */
        .btn-pink:hover {
            background: linear-gradient(135deg, #ff00ff, #ff007f);
            color: white;
            box-shadow: 0 0 25px #ff00ff;
            transform: scale(1.05);
        }

        /* 외곽선만 있는 버튼 스타일 */
        .btn-outline-pink {
            border: 2px solid #ff007f;
            color: #ff007f;
            font-weight: 900;
            text-shadow: 0 0 6px #ff007f;
        }

        .btn-outline-pink:hover {
            background-color: #ff007f;
            color: white;
            box-shadow: 0 0 15px #ff007f;
        }

        footer {
            color: #ff007f;
            font-weight: bold;
            text-shadow: 0 0 8px #ff00ff;
        }

        h1.title {
            color: #ff007f;
            font-weight: 900;
            font-size: 2.5rem;
            text-shadow: 0 0 10px #ff007f, 0 0 30px #ff00ff;
            text-align: center;
            margin: 30px 0;
            letter-spacing: 4px;
        }

        /* 체크됐을 때 배경만 검정으로 */
        .form-check-input:checked {
            background-color: #ff00ff;
        }

        /* 달력 아이콘 색 반전 - 어두운 배경에서 아이콘이 안보이는 문제 해결
           filter: invert(1) 은 색상을 반전시켜서 검정 아이콘 → 흰색 아이콘으로 만들어줌
           navbar-dark 같은 전용 클래스가 없어서 이 방법이 유일함 */
        input[type="date"]::-webkit-calendar-picker-indicator {
            filter: invert(1);
            cursor: pointer;
        }
    </style>
</head>
<body>

<%--    <div class="container-fluid">--%>
<%--        <div class="row">--%>
<%--            <!--        <h1>Header</h1>-->--%>
<%--            <!--        col은 숫자가 없으면 균등하게 나눠지고 숫자가 있으면 비율별로 나눠짐-->--%>
<%--            <div class="col">--%>
<%--                <!--            네비게이션 바-->--%>
<%--                <nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--                    <div class="container-fluid">--%>
<%--                        <a class="navbar-brand" href="#">Navbar</a>--%>
<%--                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"--%>
<%--                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                            <span class="navbar-toggler-icon"></span>--%>
<%--                        </button>--%>
<%--                        <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--                            <ul class="navbar-nav">--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link active" aria-current="page" href="#">Home</a>--%>
<%--                                </li>--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link" href="#">Features</a>--%>
<%--                                </li>--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link" href="#">Pricing</a>--%>
<%--                                </li>--%>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </nav>--%>
<%--            </div>--%>
<%--            <div class="row content">--%>
<%--                <div class="col">--%>
<%--                    <!--                카드-->--%>
<%--                    <div class="card">--%>
<%--                        <div class="card-header">--%>
<%--                            Featured--%>
<%--                        </div>--%>
<%--                        <div class="card-body">--%>
<%--                            <form action="/_7_260226/todo/register" method="post">--%>
<%--                                <div class="input-group mb-3">--%>
<%--                                    <span class="input-group-text">Title : </span>--%>
<%--                                    <input class="form-control" type="text" name="title" placeholder="todo 제목을 입력해주세요.">--%>
<%--                                </div>--%>
<%--                                <div class="input-group mb-3">--%>
<%--                                    <span class="input-group-text">DueDate : </span>--%>
<%--                                    <input class="form-control" type="date" name="dueDate">--%>
<%--                                </div>--%>
<%--                                <div class="input-group mb-3">--%>
<%--                                    <span class="input-group-text">Writer : </span>--%>
<%--                                    <input class="form-control" type="text" name="writer">--%>
<%--                                </div>--%>
<%--                                <div class="form-check form-switch mb-3">--%>
<%--                                    &lt;%&ndash; id="finishedLabel": JS에서 이 span을 찾아서 텍스트 바꾸기 위한 ID &ndash;%&gt;--%>
<%--                                    <span class="form-check-label" id="finishedLabel">Finished : Off</span>--%>
<%--                                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="finished">--%>
<%--                                </div>--%>
<%--                                <div class="custom-check-inline">--%>
<%--                                    <label for="myCheck2">완료 여부: </label>--%>
<%--                                    <input type="checkbox" id="myCheck2" name="finished">--%>
<%--                                </div>--%>
<%--                                <div>--%>
<%--                                    <button class="btn btn-secondary" type="reset">초기화</button>--%>
<%--                                    <button class="btn btn-primary" type="submit">등록하기</button>--%>
<%--                                </div>--%>
<%--                            </form>--%>
<%--                            <h5 class="card-title">Special title treatment</h5>--%>
<%--                            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>--%>
<%--                            <a href="#" class="btn btn-primary">Go somewhere</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row content">--%>
<%--            <h1>Content</h1>--%>
<%--        </div>--%>
<%--        <div class="row footer">--%>
<%--            <!--        <h1>Footer</h1>-->--%>
<%--            <!--        fixed-botoom는 화면 아래에 고정-->--%>
<%--            <!--        z-index는 숫자가 큰 뷰(콘텐츠)가 화면에 보이고 숫자가 작은 뷰는 큰뷰에 의해 덮힌다.-->--%>
<%--            <!--        보통 z-index가 없는 뷰는 0혹은 1로 설정됨-->--%>
<%--            <div class="row fixed-bottom" style="z-index: -100">--%>
<%--                <!--            p(padding)y(axisY): 위아래 패딩(뷰 자체 크기에서 안으로 줄어드는 거)-->--%>
<%--                <!--            m(margin)y(axisY): 위아래 마진(뷰 외부 간격)-->--%>
<%--                <footer class="py-1 my-1">--%>
<%--                    <!--                text-center 가운데 정렬-->--%>
<%--                    <!--                text-muted 텍스트 흐리게-->--%>
<%--                    <p class="text-center text-muted">--%>
<%--                        Footer--%>
<%--                    </p>--%>
<%--                </footer>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <%-- container-fluid: 화면 전체 너비를 사용하는 부트스트랩 컨테이너 --%>
    <div class="container-fluid">

        <%-- ===== 네비게이션 바 영역 ===== --%>
        <%-- row: 부트스트랩 그리드의 행(가로줄) --%>
        <div class="row">
            <%-- col: 행 안의 열(세로 칸), 숫자 없으면 균등 분할 --%>
            <div class="col">
                <%-- navbar-expand-lg: lg(1024px) 이상에서 메뉴 펼침, 그 이하는 햄버거 버튼 --%>
                <%-- navbar: 네비게이션 바 기본 스타일
                     navbar-expand-lg: lg(1024px) 이상 화면에서 메뉴 펼침, 그 이하는 햄버거 버튼으로 전환
                     navbar-dark: 배경이 어두울 때 사용 - 글자/햄버거 아이콘을 자동으로 흰색 계열로 바꿔줌
                                  (navbar-light는 반대로 글자/아이콘을 검정 계열로 설정)
                                  배경색을 자동 감지하는 게 아니라 개발자가 직접 선택하는 것! --%>
                <nav class="navbar navbar-expand-lg navbar-dark">
                    <div class="container-fluid">
                        <%-- navbar-brand: 로고/브랜드명 영역
                             그냥 <a> 태그써도 링크는 되지만 navbar-brand를 쓰면
                             부트스트랩이 글자 크기, 굵기, 여백을 자동으로 로고처럼 스타일링해줌 --%>
                            <a class="navbar-brand" href="/_7_260226/todo/list">Navbar</a>
                            <img src="/resources/bug.jpg"
                                 alt="호빵맨"
                                 width="50"
                                 height="50">
                            Todo
                        </a>

                        <%-- navbar-toggler: 모바일(lg 미만)에서 보이는 햄버거(≡) 버튼 스타일
                             type="button": 그냥 버튼임을 명시 (type="submit"이면 폼 제출 버튼이 되므로 구분 필요)
                             data-bs-toggle="collapse": 부트스트랩 JS한테 "이 버튼은 접었다 폈다 하는 버튼이야" 알려줌
                             data-bs-target="#navbarNav": 접었다 폈다 할 대상 지정 (#은 id 선택자)
                                                          → 아래 id="navbarNav"인 div를 열고 닫음
                             aria-controls, aria-expanded, aria-label: 시각장애인 스크린리더용 접근성 속성
                                                                        화면엔 영향 없음 --%>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <%-- navbar-toggler-icon: 햄버거 아이콘(≡)을 CSS로 그려주는 클래스
                                                      실제 내용은 없고 부트스트랩이 배경이미지로 아이콘 표시 --%>
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <%-- collapse: 기본적으로 숨김 처리
                             navbar-collapse: 햄버거 버튼 클릭 시 펼쳐지는 메뉴 영역
                             id="navbarNav": data-bs-target="#navbarNav"와 연결되는 타겟 --%>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <%-- active: 현재 페이지임을 표시 - 부트스트랩이 텍스트를 살짝 더 강조해줌
                                         단, 우리 코드처럼 color: white !important 로 덮어버리면 육안으로 차이 거의 없음
                                         의미상 "지금 이 메뉴가 현재 페이지"라고 표시하는 관례적 용도
                                         나중에 JSP에서 현재 URL에 따라 active를 동적으로 붙여줄 수 있음 --%>
                                        <a class="nav-link active" aria-current="page" href="/_7_260226/todo/register">글쓰기</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Todo 목록</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">등록</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <%-- ===== 페이지 제목 ===== --%>
        <h1 class="title">상남자의 Todo 등록</h1>

        <%-- ===== 폼 카드 영역 ===== --%>
        <%-- justify-content-center: row 안에서 col을 가운데 정렬 --%>
        <div class="row justify-content-center">
            <%-- col-md-6: 화면이 md(768px) 이상일 때 전체 12칸 중 6칸(50%) 사용 --%>
            <div class="col-md-6">

                <%-- card: 부트스트랩 카드 컴포넌트 (테두리+그림자가 있는 박스) --%>
                <div class="card">
                    <%-- card-header: 카드 상단 헤더 --%>
                    <div class="card-header">
                        Todo 등록하기
                    </div>

                    <%-- card-body: 카드 본문 영역, p-4 = padding 4단계(1.5rem) --%>
                    <div class="card-body p-4">

                        <%-- form action: 폼 제출 시 이동할 URL (컨트롤러 매핑 경로)
                             method="post": GET은 URL에 데이터 노출, POST는 숨겨서 전송 --%>
                        <form action="/_7_260226/todo/register" method="post">

                            <%-- mb-3: margin-bottom 3단계(1rem) - 인풋 간격 --%>
                            <div class="mb-3">
                                <%-- form-label: 인풋 위 라벨 텍스트 --%>
                                <label class="form-label">Title</label>
                                <%-- form-control: 부트스트랩 인풋 스타일
                                     name="title": 서버로 전송될 때 파라미터 이름 (TodoDTO의 title 필드와 매핑) --%>
                                <input type="text" class="form-control" name="title" placeholder="할 일을 입력해주세요.">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">DueDate</label>
                                <%-- type="date": 날짜 선택 달력 인풋 자동 생성 --%>
                                <input type="date" class="form-control" name="dueDate">
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Writer</label>
                                <input type="text" class="form-control" name="writer" placeholder="작성자 이름">
                            </div>

                            <%-- mb-4: 아래 마진 4단계
                                 form-check: 체크박스/라디오버튼을 감싸는 부트스트랩 wrapper
                                             체크박스와 라벨을 가로로 나란히 배치해줌 --%>
                    <%--                                <div class="form-check form-switch mb-3">--%>
                    <%--                                    &lt;%&ndash; id="finishedLabel": JS에서 이 span을 찾아서 텍스트 바꾸기 위한 ID &ndash;%&gt;--%>
                    <%--                                    <span class="form-check-label" id="finishedLabel">Finished : Off</span>--%>
                    <%--                                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="finished">--%>
                    <%--                                </div>--%>

                            <div class="mb-3 form-check form-switch">
                                <%-- type="checkbox": 체크박스 인풋
                                     form-check-input: 부트스트랩 체크박스 스타일 (크기, 색상 등)
                                     name="finished": 서버로 전송될 파라미터 이름 → TodoDTO의 finished 필드와 매핑
                                                      체크 안 하면 값 자체가 전송 안 됨 (null)
                                     id="finished": 아래 label의 for="finished"와 연결하기 위한 ID
                                     style 인라인: 별도 클래스 안 만들고 태그에 직접 스타일을 박은 것 --%>
                                <input type="checkbox" class="form-check-input" name="finished" id="finished"
                                       style="border-color: #ff69b4;">
                                <%-- form-check-label: 체크박스 옆 라벨 텍스트 부트스트랩 스타일
                                     for="finished": id="finished"인 체크박스와 연결
                                                     for와 id가 같으면 라벨 텍스트 클릭해도 체크박스가 체크됨! --%>
                                <label class="form-check-label" id="finishedLabel" for="finished" style="color: #c2185b; font-weight: bold;">
                                    Finished : Off
                                </label>
                            </div>

                            <%-- d-flex: display:flex 적용 (자식 요소를 가로로 배치)
                                 gap-2: 자식 요소 사이 간격
                                 justify-content-end: 오른쪽 정렬 --%>
                            <div class="d-flex gap-2 justify-content-end">
                                <%-- type="reset": 폼 안의 모든 인풋을 초기값으로 리셋 --%>
                                <button type="reset" class="btn btn-outline-pink">초기화</button>
                                <%-- type="submit": 폼 데이터를 action URL로 전송 --%>
                                <button type="submit" class="btn btn-pink">등록하기</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%-- ===== 푸터 영역 =====
             fixed-bottom: 화면 맨 아래에 고정
             z-index: -100 - 다른 콘텐츠 뒤로 보내서 겹치지 않게 함 --%>
        <div class="row fixed-bottom" style="z-index: -100">
            <%-- py-2: padding y축(위아래) 2단계, my-2: margin y축 2단계 --%>
            <footer class="py-2 my-2">
                <%-- text-center: 텍스트 가운데 정렬 --%>
                <p class="text-center">핑크핑크 Todo App</p>
            </footer>
        </div>

    </div>

    <!-- Bootstrap JS CDN: 햄버거 메뉴 토글 등 JS 기능을 위해 반드시 body 맨 아래에 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

    <script>
        //유효성 검사시  오류를 담아둘 빈 객체
        //자바스크립트의 객체의 자료구조 형식 : {key:val, key2:val2, ....}
        const serverValidResult = {}
        let errorString = ""

        /* addEventListener: 특정 이벤트 발생 시 실행할 함수 등록
           'change': 체크박스 상태가 바뀔 때 발생하는 이벤트
           function(): 이벤트 발생 시 실행할 함수
           this.checked: 체크되면 true, 해제되면 false
           삼항연산자: 조건 ? 참일때값 : 거짓일때값 */
        document.getElementById('finished')
            .addEventListener('change', function() {
                document.getElementById('finishedLabel').innerText
                    = this.checked ? 'Finished : On' : 'Finished : Off';
            });

        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="error">
                <c:set var="field" value="${error.field}"/>
                <c:set var="message" value="${error.defaultMessage}"/>
                serverValidResult['${field}'] = '${message}'
                errorString += '${field} = ${message}\n'
            </c:forEach>
            errorString += "값 제대로 적어라"
            console.log("유효성 오류가 난 부분들 : ", serverValidResult)
            alert(errorString)
        </c:if>
    </script>

</body>
</html>