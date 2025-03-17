# 2025/03/07
# 액션 태그 (Action Tag)

## 1. 페이지 관련 액션 태그

### 1) forward 액션
```jsp
<jsp:forward page="이동할 페이지"></jsp:forward>
<jsp:forward page="이동할 페이지" />
```

### 2) include 액션 (태그 안에 주석 금지)
```jsp
<jsp:include page="포함할 페이지"> <!-- 내부 주석 금지★ -->
    <jsp:param name="파라미터이름" value="파라미터값" />
    <jsp:param name="파라미터이름" value="파라미터값" />
    <jsp:param name="파라미터이름" value="파라미터값" />
</jsp:include>

<jsp:include page="포함할 페이지" />
```
- `include` 지시어와 같으나 태그 형태

### 3) include 지시어 vs include 액션
| 구분 | 사용 방식 | 특징 |
|------|----------|------|
| include 지시어 | `<%@ include file="포함할 페이지" %>` | 정적 페이지 포함 (변하지 않는 내용) |
| include 액션 | `<jsp:include page="포함할 페이지">` | 동적 페이지 포함 (변하는 내용) |

---

## 2. 자바빈 (Java Bean) 관련 태그

### 1) 자바빈 태그
| 태그 | 역할 |
|------|------|
| `<jsp:useBean>` | JSP 페이지에서 자바빈을 사용 (`object`) |
| `<jsp:setProperty>` | 자바빈의 프로퍼티 값을 `set` (`setter`) |
| `<jsp:getProperty>` | 자바빈의 프로퍼티 값을 `get` (`getter`) |

### 2) 자바빈이란?
- 자바빈 개발 규약에 따라 작성된 자바 클래스
- 개발자가 직접 만들어 사용하는 클래스
- JSP에서는 표준 액션 태그로 처리

### 3) 자바빈 개발 규약
- 반드시 특정 패키지에 작성 (`default package` 사용 금지)
- `필드 + 생성자 + getter/setter`로 구성
- `property`는 반드시 `private`으로 작성
- 생성자는 반드시 **디폴트 생성자**를 직접 작성 (`<jsp:useBean>`에서 사용)
- `getter/setter`는 반드시 `public`으로 작성
---
# EL (Expression Language)

## 1. EL이란?
- JSP에서 사용하는 새로운 스크립트 언어
- 표현식을 대체하는 역할 (`<%= 변수값 %>`, `<%= 계산식 %>`, `<%= 함수() %>`)
- 4가지 영역(객체)에서 사용
  - `pageContext`, `request`, `session`, `application`

## 2. EL 표현 방식
- `<%= 변수값 %>` → `${변수값}`

## 3. EL 내장 객체
- 파라미터를 사용할 때 `param`, `paramValues` 사용
  - `param` : 단일 변수
  - `paramValues` : 배열

## 4. EL 연산자
### 1) 산술 연산자
| 연산자 | 설명 |
|--------|------|
| `+`    | 더하기 |
| `-`    | 빼기 |
| `div`  | a를 b로 나눈 몫 |
| `mod`  | a를 b로 나눈 나머지 |

### 2) 비교 연산자
| 연산자 | 설명 |
|--------|------|
| `eq`   | `==` 같다 |
| `ne`   | `!=` 같지 않다 |
| `gt`   | `>` 크다 |
| `lt`   | `<` 작다 |
| `ge`   | `>=` 크거나 같다 |
| `le`   | `<=` 작거나 같다 |

### 3) 논리 연산자
| 연산자 | 설명 |
|--------|------|
| `and`  | `&&` 그리고 |
| `or`   | `||` 또는 |
| `not`  | `!` 아니다 |

### 4) empty 연산자
- 값이 `null`이면 `true` 반환
- 값이 빈 문자열(`""`)이면 `true` 반환
- 값의 길이가 `0`인 배열이면 `true` 반환
- 값이 빈 `Map`이면 `true` 반환
- 값이 빈 `Collection`이면 `true` 반환

### 5) 비교 선택 연산자
- `수식 ? 값1 : 값2`

### 6) 문자열 연결
```jsp
<% request.setAttribute("title", "JSP 프로그래밍"); %>
```
- `${"문자" += "열" += "연결"}` → 문자열 연결
- `${"제목 : " += title}` → `제목 : JSP 프로그래밍`
