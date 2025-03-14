# JSP 쿠키 (JSP Cookie) 보충 정리

## 1. 쿠키란?
- 쿠키는 웹 브라우저에 저장되는 작은 데이터 조각.
- 사용자의 상태 정보를 저장하여 서버와의 지속적인 연결 없이도 정보를 유지할 수 있음.
- 예) 로그인 상태 유지, 장바구니 정보 저장 등.

## 2. JSP에서 쿠키 사용 방법

### 2.1 쿠키 생성
```jsp
Cookie cookie = new Cookie("username", "JohnDoe"); // 쿠키 생성
cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효 기간 (1일)
response.addCookie(cookie); // 응답에 쿠키 추가
```
- `new Cookie(이름, 값)`: 쿠키 생성
- `setMaxAge(초)`: 쿠키의 유효 시간 설정 (초 단위)
- `response.addCookie(cookie)`: 클라이언트에 쿠키 전송

### 2.2 쿠키 읽기
```jsp
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("username".equals(cookie.getName())) {
            out.println("쿠키 값: " + cookie.getValue());
        }
    }
}
```
- `request.getCookies()`: 클라이언트에서 전송된 쿠키 배열 가져오기
- `cookie.getName()`: 쿠키의 이름 확인
- `cookie.getValue()`: 쿠키 값 가져오기

### 2.3 쿠키 수정
```jsp
Cookie cookie = new Cookie("username", "JaneDoe");
cookie.setMaxAge(60 * 60 * 24); // 다시 설정
response.addCookie(cookie); // 동일한 이름으로 추가하면 기존 쿠키 덮어쓰기
```
- 같은 이름으로 새로운 값을 설정하면 기존 쿠키가 덮어쓰기 됨.

### 2.4 쿠키 삭제
```jsp
Cookie cookie = new Cookie("username", "");
cookie.setMaxAge(0); // 유효 시간 0으로 설정
response.addCookie(cookie); // 쿠키 삭제
```
- `setMaxAge(0)`: 쿠키를 즉시 삭제
- `response.addCookie(cookie)`: 변경된 쿠키를 클라이언트에 다시 전송하여 삭제 처리 *잊지말것.

## 3. 쿠키 사용 시 주의점
- **보안**: 민감한 정보를 저장할 경우 암호화 필요.
- **크기 제한**: 한 도메인당 최대 ***20개의 쿠키***, 각 쿠키당 4KB 제한.
- **도메인 및 경로 설정**: 쿠키는 기본적으로 생성된 도메인과 경로에서만 접근 가능.

## 4. 쿠키와 세션의 차이
| 항목      | 쿠키 (Cookie) | 세션 (Session) |
|-----------|--------------|---------------|
| 저장 위치 | 클라이언트    | 서버         |
| 보안      | 낮음         | 높음         |
| 유효 범위 | 지정한 시간 동안 유지 | 브라우저 종료 시 삭제 (기본) |
| 속도      | 빠름         | 비교적 느림  |

쿠키는 클라이언트 측에 저장되어 요청 속도가 빠르지만 보안이 취약할 수 있으며, 세션은 서버 측에 저장되므로 보안성이 높지만 서버 리소스를 사용함.

## 5. 결론
- 쿠키는 웹 애플리케이션에서 사용자 정보를 저장하고 유지하는 데 유용한 방법.
- JSP에서 쿠키를 활용하면 로그인 정보, 사용자 설정 등을 쉽게 관리할 수 있음.
- 그러나 보안 및 저장 용량 제한 등의 단점이 있으므로 적절한 활용이 필요함.
