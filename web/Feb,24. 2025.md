# 2025/02/24

## 1. 선택자 (Selectors)

### 1.1 E:nth-child(n)
- 특정 부모 요소의 자식 중 n번째 요소를 선택

### 1.2 E:nth-child(odd)
- 부모 요소의 자식 중 홀수 번째 요소를 선택

### 1.3 E:nth-child(even)
- 부모 요소의 자식 중 짝수 번째 요소를 선택

### 1.4 E:nth-child(an+b)
- 특정 패턴을 가진 요소를 선택 (b번째부터 a 단위 요소)

### 1.5 E:nth-of-type(n)
- 특정 타입(E)의 요소 중에서 n번째 요소를 선택

#### 예제 코드
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>nth-child 선택자</title>
  <style>
    body p:nth-child(2){
      color: red;
    }
    body p:nth-of-type(2n){
      font-weight: 900;
    }
    body p:nth-of-type(odd){
      background-color: aquamarine;
    }
  </style>
</head>
<body>
  <div>이 곳은 div</div>
  <p>이 곳은 첫 번째</p>
  <p>이 곳은 두 번째</p>
  <p>이 곳은 세 번째</p>
  <p>이 곳은 네 번째</p>
  <div>이 곳은 두 번째 div</div>
</body>
</html>
```

---

## 2. a 태그 가상클래스

### 2.1 `a:link`
- 방문하기 전 상태

### 2.2 `a:visited`
- 방문한 적이 있는 경우 (쿠키 삭제 시 초기화됨)

### 2.3 `a:hover`
- 마우스를 올려놓았을 때

### 2.4 `a:active`
- 클릭하는 순간의 상태

---

## 3. Flexbox 레이아웃

### 3.1 특징
- 부모 컨테이너를 `display: flex;`로 설정하여 사용
- 레이아웃 배치를 위한 전용 속성 제공

### 3.2 주요 속성

#### 방향 지정 (`flex-direction`)
- `row` (기본값): 좌 → 우 정렬
- `column`: 상 → 하 정렬
- `row-reverse`: 우 → 좌 정렬
- `column-reverse`: 하 → 상 정렬

#### 줄 넘김 처리 (`flex-wrap`)
- `nowrap` (기본값): 줄 바꿈 없음
- `wrap`: 줄 바꿈 허용
- `wrap-reverse`: 줄 바꿈을 역방향으로

#### 정렬 (`justify-content`)
- `flex-start`: 좌측 정렬 (기본값)
- `flex-end`: 우측 정렬
- `center`: 중앙 정렬
- `space-between`: 요소 간격 균일 배치 (양쪽 끝 요소 포함)
- `space-around`: 요소 간 간격 균일 배치 (양쪽 끝 포함하지 않음)

#### 예제 코드
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flexbox</title>
    <style>
        .container{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: center;
            background-color: pink;
            padding: 20px;
        }
        .item{
            width: 25%;
            height: 100px;
            border: 1px solid black;
            background-color: gray;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="item">Box1</div>
        <div class="item">Box2</div>
        <div class="item">Box3</div>
        <div class="item">Box4</div>
    </div>
</body>
</html>
```

---

## 4. CSS Grid 레이아웃

### 4.1 특징
- `display: grid;`을 사용하여 레이아웃을 생성
- 행과 열을 나누어 아이템 배치 가능

### 4.2 주요 속성

#### 열 배치 (`grid-template-columns`)
- `grid-template-columns: repeat(4, 1fr);` → 4개의 동일한 너비 열 생성
- `grid-template-columns: 100px 200px auto;` → 3개의 다른 크기의 열 생성

#### 행 배치 (`grid-template-rows`)
- `grid-template-rows: repeat(3, 1fr);` → 3개의 동일한 높이 행 생성
- `grid-template-rows: 200px 1fr;` → 1행 200px, 2행은 남은 공간 차지

#### 간격 조정 (`gap`)
- `row-gap: 10px;` → 행 간격 설정
- `column-gap: 20px;` → 열 간격 설정
- `gap: 10px 20px;` → 행과 열의 간격을 각각 지정

#### 예제 코드
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS Grid</title>
    <style>
        .container{
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-template-rows: repeat(3, 100px);
            gap: 10px;
            background-color: pink;
            padding: 20px;
        }
        .item{
            border: 1px solid black;
            background-color: gray;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
      <div class="item">A</div>
      <div class="item">B</div>
      <div class="item">C</div>
      <div class="item">D</div>
      <div class="item">E</div>
      <div class="item">F</div>
      <div class="item">G</div>
      <div class="item">H</div>
      <div class="item">I</div>
    </div>
</body>
</html>
```
## 5. table css

### 설명
- `table` 태그를 스타일링할 때 사용하는 CSS 속성들을 학습함.
- `border-collapse: collapse;`를 사용하여 표의 이중선을 단일선으로 만듦.
- `th`, `td` 선택자를 동시에 지정하여 테이블의 셀 스타일을 통합 적용.
- `vertical-align` 속성을 이용하여 텍스트의 수직 정렬을 설정.
- `text-align: center;`로 내용을 중앙 정렬.

### 예제 코드

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Table Example</title>
  <style>
     table {
      border: 1px solid black;
      border-collapse: collapse;
      font-size: 1.5rem;
      width: 400px;
      margin: 30px;
     }
     th, td {
      border: 1px solid black;
      padding: 40px 0;
      vertical-align: middle;
     }
     td {
      text-align: center;
     }
  </style>
</head>
<body>
  <table>
    <thead>
      <tr>
        <th>이름</th>
        <th>나이</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>김씨</td>
        <td>10</td>
      </tr>
      <tr>
        <td>이씨</td>
        <td>20</td>
      </tr>
      <tr>
        <td>박씨</td>
        <td>30</td>
      </tr>
    </tbody>
  </table>
</body>
</html>
```

---

## 6. transform

### 설명
- `transform` 속성을 이용한 다양한 변형(회전, 이동, 크기 조절) 학습.
- `rotate()`, `translate()`, `scale()` 등의 기능을 학습함.
- `transition`을 활용하여 변형 애니메이션을 적용.

### 예제 코드

#### 1. 기본적인 변형 예제

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transform Example</title>
    <style>
        div {
            width: 200px;
            height: 200px;
            background-color: pink;
            margin-left: 100px;
        }
        .rotate_box {
            transform: rotate(10deg);
        }
        .translate_box {
            transform: translate(100px, 100px);
        }
        .scale_box {
            transform: scale(1.2, 1.2);
        }
    </style>
</head>
<body>
    <h1>회전 : rotate</h1>
    <div class="rotate_box"></div>
    <br><br>

    <h1>이동 : translate</h1>
    <div class="translate_box"></div>
    <br><br>

    <h1>크기 : scale</h1>
    <div class="scale_box"></div>
    <br><br>
</body>
</html>
```

#### 2. `transition`을 활용한 애니메이션 효과 적용

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transition Example</title>
    <style>
        div {
            width: 50px;
            height: 50px;
            background-color: dodgerblue;
            transition: width 5s ease 1s;
        }
        div:hover {
            width: 300px;
        }
        div.ex {
            margin: auto;
            width: 100px;
            height: 100px;
            background-color: teal;
            transition: transform 3s, background-color 3s;
        }
        div.ex:hover {
            transform: rotate(720deg) scale(3,3);
            background-color: tomato;
        }
    </style>
</head>
<body>
    <h1>transition</h1>
    <div>5초 동안 너비 300px로 커지는 박스</div>
    <br /><br /><br /><br /><br />

    <h1>transform + transition</h1>
    <p>마우스를 대면 곧바로 3초 동안 회전하면서 3배로 커지는 박스</p>
    <div class="ex"></div>
</body>
</html>
```


