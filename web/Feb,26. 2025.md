# 2025/02/26

## 1. 자기 호출 함수
### 1) 정의
- 만들면 바로 호출되는 함수
- 익명 함수를 `()`로 묶는 형태
- 다른 개발자와 충돌을 방지하기 위해 사용

### 2) 예제 코드
```js
(function(a, b){
    console.log(`자기 호출 함수 ${a + b}`);
})(3, 4);
```

---

## 2. 콜백 함수
### 1) 개념
- 함수의 매개변수로 전달되는 함수

### 2) 예제 코드
#### 함수 정의
```js
function callback(){
    console.log('callback 함수 호출');
}
```

#### 또 다른 함수 정의
```js
function callTenTimes(func){
    for(let i = 0; i < 10; i++){
        func();
    }
}
```

#### 호출
```js
callTenTimes(callback);
```
- 바로 호출하는 것이 아니라 `callTenTimes` 안에서 실행되도록 **함수를 인자로 전달**하기 때문에 괄호를 빼고 전달한다.

---

## 3. HTML 요소 변경 및 호출
### 1) 개념
- 태그의 `id`를 통해 요소를 호출하여 변경할 수 있음
- `document.getElementById('태그 id 값')` 이용

### 2) 예제 코드
#### HTML 요소 호출
```html
<body>
    <h1 id="header" style="text-align: center;">??현재시간??</h1>
</body>
<script>
    const header = document.getElementById('header');
</script>
```

#### 요소 내용 변경
```js
header.innerHTML = "나도 몰라";
```

---

## 4. 이벤트 리스너
### 1) 개념
- 특정 이벤트 발생 시 실행될 함수를 정의하는 방법

### 2) 예제 코드
```js
const btn = document.getElementById('btn');
btn.addEventListener('click', function(){
    // 클릭 시 실행할 코드
});
```
- 버튼을 클릭하면 익명 함수가 실행됨

---

## * JavaScript의 조건문
### 1) 개념
- JavaScript에서 변수를 `if` 문 조건에 넣으면 **Falsy** 값이면 `false`, 그렇지 않으면 `true`로 평가됨
- **Falsy 값**: `null, undefined, 0, -0, "", NaN, false`

### 2) 예제 코드
```js
let obj;

if (obj) {
    // obj가 falsy가 아닐 때 실행
}

if (!obj) {
    // obj가 falsy일 때 실행되는 코드
}
```

---

## 5. 클로저 (Closure)
### 1) 개념
- 함수가 함수를 리턴할 때 나타나는 특장점
- 리턴된 내부 함수가 외부 함수의 지역 변수를 **소멸시키지 않고 유지**
- 외부 함수의 실행이 끝나도 내부 함수는 외부 함수의 지역 변수 값 유지 가능

### 2) 예제 코드
```js
function addTwo(){
    let n = 0;
    return function(){
        n += 2;
        return n;
    };
}

// 1번 방식 (변수를 함수에 담아서 리턴 → 값 유지)
const addTwoResult = addTwo();
console.log(addTwoResult()); // 2
console.log(addTwoResult()); // 4
console.log(addTwoResult()); // 6

// 2번 방식 (매번 새로운 외부 함수 호출 → 값 초기화)
console.log(addTwo()()); // 2
console.log(addTwo()()); // 2
console.log(addTwo()()); // 2
```
### 3) 개념 정리
- **1번 방식**처럼 변수를 함수 내부에서 유지하면 **클로저를 활용하여 상태를 기억할 수 있음**
- **2번 방식**은 매번 외부 함수를 새로 호출하기 때문에 **지역 변수가 초기화됨**

---
## 6. 배열

### 1) 개념
- 이름과 인덱스로 참조되는 정렬된 값의 집합
- 여러 형태의 데이터를 각각 저장할 수 있고, 저장된 배열의 위치를 가리키는 숫자를 인덱스라고 한다.

### 2) 배열의 특징
1. 대괄호(`[]`)로 데이터를 묶어서 저장
2. 데이터 구분은 쉼표(`,`)로 한다.
3. **같은 배열에 있는 각 데이터들의 타입이 다를 수 있다.**
4. 인덱스에 값이 비어있을 수 있다. (*empty*)

### 3) 배열 생성
```js
let arr1 = [1,2,3,4,5];
let arr2 = new Array(1,2,3,4,5);
```

### 4) 배열 타입 확인
```js
console.log(`arr1의 타입 : ${typeof arr1}`);
console.log(`arr1의 타입 : ${typeof arr2}`);
```

### 5) 배열 내용 확인
```js
console.log(`arr1의 내용 : ${arr1}`);
console.log(`arr2의 내용 : ${arr2}`);
```

### 6) 배열의 인덱스 참조
```js
console.log(arr1[0]);
console.log(arr1[1]);
```

### 7) 배열의 길이 확인
```js
console.log(arr1.length);
```

### 8) `for-in` / `for-of` 반복문
```js
for(let i in arr){
    // `for-in` 문은 index를 받아옴
    console.log(arr[i]);
}
for(let i of arr){
    console.log(i);
}
```

### 9) 존재하지 않는 인덱스 사용
```js
let lastArr = [1,2,3,4,5];
lastArr[5] = 6;
console.log(lastArr);

lastArr[7] = 7;
console.log(lastArr);
// 6번 인덱스는 empty
```

---

## 6-1. 배열 내장 함수

### 1) `push()` - 배열 마지막에 값 추가
```js
const arr = [1,5,3,4,2];
arr.push(6);
console.log(arr);
console.log(`${arr}`);
```

### 2) `pop()` - 배열 마지막 요소 삭제
```js
arr.pop();
console.log(arr);
```

### 3) `unshift()` - 배열 첫 번째 요소 추가
```js
arr.unshift(0);
console.log(arr);
```

### 4) `shift()` - 배열 첫 번째 요소 삭제
```js
arr.shift();
console.log(arr);
```

### 5) `forEach()` - 반복문 대체
```js
const animals = ['dog','cat','bird','eagle'];
animals.forEach(function(animal){
    console.log(animal);
});
console.log('=================');
animals.forEach(animal => {
    console.log(animal);
});
```

### 6) `map()` - 배열 요소 변경
```js
let arr2 = [1,5,3,4,2];
let resultArr1 = arr2.map(n => n * n);
console.log(resultArr1);

// 배열 내 요소들의 제곱을 구해 구분자를 가지는 문자열로 저장
resultArr1 = arr2.map(n => n * n).join('-');
console.log(resultArr1);
```

### 7) `indexOf()` - 특정 요소 위치 찾기
```js
console.log(animals.indexOf('cat'));
```

### 8) `findIndex()` - 객체 배열 요소 찾기
```js
const people = [
    { name : '김', age : 30, married : true },
    { name : '이', age : 40, married : false },
    { name : '박', age : 50, married : true }
];
const result2 = people.findIndex(person => person.name === '박');
console.log(result2);
```

### 9) `filter()` - 특정 조건 요소 필터링
```js
const result3 = people.filter(person => !person.married); // 결혼 안 한 사람들만
const result4 = people.filter(person => person.married);  // 결혼 한 사람들만
console.log(result3);
console.log(result4);
```

### 10) `splice()` - 배열 요소 삭제
```js
arr2 = [1,5,3,4,2];
console.log('=================');
arr2.splice(arr2.indexOf(3),2);
console.log(arr2); // 결과 3,4 삭제
```

### 11) `slice()` - 배열 요소 추출
```js
const resultSlice = arr2.slice(1,3);
console.log(arr2);
console.log(resultSlice);
```

### 12) `sort()` - 배열 정렬
```js
// 12-1 오름차순
arr2 = [1,5,3,4,2];
arr2.sort();
console.log(arr2);

// 12-2 내림차순
arr2.sort((a,b)=>b-a);
console.log(arr2);
```

---
## 7. 객체 (Object)

### 1) 개념
- JavaScript에서 **기본 타입(Primitive Type)을 제외한 모든 데이터 타입**이 객체이다.
- **객체는 키(key)와 값(value)로 구성된 프로퍼티의 집합**이며, 참조할 수 있는 모든 데이터를 저장할 수 있다.
- **프로퍼티의 값이 함수일 경우, 일반 함수와 구분하여 "메소드"라 부른다.**
- 객체를 작성할 때 **중괄호 `{}`** 를 사용한다.
- 객체 지향 프로그래밍의 상속을 구현하기 위해 **"프로토타입"** 을 이용해 객체의 프로퍼티와 메소드를 상속받을 수 있다.
- **생성자(Constructor)를 이용하면 객체를 보다 편하게 생성**할 수도 있다.

---

### 2) 객체 생성 방법

#### **형식**
```js
let 객체명 = { 속성: 값, 속성: 값 };
```

#### **예제**
```js
const obj = {
  name: '김씨',
  age: 20,
  company: 'none'
};
```

---

### 3) 객체 속성 접근 방법

#### **1. 마침표 표기법**
```js
console.log(obj.name); // '김씨'
```

#### **2. 대괄호 표기법**
```js
console.log(obj['name']); // '김씨'
```

---

### 4) 객체 접근 방법

#### **1. 일반 방식**
```js
function printInfo(info) {
  const str = `${info.name}의 나이는 ${info.age}살이고, 직업은 ${info.job}입니다.`;
  console.log(str);
}

printInfo(person1);
```

#### **2. 비구조화 할당 (객체 구조 분해)**

```js
function printInfo2(info) {
  const { name, age, job } = info;
  const str = `${name}의 나이는 ${age}살이고, 직업은 ${job}입니다.`;
  console.log(str);
}

printInfo2(person1);
```

```js
function printInfo3({ name, age, job }) {
  const str = `${name}의 나이는 ${age}살이고, 직업은 ${job}입니다.`;
  console.log(str);
}

printInfo3(person1);
```

---

## 8. 생성자 함수 (Constructor Function)

### 1) 개념
- **객체를 생성하는 함수**로, 동적으로 각각 다른 값을 가진 객체를 만들 때 사용한다.
- 생성자 함수의 **첫 글자는 반드시 대문자로 작성**하는 것이 관례이다.

---

### 2) 생성자 함수 사용 예제

#### **1. 생성자 함수 정의**
```js
function Person(name, age, gender) {
  this.name = name;
  this.age = age;
  this.gender = gender;
}
```

#### **2. 생성자를 이용하여 객체 생성**
```js
let person1 = new Person('김씨', 20, '남');
let person2 = new Person('이씨', 30, '여');
```

---

## 9. 클래스 (Class)

### 1) 개념
- 객체 지향 프로그래밍(OOP)에서 **특정 객체를 생성하기 위해 필드와 메소드를 정의해 놓은 틀**이다.
- **동적으로 여러 객체를 생성하는 것이 목적**이다.
- **클래스를 작성할 때는 대문자로 시작하며, 앞에 `class` 키워드를 사용한다.**

---

### 2) 클래스 사용 예제

#### **1. 기본적인 클래스 정의 및 사용**
```js
class Person {
  constructor(name) {
    this.name = name;
  }
  
  print() {
    console.log(`이름은 ${this.name} 입니다.`);
  }
}

let kim = new Person('김씨');
kim.print(); // 출력: 이름은 김씨 입니다.
```

#### **2. 생성자와 `get`, `set` 활용**
```js
class Human {
  constructor(age) {
    this._age = age;
  }

  set name(name) {
    if (name) {
      this._name = name;
      // this.name = name; (잘못된 방식, 무한 호출 발생 가능)
    }
  }

  get name() {
    return this._name.toUpperCase(); // 대문자로 반환
  }
}

let lee = new Human();
lee.name = 'lee';
console.log(lee.name); // 'LEE'
```