# 2025/03/17
# **JSTL (JavaServer Pages Standard Tag Library)**

## 1. JSTL 개요
1. **JSTL**은 **JSP 표준 태그 라이브러리**로, 여러 태그들의 집합이다.
2. 사용자가 **자신만의 태그**를 추가할 수 있다.
3. **다운로드 방법**  
   - [Apache Tomcat 공식 사이트](https://tomcat.apache.org/)
   - `Download` → `Taglibs` → `JAR 파일 다운로드`
4. **JSTL 라이브러리 종류 및 사용법**  

| **라이브러리** | **기능** | **접두어 (prefix)** | **관련 URL (uri)** |
|--------------|---------|-----------------|------------------------|
| **core** | 변수, 제어문 | `c` | `http://java.sun.com/jsp/jstl/core` |
| **fmt** | 지역화, 날짜/시간 | `fmt` | `http://java.sun.com/jsp/jstl/fmt` |
| **functions** | 문자열, 컬렉션 조작 | `fn` | `http://java.sun.com/jsp/jstl/functions` |
| **xml** | XML 처리 | `x` | `http://java.sun.com/jsp/jstl/xml` |
| **sql** | SQL 처리 | `sql` | `http://java.sun.com/jsp/jstl/sql` |

5. **JSTL 사용을 위한 `taglib` 지시어 작성**
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags"%>
```

6. **JSTL JAR 파일 추가 방법**
   - `Build Path 설정` → `classpath`에 JSTL JAR 파일 추가
   - `WEB-INF/lib` 폴더에 JSTL JAR 파일 추가

---

## 2.core 라이브러리
### **1) 변수 지원**
#### **(1) `set` 태그 (변수 선언)**
```jsp
<c:set var="result" value="${num1+num2}"/>
```
- `num1`, `num2`는 `set`을 통해 선언된 변수이거나, `setAttribute`로 설정된 값.

#### **(2) `remove` 태그 (변수 삭제)**
```jsp
<c:remove var="result"/>
```

### **2) 제어문 지원**
#### **(1) `if` 태그**
```jsp
<c:if test="조건"></c:if>
```
📌 `else`는 없음.

#### **(2) `choose`, `when`, `otherwise` 태그 (다중 조건문)**
```jsp
<c:choose>
    <c:when test="${avg>=90}">
        <c:set var="grade" value="A"/>
    </c:when>
    <c:when test="${avg>=80 }">
        <c:set var="grade" value="B"/>
    </c:when>
    <c:otherwise>
        <c:set var="grade" value="F"/>
    </c:otherwise>
</c:choose>
```

#### **(3) `forEach` 태그 (반복문)**
```jsp
<c:forEach var="i" begin="1" end="10" step="1">
    ${i} <br>
</c:forEach>
```

```jsp
<%
    String[] names = {"김", "이", "박", "최"};
    pageContext.setAttribute("NAMES", names);
%>
<c:forEach var="name" items="${NAMES}">
    ${name} <br>
</c:forEach>
```

#### **(4) `forTokens` 태그 (구분자로 데이터 분리)**
```jsp
<c:set var="animals" value="사자,호랑이;사슴,곰;이구아나^뱀"/>
<c:forTokens items="${animals}" delims=",;^" var="animal">
    ${animal} <br>
</c:forTokens>
```

### **3) URL 지원**
- **`import`** → `<jsp:include>`와 동일 (다른 동적 페이지 포함)  
- **`redirect`** → 리다이렉트

### **4) 기타 기능**
#### **(1) `out` 태그 (출력)**
```jsp
이름 : <c:out value="${name}"/> <br>
주소 : <c:out value="${addr}"/> <br>
전화번호 : <c:out value="${phone}"/> <br>
```
#### **(2) `catch` 태그 (예외 처리)**
```jsp
<c:catch var="exception">
    <%= Integer.parseInt("not a number") %>
</c:catch>

<c:if test="${not empty exception}">
    예외 발생: ${exception}
</c:if>
```

---

# 3.기타
### **페이지 이동 방법**
- **JavaScript** → `location.href="";`  
- **Java** → `forward`, `redirect`  

### **POST 방식 주의점**
- 파라미터가 **노출되지 않을 뿐**, 내부적으로 전달됨.

### **EL(Expression Language)에서 문자열을 숫자로 변환**
```jsp
<c:set var="num1" value="${param.num1+0}"/>
```
📌 문자열을 숫자로 변환할 때 `+0`을 활용.

---

