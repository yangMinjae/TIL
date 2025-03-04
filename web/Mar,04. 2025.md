# 2025/03/04
# 프로미스(Promise)

자바스크립트의 비동기 작업을 처리하고, 결과를 다루는 객체  
이전 콜백 함수로 모든 비동기를 처리해야 하는 상황을 편리하게 사용하기 위해  
ES6부터 도입됨.

## 상태
1. **대기(Pending)** - 비동기 작업이 완료되지 않음  
2. **이행(Fulfilled)** - 비동기 작업이 성공적으로 완료됨  
3. **거부(Rejected)** - 비동기 작업이 실패함  

## 프로미스 생성
`new` 키워드를 이용하여 `Promise` 생성자를 호출함.  
호출하면 두 개의 콜백 함수를 파라미터로 받음.

```javascript
const prom = new Promise((resolve, reject) => {
  // 코드
});
```

프로미스 객체가 담긴 `prom`을 호출할 때 성공하면 `then()` 함수를,  
실패했을 때 `catch()` 함수를 붙여서 사용.

### 예제:
```javascript
const prom = new Promise((resolve, reject) => {
  let ran = Math.floor(Math.random() * 10) + 1;
  console.log(ran);
  ran > 5 ? resolve('성공') : reject(new Error('실패'));
});

prom.then(result => {
  console.log(result);
}).catch(err => {
  console.log(err);
});
```

---

# async & await

## async
1. 비동기 처리를 위해 사용하는 문법  
2. `async` 키워드를 함수 앞에 붙임  
3. `async` 함수는 프로미스를 반환하게 됨  
   (일반 데이터를 리턴할 시 프로미스 객체로 감싸짐)  

## await
1. `async` 함수 안에서만 동작 (`일반 함수에서 사용 불가`)  
2. 프로미스의 `then()` 부분을 대신할 수 있음  
3. `await` 키워드를 만나면 프로미스가 끝날 때까지 기다림  

### 예제:
```javascript
async function print() {
  const result = await myProm();
  console.log(result);
}
print();
```

---

# fetch()

서버와 비동기로 데이터를 주고받는 기술로,  
AJAX, Axios와 같은 외부 라이브러리가 아닌 **브라우저 자체 함수**.  
`window` 객체의 프로퍼티로, `window.fetch()`로 사용 가능.  

다양한 데이터 형식을 지원하지만, 기본적으로 **JSON 형식**의 데이터를 주고받을 때 가장 쉽게 사용 가능.

## 형식:
- `url` : 요청할 경로  
- `options` : 요청 방식, 헤더, 내용 등 설정  
- `fetch(url, options).then().then().catch()` 형식으로 사용

### 예제:
```javascript
fetch('https://jsonplaceholder.typicode.com/posts', {
  method: 'POST',
  body: JSON.stringify({
    title: 'foo',
    body: 'bar',
    userId: 1
  }),
  headers: {
    'Content-type': 'application/json; charset=utf-8'
  }
})
.then(response => response.json()) // JSON 변환
.then(json => {
  console.log(json);
  console.log('---');
});
```

---

# jQuery

자바스크립트 라이브러리 중 하나로,  
HTML 문서를 탐색하고 조작하기 쉽게 만들어주는 API를 제공.

## 사용 방법
1. 오프라인에서 `jquery.js` 파일 추가  
2. 온라인 CDN 이용  

## 기본 형식
```javascript
$(선택자).action();
```
1. **`$` 기호** : jQuery를 정의하고 호출  
2. **선택자** : HTML 요소를 찾는 역할  
3. **action()** : 선택된 요소가 수행할 동작  

### 예제:
```html
<p id="pa">아이디 p 태그</p>
<p class="pb">클래스 p 태그</p>
<button id="idBtn">아이디 숨기기 버튼</button>
<button class="classBtn">클래스 숨기기 버튼</button>
<button id="targetBtn">태그 숨기기 버튼</button>

<script>
$('#idBtn').click(function() {
  $('#pa').hide(); // 요소 숨김
});
</script>
```

---

## jQuery 스타일 변경

### 1) 단일 옵션 변경:
```javascript
$('선택자').css('color', 'red');
```

### 2) 다중 옵션 변경:
```javascript
$('선택자').css({
  'font-size': '30px',
  'background-color': 'orange'
});
```

---

## jQuery 배열 활용 (`each` 함수)

다음과 같이 `each()` 함수를 사용하면 `forEach`와 비슷한 역할을 수행함.

```javascript
$.each(배열객체, function(index, item) {
  console.log(`인덱스: ${index}, 요소: ${item}`);
});
```

---

## jQuery 동적 클래스 추가 & 제거

미리 만들어둔 `important` 클래스를 동적으로 버튼 클릭마다 적용/해제 가능.

```javascript
$("#toggle-class").click(function() {
  $("#set-css").toggleClass('important');
});
```

또는 **추가/제거를 따로 처리**할 수도 있음:

```javascript
$("#remove-class").click(function() {
  $("#set-css").removeClass('red');
});
```

---

# jQuery AJAX

비동기적인 JavaScript와 XML을 의미하며, 전체 페이지를 로드하지 않고  
웹 페이지의 일부만 업데이트할 수 있는 데이터 교환 기술.

### 예제:
```javascript
$.ajax({
  type: 'GET', // 요청 메서드 방식
  url: 'https://jsonplaceholder.typicode.com/posts', // 요청 경로
  data: JSON.stringify({
    title: 'foo',
    body: 'bar',
    userId: 1
  }),
  dataType: 'json', // 응답 데이터 타입
  success: function(result) {
    result.forEach(element => {
      console.log(element);
    });
  },
  error: function(err) {
    console.log(err);
  }
});
```
