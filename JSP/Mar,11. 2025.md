# 2025/03/11 복습

## **Servlet의 doGet 함수 사용법**
### 1) **Encoding 설정**
```java
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
```

### 2) **화면에 출력**
```java
PrintWriter out = response.getWriter();
out.print("~~");
```

---

## **onclick 함수를 통해 form 객체를 갖고 오는 방법**
- `onclick`을 적용할 개체의 태그에 `onclick = "functionName(this.form);"` 과 같이 매개변수에 `this.form`을 명시.

---

## **addEventListener 이용 시 target과 currentTarget 사용 팁**
- `addEventListener()` 설정 시 두 번째 매개변수 함수의 매개변수로 event 객체를 추가하면 이벤트 객체에 접근 가능.
  
### **예제**
```javascript
element.addEventListener("click", function(event) {
    event.target;
    event.currentTarget;
});
```
- `event.target` → 실제 클릭한 요소.
- `event.currentTarget` → `eventListener`가 연결된 요소.
- `event.target.form` 형태로 form 객체를 가져올 수 있음.

---

## **redirect 방식과 forward 방식의 차이**
- **forward 방식**은 **URL이 그대로 유지**된 채 다른 화면을 보여줌.
- **서버 내부에서만 페이지 변동**이 일어나는 방식이며, 클라이언트는 알 수 없음.

```java
request.getRequestDispatcher("파일이름").forward(request, response);
```
- forward는 `request`와 `response`를 **그대로 넘기는 역할**을 함.

### **forward된 JSP에서 변수 사용 예제**
```jsp
${a} ${b} ${c}
```
- 이전 JSP에서 선언된 변수를 별도 코드 없이 출력 가능.

### **변수를 전달하는 방법**
```java
request.setAttribute("변수이름", 변수값);
```
- 이동한 페이지에서(오직 forward 방식) EL을 통해 `${변수이름}`으로 변수값 출력 가능.

---

## **EL(Expression Language)**
- **`${}` 형태**로 변수값을 쉽게 출력할 수 있는 표현식.

---

## **doFilter 함수 사용 팁**
- `doFilter()`에서 `request`, `response`의 타입은 `ServletRequest`, `ServletResponse`이며, `HttpServletRequest`, `HttpServletResponse`가 아님.
- **`getSession()`, `getContextPath()` 등의 메서드를 사용하려면 다운캐스팅 필요**.

```java
HttpServletRequest req = (HttpServletRequest) request;
HttpSession session = req.getSession();
```
- 실제 참조 인스턴스는 `HttpServletRequest`, `HttpServletResponse`이므로 **다운캐스팅하여 사용 가능**.

---

## **`<%@ include file="" %>` vs `<jsp:include page="">`**
### **1) `<%@ include file="">`**
- JSP가 **컴파일될 때** 타 파일의 소스 코드 자체를 현재 페이지에 삽입.
- **변수 공유 가능**.

### **2) `<jsp:include page="">`**
- **Runtime에** 타 파일의 "실행 결과"를 현재 JSP에 포함.
- **변수 공유 불가**.
- `<jsp:param name="" value="" />` 형식으로 값을 전달.
  - 대상 파일에서 `getParameter()`를 통해 값 받을 수 있음.

---

## **Bean 사용법 (출력 화면)**
1. **자바 빈을 생성한다.**
```jsp
<jsp:useBean id="별명" class="패키지경로.클래스명"/>
```

2. **자바 빈에 값을 저장한다.**
```jsp
<jsp:setProperty property="파라미터명" name="별명"/>
```
- `<jsp:setProperty property="*" name="별명"/>`  
  - request의 파라미터 이름과 동일한 필드에 값을 매핑.

3. **자바 빈의 값을 사용한다.**
```jsp
<jsp:getProperty property="파라미터명" name="별명"/>
```

---

## **Cookie 사용법**
### 1) **쿠키 추가**
```java
response.addCookie(쿠키);
```

### 2) **쿠키 가져오기**
```java
Cookie[] cookies = request.getCookies(); // 배열로 받아야 함
```
