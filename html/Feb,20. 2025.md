# **HTML 태그 정리 및 예제 코드**

## **VS Code 확장파일 세팅**
- **Material Theme** → 테마 팩  
- **Material Icon Theme** → 아이콘 팩  
- **Live Server** → 웹 개발 시 수정 사항을 브라우저에 바로 적용  
- **IntelliCode** → 자동 완성  
- **Auto Import** → 파일명 입력하면 자동 import  
- **Auto Rename Tag** → 태그명 수정 시 닫는 태그명까지 함께 수정  
- **Auto Close Tag** → 여는 태그 생성 시 닫는 태그명까지 함께 생성  

---

## **1. WEB 개요**
### **1.1 WEB (웹)**
- 인터넷에서 동작하는 서비스의 일종  
- **HTTP 프로토콜**, **하이퍼텍스트**, **HTML 형식** 등을 사용하여 그림과 문자를 교환하는 전송 방식  

### **1.2 HTTP (Hypertext Transfer Protocol)**
1) 클라이언트 - 서버 통신을 가능하게 하는 **어플리케이션 규약**  
2) 웹 서버가 **HTML, 이미지, 동영상** 등의 데이터를 주고받을 때 사용  

### **1.3 HTML (HyperText Markup Language)**
1) **웹 페이지를 만들 때 사용하는 표준 언어** (프로그래밍 언어 아님)  
   - **Markup Language** : 태그 등을 이용하여 데이터의 구조를 명기  
2) **여러 태그로 구성되어 웹페이지의 디자인을 구성**  
3) **여는 태그와 닫는 태그 필요**  
   ```html
   <p>안녕하세요</p>
   ```
4) **HTML 실행 순서**  
   - `<head>` 먼저 실행 → `<body>` 실행  

5) **기본 단축키**  
   - VSCode 주석 : `Ctrl + /`  
   - `127.0.0.1:5500` → **5500 포트, localhost**  

---

## **2. 제목 태그 (`h1` ~ `h6`)**
- `h1`이 가장 크고, `h6`이 가장 작음.
- **블록레벨 태그** (한 줄 전체 차지)

### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>제목 태그 예제</title>
</head>
<body>
    <h1>제목 1</h1>
    <h2>제목 2</h2>
    <h3>제목 3</h3>
    <h4>제목 4</h4>
    <h5>제목 5</h5>
    <h6>제목 6</h6>
</body>
</html>
```
---

## **3. 문단 태그 (`p`, `pre`, `br`, `hr`)**
- `<p>` : 문단 태그 (줄 바꿈 자동 적용)  
- `<pre>` : 입력한 대로 출력  
- `<br>` : 줄 바꿈 태그  
- `<hr>` : 수평선 태그  

### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>문단 태그 예제</title>
</head>
<body>
    <p>이것은 첫 번째 문단입니다.</p>
    <p>이것은 두 번째 문단입니다.</p>
    <hr>
    <pre>
이것은         공백을 유지하는
pre 태그입니다.
    </pre>
    <p>줄 바꿈을 하고 싶다면<br>이렇게 br 태그를 사용합니다.</p>
</body>
</html>
```

---

## **4. 텍스트 스타일 태그**
| 태그 | 설명 |
|------|------|
| `<b>` | **굵은 글씨 (Bold Text)** |
| `<i>` | *기울임꼴 (Italic Text)* |
| `<sup>` | 윗첨자 (제곱 표현) |
| `<sub>` | 아랫첨자 |
| `<ins>` | **밑줄** |
| `<del>` | ~~취소선~~ |

### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>텍스트 스타일 태그 예제</title>
</head>
<body>
    <b>굵은 글씨</b><br>
    <i>기울임꼴</i><br>
    2<sup>3</sup> (윗첨자)<br>
    H<sub>2</sub>O (아랫첨자)<br>
    <ins>밑줄이 그어진 글씨</ins><br>
    <del>삭제된 글씨</del>
</body>
</html>
```

---

## **5. 목록 태그 (`ul`, `ol`, `dl`)**
- `<ul>` : 순서 없는 목록 (●, ○, ■)  
- `<ol>` : 순서 있는 목록 (1, 2, 3 / A, B, C)  
- `<dl>` : 설명 목록  

### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>목록 태그 예제</title>
</head>
<body>
    <h2>순서 없는 목록</h2>
    <ul>
        <li>사과</li>
        <li>바나나</li>
        <li>오렌지</li>
    </ul>

    <h2>순서 있는 목록</h2>
    <ol>
        <li>첫 번째</li>
        <li>두 번째</li>
        <li>세 번째</li>
    </ol>

    <h2>설명 목록</h2>
    <dl>
        <dt>HTML</dt>
        <dd>웹 페이지를 만드는 언어</dd>
        <dt>CSS</dt>
        <dd>웹 페이지의 스타일을 지정하는 언어</dd>
    </dl>
</body>
</html>
```
---
## **6. 이미지 태그 (`<img>`)**
- **이미지를 삽입할 때 사용**
- 주요 속성  
  - `src` : 이미지 경로  
  - `alt` : 이미지가 로딩되지 않을 경우 대체 텍스트 
### **✅ 예제 코드** 
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>이미지 태그 예제</title>
</head>
<body>
    <h2>이미지 삽입</h2>
    <img src="example.jpg" alt="대체 이미지" width="300">
</body>
</html>
```
---

## **7. 테이블 태그 (`<table>`)**
- `<tr>` : 행(Row)  
- `<td>` : 열(Column)  
- `<th>` : 제목 열 (굵고 중앙 정렬)  
- **병합 속성**
  - `rowspan="2"` → 행 병합  
  - `colspan="2"` → 열 병합  


### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>테이블 태그 예제</title>
</head>
<body>
    <h2>기본 테이블</h2>
    <table border="1">
        <tr>
            <th>이름</th>
            <th>나이</th>
            <th>직업</th>
        </tr>
        <tr>
            <td>홍길동</td>
            <td>30</td>
            <td>개발자</td>
        </tr>
        <tr>
            <td>김영희</td>
            <td>25</td>
            <td>디자이너</td>
        </tr>
    </table>
</body>
</html>
```
---
## **8. 링크 태그 (`<a>`)**
- 링크 이동을 위한 태그  
- 주요 속성  
  - `href` : 이동할 주소  
  - `target="_blank"` → 새 창에서 열기  
  - `title` : 풍선 도움말  

### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>링크 태그 예제</title>
</head>
<body>
    <h2>외부 링크</h2>
    <a href="https://www.google.com" target="_blank">구글로 이동</a>

    <h2>내부 링크</h2>
    <a href="#section">아래 섹션으로 이동</a>

    <h2 id="section">이곳이 내부 링크의 목적지</h2>
</body>
</html>
```
---
## **9. HTML 시맨틱 태그 (Semantic Elements)**
| 태그 | 설명 |
|------|------|
| `<header>` | 웹 페이지의 머리글 (로고, 내비게이션 포함) |
| `<nav>` | 내비게이션 메뉴 |
| `<section>` | 독립적인 콘텐츠 구역 |
| `<aside>` | 광고, 사이드바 등 보조 정보 |
| `<footer>` | 바닥글 (저작권, 연락처 등) |
### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>시맨틱 태그 예제</title>
</head>
<body>
    <header>
        <h1>웹사이트 제목</h1>
    </header>

    <nav>
        <ul>
            <li><a href="#">홈</a></li>
            <li><a href="#">소개</a></li>
            <li><a href="#">연락처</a></li>
        </ul>
    </nav>

    <section>
        <h2>메인 콘텐츠</h2>
        <p>이곳은 웹사이트의 주요 콘텐츠가 들어가는 영역입니다.</p>
    </section>

    <aside>
        <h3>사이드바</h3>
        <p>여기에 보조 정보가 들어갈 수 있습니다.</p>
    </aside>

    <footer>
        <p>&copy; 2025 My Website</p>
    </footer>
</body>
</html>
```

---

## **10. 폼 태그 (`<form>`)**
- **사용자 입력을 받을 때 사용**  
- 주요 속성  
  - `action` : 입력 데이터를 처리할 위치  
  - `method`  
    - `get` → 보안이 약하지만 속도가 빠름 (검색)  
    - `post` → 보안이 강하지만 속도가 느림 (로그인)  
  - `enctype` : 파일 업로드 시 사용  
### **✅ 예제 코드**
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>폼 태그 예제</title>
</head>
<body>
    <h2>회원가입 폼</h2>
    <form action="submit.php" method="post">
        이름: <input type="text" name="name"><br>
        이메일: <input type="email" name="email"><br>
        <input type="submit" value="제출">
    </form>
</body>
</html>
```
---

