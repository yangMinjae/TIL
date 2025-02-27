# 2025/02/27
# 프로토타입 (Prototype)

## 1. 프로토타입이란?
- 생성자 함수는 프로토타입 프로퍼티를 가지고 있음
- 생성자로부터 생성된 객체는 프로토타입으로부터 프로퍼티와 메소드를 상속받음
- 생성자 함수와 프로토타입은 서로 참조할 수 있음
- 즉, 생성자 함수가 만들어질 때 프로토타입도 함께 생성됨

## 2. 프로토타입 프로퍼티 생성 방법

### 방법 1: 생성자 함수 내부에서 정의
```js
function Person2(name, age){
    this.name = name;
    this.age = age;
    this.__proto__.eyes = 2;
    this.__proto__.nose = 1;
}
```

### 방법 2: 생성자 함수 외부에서 정의
```js
function Person3(name, age){
    this.name = name;
    this.age = age;
}
  
Person3.prototype.eyes = 2;
Person3.prototype.nose = 1;
```

## 3. 프로토타입의 역할
1. **생성자 함수 (프로토타입 없음)**
   - 객체를 생성할 때마다 각각의 프로퍼티들이 생성됨
2. **생성자 함수 (프로토타입 있음)**
   - 생성자 함수 내부에서 프로토타입 프로퍼티를 작성하여 공유 가능
3. **생성자 함수 (외부에서 프로토타입 추가)**
   - 생성자 함수 외부에서 동적으로 프로토타입 프로퍼티 추가 가능

> **목적:**
> - 하나의 생성자를 이용하여 여러 객체를 생성할 경우 공통된 데이터를 매번 생성할 필요 없이 공유 가능
> - 메모리를 절약하고 코드 유지보수를 쉽게 하기 위함

---

# BOM (Browser Object Model)

## 1. BOM이란?
- 자바스크립트에서 브라우저의 기능을 제어할 때 사용하는 객체

### BOM의 주요 객체
1. **window**: 브라우저 내장 객체 중 최상위 객체
2. **history**: 현재 브라우저가 접근했던 URL의 히스토리를 제어하는 객체
3. **location**: 문서의 주소와 관련된 객체
4. **document**: 현재 문서에 대한 정보를 담고 있는 객체

---

## 2. window 객체

### window 객체의 특징
1. 브라우저 내장 객체 중 최상위 객체
2. 모든 전역 객체, 함수, 변수 등은 자동으로 `window` 객체에 속함
3. `window.함수()`, `window.프로퍼티` 형태로 사용 가능
4. `window` 키워드는 생략 가능

#### 예제
```js
window.alert("안녕하세요!"); // alert("안녕하세요!")와 동일
```

### window 객체 생성
```js
window.open(url, name, feature);
```
- **url**: 주소 또는 파일 경로
- **name**: `<a>` 태그의 `target`으로 사용 가능
- **feature**: 크기, 위치 등의 옵션 지정 가능

#### 새 창 만들기 예제
```js
let newWin;
function winOpen(){
    let feature = "width=400, height=300, top=100, left=100, ";
    feature += "menubar=yes, location=yes, scrollbars=yes, resizable=yes";
    newWin = window.open('index.html','',feature);
}

function winClose(){
    newWin.close();
}
```

---

## 3. history 객체
- 브라우저의 앞/뒤 이동을 제어하는 객체
- 입력된 양식이 삭제되지 않고 유지됨

### history 객체 사용 예제
```js
// 뒤로 가기
history.back();

// 앞으로 가기
history.forward();
history.go(1);

// 이전 페이지로 가기
history.go(-1);

// 전전 페이지로 가기
history.go(-2);
```

---

## 4. screen 객체
- 현재 화면에 대한 정보를 담고 있는 객체

### 예제
```js
// 화면의 가로 크기
console.log(screen.width);

// 화면의 세로 크기
console.log(screen.height);

// 화면의 가로 크기 (스크롤 제외)
console.log(screen.availWidth);

// 화면의 세로 크기 (작업 표시줄 제외)
console.log(screen.availHeight);
```

---

## 5. location 객체
- 문서의 주소와 관련된 객체
- `window` 객체 및 `document` 객체의 프로퍼티로 활용 가능

### 주요 프로퍼티
```js
// 현재 실행되는 파일의 전체 경로
console.log(location.href);

// 현재 실행되는 파일의 도메인 주소
console.log(location.hostname);

// 현재 실행되는 파일의 경로
console.log(location.pathname);
```

### 페이지 이동 방법
```js
// 히스토리를 남기고 이동
function moveWin1(){
    location.assign('http://www.google.com');
}

// 히스토리를 남기지 않고 이동
function moveWin2(){
    location.replace('http://www.google.com');
}
```

---

# DOM (Document Object Model)

## 1. 기본 메서드

### 1) 태그 만들기
```js
let headElement = document.createElement('h1'); // 인자는 태그명
```

### 2) 텍스트 노드 만들기
```js
let textNode = document.createTextNode('Hello Javascript');
```

### 3) 태그에 텍스트 노드 추가
```js
headElement.appendChild(textNode);
```

### 4) h1 태그를 body에 추가하기
- 추가하기 위해서는 부모 노드를 알아야 함
```js
document.body.appendChild(headElement);
```

### 예제: 배열 데이터를 이용하여 리스트 작성
#### 방법 1: createElement 사용
```js
const fruits = ['apple', 'banana', 'orange', 'kiwi', 'mango'];
let liElement;
let liTextNode;
let ul = document.getElementById('list');
for(let i in fruits){
    liElement = document.createElement('li');
    liTextNode = document.createTextNode(fruits[i]);
    liElement.appendChild(liTextNode);
    ul.appendChild(liElement);
}
```

#### 방법 2: innerHTML 사용
```js
let ul1 = document.getElementById('list1');
let msg = '';
fruits.forEach(f => {
    msg += '<li>' + f + '</li>';
});
ul1.innerHTML = msg;
```

---

## 2. 태그 속성 추가

### 1) 프로퍼티에 값 추가
```js
요소.프로퍼티 = 값;
```

### 2) setAttribute 함수 사용
```js
요소.setAttribute('속성명', '값');
```

### 예제
```js
// 이미 있는 요소에 속성 추가 (변경)
let imgEle = document.querySelector('#img1');
imgEle.setAttribute('src', "./images/logo.png");

// 새로운 요소를 만들어 추가
let imgElement = document.createElement('img');
imgElement.src = './images/hot.jpg';
imgElement.alt = '아무사진';
imgElement.width = 200;
document.body.appendChild(imgElement);
```

---

## 3. 스타일 변경

### 1) CSS 속성을 그대로 사용하는 경우 (마침표 표기법 사용)
```js
const h1 = document.querySelector('#heading');
h1.style.color = 'red';
h1.style.width = '400px';
h1.style.height = '100px';
h1.style.background = 'pink';
h1.style.border = '1px solid black';
```

### 2) CSS 속성을 camelCase 형식으로 변경하여 사용하는 경우
```js
const box = document.getElementById('box');
box.style.fontFamily = '궁서';
box.style.fontSize = '20px';
box.style.fontWeight = 'bold';
```

### 3) 대괄호 표기법 사용
```js
const pList1 = document.querySelectorAll('p');
pList1.forEach(p => {
    p.style['color'] = 'red';
    p.style['background-color'] = 'yellow';
});
```

---

## 4. 태그 삭제

### 제거 방법: `부모.removeChild(자식);`
#### 예제
```html
<body>
  <h1 id="dom">DOM 삭제</h1>  <!-- 삭제 -->
  <div id="box">
    <p id="p1">첫 번째 문단</p> <!-- 삭제 -->
    <p>두 번째 문단</p>
  </div>
  <button id="btn">버튼 삭제</button>
</body>
```

```js
let box = document.querySelector('#box');
let p1 = document.getElementById('p1');
box.removeChild(p1);

// 버튼 삭제
let btn = document.querySelector('#btn');
btn.addEventListener('click', function(){
    this.remove(); // 화살표 함수는 this를 사용할 수 없음
});
```

---

# 폼 (Form)

- `form` 데이터를 전송하기 전, 스크립트에서 데이터를 가공하거나 검증해야 하는 경우가 있음
- `form` 요소 및 내부 요소들에 접근하여 데이터를 스크립트로 가져올 수 있음

### 폼 요소 접근 방법
1. `id` 속성 접근
2. `class` 속성 접근
3. `name` 속성 접근

### 예제
```js
// .표기법 사용
let id = document.forms.myForm.id;

// [] 표기법 사용
let id = document.forms['myForm']['id'];
```

---


