# 2025/03/24 정리

### 1. 파라미터 전달 방식

form을 통한 전달

```html
<form action="viewone.jsp" method="get">
  <input type="text" name="id" />
  <button type="submit">보내기</button>
</form>
```

자바스크립트로 URL에 쿼리스트링 붙이기

```javascript
location.href = 'viewone.jsp?id=' + form.id.value;
```

GET 방식으로 직접 URL을 조작해서 파라미터 전달  
폼을 제출하지 않아도 원하는 페이지로 이동 가능
<hr>

### 2. JSP에서 contextPath 주의

JSP에서 forward로 이동한 경우,  
브라우저 주소(URL)는 그대로지만 실제 화면은 다른 JSP일 수 있음  
이때 상대경로로 링크나 자원(css, js)을 작성하면 깨질 수 있음

해결 방법:

```jsp
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
```

항상 contextPath를 기준으로 경로를 잡아야 안정적
<hr>

### 3. JS파일과 HTML/JSP 파일 분리 시 EL 사용 불가

자바스크립트를 .js 파일로 분리한 경우,  
${} 같은 JSP의 EL(Expression Language)는 작동하지 않음  
이유: .js는 JSP로 컴파일되지 않기 때문

해결 방법:

JSP에서 값은 JS 함수의 파라미터로 넘겨주는 방식

```jsp
<script>
  myFunction("${sessionScope.userId}");
</script>
```

또는 숨겨진 input에 미리 담아두고 JS에서 꺼내기:

```jsp
<input type="hidden" id="userId" value="${sessionScope.userId}" />
```

```javascript
let userId = document.getElementById("userId").value;
```
<hr>

### 4. fetch() 함수는 비동기 요청을 보낼 때 사용

기본 사용법

```javascript
fetch("CommentController?writer=홍길동&content=댓글입니다")
  .then(response => response.json())
  .then(data => {
    console.log(data); // 서버 응답 데이터
  })
  .catch(err => console.error(err));
```

주소는 서블릿 URL이 들어감  
GET 또는 POST 요청 가능  
응답은 JSON 형태로 받아 처리 가능
    <hr>

### 5. 비동기 방식은 이런 상황에 적합

- 화면 일부만 바꾸고 싶을 때 (예: 댓글만 추가하거나 삭제)
- 실시간 반영이 필요할 때 (예: 좋아요, 실시간 검색, 채팅)
- 새로고침 없이 작동해야 할 때 (페이지 전체를 다시 로드하지 않고 부드럽게 처리)
- 서버와 JSON 데이터만 주고받을 때 (HTML 전체 대신 필요한 데이터만 교환)

비동기 방식 vs 동기 방식 비교

| 구분 | 동기 방식 | 비동기 방식 |
|------|-----------|-------------|
| 특징 | 응답 올 때까지 기다림 | 기다리지 않고 다음 코드 실행 |
| 예시 | form.submit(), location.href | fetch(), AJAX, axios |
| 새로고침 | 있음 | 없음 |
| 사용 위치 | 게시글 등록, 로그인 처리 등 | 댓글 작성, 좋아요, 자동완성 등 |