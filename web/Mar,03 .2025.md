# 2025-03-03 복습

## CSS Part

- 자녀 요소에 `float` 사용 시 문서 흐름에서 벗어나 높이를 인식하지 못하는 문제 발생  
  → 부모 `background` 설정 시, 보이지 않는(높이가 `0px`이 되는) 문제가 발생  
  → `overflow: hidden` 속성을 추가해 해결 가능

- `box-sizing: border-box` 속성을 사용하면, 지정한 넓이가 `padding`과 `border`의 넓이를 포함한 값으로 지정

- `display: flex`를 지정하고 `align-items`, `justify-content`를 `center`로 지정하면 자녀 요소를 가운데 정렬할 수 있다.

- `position: fixed`를 통해 스크롤이 움직여도 요소를 원위치에 고정 가능

### ✅ Pseudo-Class

- `E:nth-child(n)`: `n` 번째 요소 선택  
  ```css
  body p:nth-child(2) 
  ```
  - `body` 아래 두 번째 자식이며 `p` 태그인 개체 선택 (두 번째 자식이 `p` 태그가 아닌 경우 스타일 미적용)  
  → **대안**:  
  ```css
  body p:nth-of-type(2) 
  ```
  - `body` 아래 `p` 태그 중 두 번째 요소에 적용

- `flex-wrap` 속성  
  - `nowrap`: 줄 바꿈 없음  
  - `wrap`: `item`의 크기의 합이 `container` 내부 영역을 넘어서면 줄 바꿈

- `table`의 `border-collapse: collapse` 설정 → 테이블의 구분선이 **이중선이 아닌 단일선**이 되도록 설정

- `table`과 `td` 모두에 `border`를 부여해야 칸들이 구분됨

- `margin: auto;`는 `block` 요소에 대해서만 중앙 정렬 가능

---

## JavaScript Part

### ✅ `!=` vs `!==`

- `!=` → 값이 다르면 `true` 반환
- `!==` → 값이 같아도 타입이 다르면 `true` 반환

### ✅ `prompt()`  
- Java의 `Scanner`처럼 사용자 입력을 받을 수 있음

### ✅ 디폴트 파라미터 (Default Parameter)
```javascript
// ES5 방식
function personInfo(name, age) {
  age = age || 20;
  var result = "내 이름은 " + name + "이고, 나이는 " + age + "살 입니다.";
  console.log(result);
}

// ES6 방식
function personInfo3(name, age = 20) {
  console.log(`내 이름은 ${name}이고, 나이는 ${age}살 입니다.`);
}
```

### ✅ 객체 관련 개념

- 객체의 프로퍼티 호출 시 두 가지 방법 가능  
  ```javascript
  console.log(obj.propertyName); // 점 표기법
  console.log(obj["propertyName"]); // 대괄호 표기법 (따옴표 필요)
  ```

- `Object.entries(객체)` → 키-값 쌍 반환  
- `Object.keys(객체)` → 키만 반환  
- `Object.values(객체)` → 값만 반환  

### ✅ `for-in` 문법
- 배열에서는 **index를 가져옴**  
- 객체에서는 **key를 가져옴**  
```javascript
for (let key in person) {
  console.log(`${key} : ${person[key]}`);
}
```

### ✅ Date 객체 생성
```javascript
let date1 = new Date(2019, 11, 13);  // 연, 월(0부터 시작), 일
let date2 = new Date("2019-11-15");  // 문자열 방식
```

### ✅ Math 관련 함수
```javascript
Math.max(1, 2, 3, 4, 5);  // 가장 큰 숫자 반환
Math.min(1, 2, 3, 4, 5);  // 가장 작은 숫자 반환
Math.round(123.456 * 100) / 100; // 소수점 2자리 반올림
Math.ceil(4.2);  // 올림 → 5
Math.floor(4.9); // 내림 → 4
```

### ✅ `this` 사용법
- **일반 함수**에서 `this` → **객체 자체를 참조**
- **화살표 함수**에서 `this` → **상위 스코프의 `this`를 참조**

```javascript
const person = {
  name: "김씨",
  age: 20,
  func1: function () {
    const func2 = () => {
      console.log(this.name);
    };
    func2();
  },
};

person.func1(); // "김씨" 출력 (func2의 `this`는 person을 가리킴)
```

### ✅ 즉시 실행 함수 (IIFE)
```javascript
(function (a, b) {
  console.log(`즉시 실행 함수: ${a + b}`);
})(3, 4);
```

### ✅ 콜백 함수
```javascript
function process(callback) {
  console.log("작업 시작");
  callback();
}

process(() => console.log("콜백 실행"));
```

### ✅ `IsClassConstructor` 속성
- 일반 함수와 클래스의 생성자를 구분하기 위한 속성  
- **클래스의 생성자는 `new`를 통해서만 호출 가능**  

```javascript
class MyClass {
  constructor() {
    console.log("클래스 생성자 실행");
  }
}

new MyClass(); // ✅ 정상 실행
MyClass(); // ❌ TypeError 발생 (new 없이 호출 불가)
```

### ✅ `window.open()` 함수
```javascript
window.open("https://example.com", "_blank", "width=600, height=400");
```
- 첫 번째 인자: URL  
- 두 번째 인자: `a` 태그의 `target` 속성과 동일  
- 세 번째 인자: 창 크기 및 옵션  

### ✅ `location` 객체
```javascript
location.href; // 현재 페이지 URL
location.hostname; // 도메인만 반환
location.pathname; // 현재 경로 반환

location.assign("https://example.com"); // 새 페이지로 이동 (히스토리 남김)
location.replace("https://example.com"); // 새 페이지로 이동 (히스토리 남기지 않음)
```

### ✅ 이벤트 객체 (Event Object)
```javascript
document.getElementById("btn").addEventListener("click", function (e) {
  console.log(e.target); // 클릭한 실제 요소
  console.log(e.currentTarget); // 이벤트 리스너가 연결된 요소
});
```

