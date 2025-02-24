# 2025/02/21

## 1. CSS 개념 및 적용 방식  
웹 페이지에 스타일(서식)을 적용하는 기능

### 1.1 CSS 적용 방식
1. **Inline Style** (가장 높은 우선순위)
   ```html
   <h1 style="color:red">제목</h1>
   ```
2. **Internal Style** (HTML 파일 내 `<style>` 태그 사용)
   ```html
   <style>
     h1 { color: red; }
   </style>
   ```
3. **External Style** (외부 CSS 파일 활용)
   ```html
   <link rel="stylesheet" type="text/css" href="./css/mystyle.css">
   ```

✅ **CSS 적용 순서:**  
- `<head>` 안에서 선언 순서에 따라 적용됨.  
- 일반적으로 **외부 CSS (`link`)** 를 먼저 선언.

---

## 2. CSS 선택자 (Selectors)

1. **전체 선택자** (`*`)  
   - 모든 요소에 스타일 적용  
   ```css
   * { margin: 0; padding: 0; }
   ```

2. **태그 선택자**  
   - 특정 태그에 스타일 적용  
   ```css
   h1 { color: blue; }
   ```

3. **클래스 선택자** (`.`)  
   - 여러 요소에 동일한 스타일 적용 가능  
   ```css
   .highlight { color: red; font-weight: bold; }
   ```

4. **아이디 선택자** (`#`)  
   - 특정 요소 하나에만 적용  
   ```css
   #main-title { font-size: 24px; }
   ```

5. **자식 선택자 (`>`)**  
   - **직접적인 자식 요소**에만 스타일 적용  
   ```css
   div > p { color: green; }
   ```

6. **자손 선택자 (` `)**  
   - 특정 요소 내부의 모든 해당 태그에 적용  
   ```css
   div p { color: green; }
   ```

7. **인접 형제 선택자 (`+`)**  
   - 바로 다음 형제 요소에만 스타일 적용  
   ```css
   h1 + p { font-size: 18px; }
   ```

8. **일반 형제 선택자 (`~`)**  
   - 특정 요소의 **모든 형제 요소**에 스타일 적용  
   ```css
   h1 ~ p { color: gray; }
   ```

---

## 3. CSS 배경 속성 (Background)

```css
body {
  background-image: url(./images/moon.jpg);
  background-size: 500px 300px;
  background-repeat: no-repeat;
  background-position: top center;
  background-attachment: fixed;
}
```

- `background-image` : 배경 이미지 설정  
- `background-size` :  
  - `cover` : 요소 전체를 덮도록 조정 (잘릴 수 있음)  
  - `contain` : 요소 내부에 맞춤 (여백이 생길 수 있음)  
- `background-repeat` : 반복 여부 (`no-repeat`, `repeat-x`, `repeat-y`)  
- `background-position` : 배경 위치 (`top center`, `bottom right` 등)  
- `background-attachment` :  
  - `fixed` : 스크롤해도 배경 고정  
  - `scroll` : 배경도 함께 스크롤  

---

## 4. 테두리 (`border`) 속성

```css
div {
  border: 1px solid black;
  border-radius: 10px;
}
```

- `border-style` : `solid`, `dashed`, `dotted`, `double`  
- `border-width` : 테두리 두께 (`thin`, `medium`, `thick`)  
- `border-color` : 테두리 색상  
- `border-radius` : 테두리 둥글게 만들기  

---

## 5. 여백 (`margin` & `padding`)

```css
div {
  margin: 10px 20px 30px 40px;  /* 위, 오른쪽, 아래, 왼쪽 */
  padding: 5px 10px;  /* 위아래 5px, 좌우 10px */
}
```

✅ `margin`: 요소 **바깥 여백**  
✅ `padding`: 요소 **안쪽 여백**

| 속성 | 설명 |
|------|------|
| `margin: 10px;` | 네 방향 모두 10px |
| `margin: 10px 20px;` | 상하 10px, 좌우 20px |
| `padding: 5px 10px 20px 30px;` | 상 5px, 우 10px, 하 20px, 좌 30px |

---

## 6. 박스 모델 예제

```css
.box {
  width: 200px;
  padding: 20px;
  margin: auto;
  border: 1px solid black;
  background-color: brown;
  color: white;
  text-align: center;
}
```

```html
<div class="box">This is a box</div>
```

✅ `width` : 박스의 가로 크기  
✅ `margin: auto` : 박스를 중앙 정렬  
✅ `text-align: center;` : 텍스트 가운데 정렬  

---
## 7. 여백 (`margin` & `padding`)

```css
div {
  margin: 10px 20px 30px 40px;  /* 위, 오른쪽, 아래, 왼쪽 */
  padding: 5px 10px;  /* 위아래 5px, 좌우 10px */
}
```

✅ `margin`: 요소 **바깥 여백**  
✅ `padding`: 요소 **안쪽 여백**

| 속성 | 설명 |
|------|------|
| `margin: 10px;` | 네 방향 모두 10px |
| `margin: 10px 20px;` | 상하 10px, 좌우 20px |
| `padding: 5px 10px 20px 30px;` | 상 5px, 우 10px, 하 20px, 좌 30px |

---

## 8. 박스 모델 예제

```css
.box {
  width: 200px;
  padding: 20px;
  margin: auto;
  border: 1px solid black;
  background-color: brown;
  color: white;
  text-align: center;
}
```

```html
<div class="box">This is a box</div>
```

✅ `width` : 박스의 가로 크기  
✅ `margin: auto` : 박스를 중앙 정렬  
✅ `text-align: center;` : 텍스트 가운데 정렬  

---

## 9. 리스트 스타일 (`list-style`)

```css
ul {
  list-style-type: square;
  list-style-position: inside;
  background-color: aquamarine;
}
ul li {
  background-color: blueviolet;
}
```

```html
<ul>
  <li>영화</li>
  <li>음악</li>
  <li>독서</li>
</ul>
```

✅ `list-style-type`: 목록 모양 (`circle`, `disc`, `square`, `none`)  
✅ `list-style-position`: 목록 기호의 위치 (`inside`, `outside`)  

---

## 10. 텍스트 정렬 (`text-align`, `text-decoration`)

```css
.cls-left {
  text-align: left;
  text-decoration: line-through;
}
.cls-center {
  text-align: center;
  text-decoration: underline;
}
.cls-right {
  text-align: right;
}
```

```html
<h2 class="cls-left">Left</h2>
<h2 class="cls-center">Center</h2>
<h2 class="cls-right">Right</h2>
```

✅ `text-align`: `left`, `center`, `right`  
✅ `text-decoration`: `underline`, `line-through`, `overline`  

---
