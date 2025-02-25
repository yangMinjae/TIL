# 2025/02/25

## 1. 개요

### 1) HTML파일에서 자바스크립트를 사용하는 방법
  * script 태그 안에서 자바스크립트 코드 작성
    1) head 태그 안에 script 태그 포함
    2) body 태그 안에 script 태그 포함
        - 어차피 실행시 body 안으로 코드가 들어감. 가독성을 위해 body 아래에 작성
  * 자바 스크립트 코드만 가지고 있는 .js 파일 링크
    1) 자바 스크립트 코드가 있는 위치에서 실행



### 2) 자바스크립트 주석
  1. 한 줄 주석 : //
  2. 여러 줄 주석 : /**/


### 3) 출력 
  1. 경고창
  ``` js
  window.alert('Hello Javascript')
  alert("Hi");
  ```
  
  2. 콘솔
  ``` js
  console.log("Hello!!!");
  ```

  3. 브라우저
  ``` js
  document.write('Hello');
  document.write('<h1>');
  document.write('javascript');
  document.write('</h1>');
  ```

<br>

 * js에서는 쌍따, 홑따옴표 모두 사용가능. 홑따옴표 사용 추천
---

## 2. 변수&상수

### 1) 변수
  변수를 선언할때에 let, var 두 가지
 키워드를 사용할 수 있으나,
 ES6 이후 문법인 let을 주로 사용한다.
  * var
    - ES6 이전에 사용하던 변수 키워드
    - 변수 중복 선언 및 재 할당 가능
    - 변수 선언 전 변수를 참조하면 undefined반환
### 2. 상수
  상수 선언 시 const 키워드 사용
  ```js
  const val2 = 10;
  val2=20;     //에러 발생
  ```


---

## 3. 데이터타입

### 1. 숫자 - 정수 및 실수
  * number
### 2. 문자열 - 텍스트 값 사용
  * ('', "" 사용 가능)
  * string
### 3. 논리형
  * boolean
### 4. null
  * 숫자인지 문자인지는 알지만 값을 모름
  * 주로 값을 받아올때 많이 발생
### 5. undefined;
  * 값 자체를 모름

* 데이터의 타입을 확인하는 방법
  * typeof 데이터
---

### 4. 형변환
#### 📌 문자 → 숫자
- `Number(값)`: 해당 값의 실수 부분까지 모두 변환, 값을 변환하지 못하면 `NaN` 반환
- `parseInt(값)`: 정수 부분만 반환
- `parseFloat(값)`: 실수 부분만 반환

#### 📌 다른 데이터 → 문자열
- `String(값)`: 모든 값을 문자열로 변환
- 문자열 + 값: 변환할 값 앞에 문자열을 두고 `+` 연산자를 이용하여 변경

---

### 5. 연산자
#### 📌 1) 산술 연산자
`+, -, *, /, %, ++, --`

#### 📌 2) 대입 연산자
특정 값을 저장공간에 저장  
```js
let val3 = 1;
val3 = 2;
val3 += 1;
console.log(val3);
```

#### 📌 3) 관계 연산자(비교 연산자)
```js
let a = 1;
let b = '1';
let c = 2;
let d = true;
console.log('==================');
console.log(a == b);  // == 는 값을 비교한다.
console.log(a === b); // === 는 값과 타입을 비교한다.
console.log(a == c);
console.log(a == d);
```

#### 📌 4) 논리 연산자
```js
// &&(and), ||(or), !(not)
// 두 개 이상의 비교 식을 나열할 때
let logVal1 = 1;
let logVal2 = 2;
let logVal3 = 3;
console.log(logVal1 < logVal2);
console.log(logVal1 > logVal2);
console.log(logVal1 < logVal2) && (logVal1 > logVal2);
console.log(logVal1 < logVal2) || (logVal1 > logVal2);
```

---

### 6. 함수
특정 기능을 수행할 수 있는 코드의 집합

#### 📌 함수 형식
```js
function 함수명(매개변수1, 매개변수2){
  실행 코드
  return 반환 데이터;
}
```

#### 📌 1) 선언적 함수
- 이름이 있는 함수 (자바스크립트는 코드를 두 번 읽음)
- 선언적 함수는 정의와 호출 순서가 상관없음

```js
// 선언적 함수 정의
function myFunction(){
  console.log('myFunction 실행');
}
// 선언적 함수 호출
myFunction();
```

#### 📌 2) 표현식 함수
- 이름이 없는 함수 (익명 함수)
- 변수에 저장한 후 호출

```js
// 표현식 함수 정의 + 변수에 저장
let view1 = function(){
  console.log('첫 번째 표현식 함수');
};
```

---

#### 📌 호이스팅 (Hoisting)
자바스크립트 함수가 실행되기 전에 변수 및 함수를 최상단으로 끌어올리는 것  
선언적 함수는 호이스팅 영향을 받지만, 표현식 함수는 영향을 받지 않음

```js
// 선언적 함수는 호이스팅 적용
plus();
minus();

function plus(){}
let minus = function(){};

// 호이스팅 후
function plus(){}
let minus;

plus();
minus();

minus = function(){};
```

---

### 7. 타이머 함수
특정 시간 후 또는 특정 시간마다 함수를 실행하는 기능

#### 📌 주요 함수
1. `setTimeout`: 지정된 시간 후 함수 실행
```js
// 5초 후 "안녕하세요" 경고창 출력
let hello = setTimeout(function(){
  alert("안녕하세요");
}, 5000);
```
2. `clearTimeout`: 해당 `setTimeout` 중지  
3. `setInterval`: 지정된 시간마다 함수 실행  
4. `clearInterval`: 해당 `setInterval` 중지  

```js
// 1초마다 숫자를 1씩 증가시켜 출력
let cnt = 0;
let inc = setInterval(function(){
  console.log(++cnt);
  if(cnt == 10){
    clearInterval(inc);
  }
}, 1000);
```
