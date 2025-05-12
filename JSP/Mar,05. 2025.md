
# 2025/03/05

## 🌍 초반 워크스페이스 인코딩 설정
Eclipse에서 JSP 파일을 UTF-8 인코딩으로 설정하는 방법:
1. **Windows** → **Preferences** 이동
2. 검색창에 **"encod"** 입력 후 아래 설정 변경:
   - **Content Types**, **Workspace**, **CSS Files**, **HTML Files**, **JSP Files** → UTF-8로 설정
3. **Content-Types**는 직접 입력 가능

## 🚀 톰캣 주소 할당 방법
1. **Servers** 탭에서 **Tomcat** 더블 클릭.
2. **Ports** 섹션에서 **HTTP/1.1** 옆 포트 번호 변경

---

## 1️⃣ JSP (Java Server Pages)

### 📌 1. JSP 기본 개념
- JSP는 **웹 브라우저에 HTML 문서를 생성하여 응답하는 역할**을 함.
- **설정 부분**과 **응답 생성 부분**으로 구성됨.

### 📌 2. JSP 동작 원리
1. **JSP(Java Server Page)**는 **서블릿(Servlet) 기반**의 서버측 스크립트(Back-end) 기술.
2. **WAS(Web Application Server)**가 JSP를 **Servlet으로 변환**하여 실행.
3. **JSP 동작 과정**:
   1. **웹 브라우저 요청** → **WAS가 JSP를 Servlet으로 변환 및 실행** → **HTML 응답 반환**
   2. 변환 과정: `abc.jsp` → `abc_jsp.java` → `abc_jsp.class` → 실행

### 📌 3. JSP와 서블릿 비교
| JSP (Java Server Page) | Servlet |
|------------------------|---------|
| View (HTML 출력) 용도 | Logic (비즈니스 로직) 용도 |
| HTML과 Java 코드 혼합 가능 | 순수 Java 코드 |
| 직관적인 웹 페이지 생성 가능 | HTML 생성 시 코드가 복잡해짐 |

### 📌 4. JSP의 주요 스크립트 요소
| 스크립트 요소 | 설명 |
|-------------|------|
| `<%@ 지시어 %>` | JSP 설정을 지정 (예: `pageEncoding="UTF-8"`) |
| `<%! 선언부 %>` | 전역 변수 및 메소드 선언 |
| `<%= 표현식 %>` | 값 출력 (예: `<%= userName %>`) |
| `<% 스크립트릿 %>` | 일반 Java 코드 실행 |

### 📌 5. JSP 주석 사용법
- `<!-- HTML 주석 -->` → **소스 코드에서 보임**
- `<%-- JSP 주석 --%>` → **소스 코드에서 보이지 않음**

### 📌 6. JSP 기본 객체
JSP는 미리 생성된 내장 객체를 제공함.
| 객체 | 설명 |
|------|------|
| `request` | 클라이언트 요청 정보 |
| `response` | 서버 응답 정보 |
| `out` | 출력 스트림 객체 |
| `session` | 사용자 세션 관리 |
| `application` | 웹 애플리케이션 전체에서 공유되는 정보 |
| `pageContext` | JSP 페이지의 실행 정보 |
| `exception` | 예외 처리 객체 |

### 📌 7. JSP 페이지 이동 방법
1. **RequestDispatcher (forward 방식)**
   ```jsp
   request.getRequestDispatcher("nextPage.jsp").forward(request, response);
   ```
   - **현재 페이지에서 다음 페이지로 request를 유지하면서 이동**
   - **URL 주소는 변경되지 않음**

2. **sendRedirect (리다이렉트 방식)**
   ```jsp
   response.sendRedirect("nextPage.jsp");
   ```
   - **새로운 요청을 발생시켜 이동 (URL 변경됨)**
   - **request 데이터는 유지되지 않음**

3. **JavaScript를 이용한 이동**
   ```html
   <script>
       location.href = "nextPage.jsp";
   </script>
   ```

### 📌 8. JSP 세션 관리
1. **세션에 데이터 저장**  
   ```jsp
   session.setAttribute("user", "John Doe");
   ```
2. **세션에서 데이터 가져오기**  
   ```jsp
   String user = (String) session.getAttribute("user");
   ```
3. **세션 데이터 삭제**  
   ```jsp
   session.removeAttribute("user");
   ```
4. **세션 초기화**  
   ```jsp
   session.invalidate();
   ```
5. **세션 타임아웃 설정 (`web.xml`에서 설정 가능)**  
   ```xml
   <session-config>
       <session-timeout>10</session-timeout> <!-- 10분 후 세션 만료 -->
   </session-config>
   ```

### 📌 9. JSP 에러 코드 및 처리
| HTTP 에러 코드 | 의미 |
|--------------|------|
| `500` | 서버 내부 에러 (Internal Server Error) |
| `404` | 페이지를 찾을 수 없음 (Not Found) |

**에러 처리 페이지 설정 (`web.xml`)**
```xml
<error-page>
    <error-code>404</error-code>
    <location>/error404.jsp</location>
</error-page>
```

---

## 2️⃣ JSP에서 Servlet 호출 및 처리

### 📌 1. JSP에서 Servlet 호출하는 방법
```jsp
<form action="MyServlet" method="post">
    <input type="text" name="username">
    <input type="submit" value="Submit">
</form>
```
- `action="MyServlet"` → `MyServlet.java`로 데이터를 전송

### 📌 2. Servlet에서 JSP로 데이터 전달
```java
request.setAttribute("user", "John Doe");
request.getRequestDispatcher("welcome.jsp").forward(request, response);
```
- `request.setAttribute("key", "value")` → 데이터를 저장  
- `getRequestDispatcher("JSP파일")` → 해당 JSP 페이지로 전달

### 📌 3. Servlet에서 JSP 데이터 출력
```jsp
<p>Welcome, <%= request.getAttribute("user") %>!</p>
```

---

## 3️⃣ JSP 개발 시 유용한 팁

### ✅ **1. JSP 인코딩 설정**
한글 출력시 UTF-8 인코딩 설정.
```jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
```

### ✅ **2. Servlet에서 UTF-8 설정**
```java
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
```

### ✅ **3. Java severlet doGet함수에서 PrintWriter 사용**
```java
PrintWriter out = response.getWriter();
out.print("Hello, JSP!");
```
  
