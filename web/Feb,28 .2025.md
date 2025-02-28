# 2025/02/28
# JS의 Truthy/Falsy

## 1. Truthy
Boolean 타입은 아니지만 `true`처럼 인식하는 데이터

- `true`
- `{}` - **빈 객체**
- `[]` - **빈 배열**
- `40` - **숫자 (0이 아닌 숫자)**
- `'0'`, `'false'` - **문자열 (비어있지 않은 문자열)**

## 2. Falsy
Boolean 타입은 아니지만 `false`처럼 인식하는 데이터

- `false`
- `0`, `-0`
- `0n` - **BigInt**
- `''`, `""`, ``
- `null`
- `undefined`
- `NaN`

---

# 정규식 활용

```js
const regExp = /^[0-9]+$/;
const target = 10;
```

### 1. `RegExp.test(데이터)` - true/false 반환

```js
if(regExp.test(target)){
  console.log('숫자가 맞습니다.');
}else{
  console.log('숫자가 아닙니다.');
}
```

### 2. `RegExp.exec(데이터)` - 배열 반환 (`null` 가능)

```js
if(regExp.exec(target)){
  console.log('숫자가 맞습니다.');
}else{
  console.log('숫자가 아닙니다.');
}
```

### 3. `문자열.search(정규식)` - 인덱스 반환 (`-1` 반환 가능)

```js
if(String(target).search(regExp) != -1){
  console.log('숫자가 맞습니다.');
}else{
  console.log('숫자가 아닙니다.');
}
```

### 4. `문자열.match(정규식)` - 배열 반환 (`null` 가능)

```js
if(String(target).match(regExp) != null){
  console.log('숫자가 맞습니다.');
}else{
  console.log('숫자가 아닙니다.');
}
```

---

# 이벤트

- 이벤트 함수들은 **비동기 함수**이다.

## 주요 이벤트 종류
1. `onclick` : 객체를 클릭했을 때
2. `onchange` : 객체의 내용이 변경되었을 때
3. `onload` : 객체(문서)가 로딩되었을 때
4. `onmouseover` : 마우스가 객체 위로 올라왔을 때
5. `onmouseout` : 마우스가 객체 바깥으로 나갔을 때
6. `onkeyup` : 키를 눌렀다가 떼었을 때
7. `onkeydown` : 키를 눌렀을 때

## 이벤트 추가 방법

```js
let btn = document.querySelector('button');

// 방법 1: addEventListener 사용
btn.addEventListener('click', function(){
  alert('clicked1');
});

// 방법 2: 직접 이벤트 핸들러 할당
btn.onclick = function(){
  alert('clicked2');
};
```

## `e.target`과 `e.currentTarget` 차이

```html
<div id="click"><span>target</span></div>
```

```js
const click = document.querySelector('#click');
click.addEventListener('click', (e) => {
  alert('실행');
  console.log(this);                 // window 객체
  console.log('target', e.target);   // 실제 클릭한 요소 (span)
  console.log('currentTarget', e.currentTarget); // 이벤트 리스너가 연결된 요소 (div)
});
```

---

# 기본 부여 이벤트 태그

기본적으로 이벤트를 부여하지 않아도 실행되는 경우가 있다.

1. `<a>` 태그의 `href` 속성
2. `<input type="submit">` 등의 기본 동작

### 기본 이벤트를 무시하는 방법

`event.preventDefault()`를 사용하면 기본 동작을 막을 수 있다.

```js
let a = document.querySelector('#a');
a.addEventListener('click', function(e){
  e.preventDefault();
  console.log('a 눌러봄');
});
```

---

# 콜백 함수

## 콜백이 필요한 이유
- 프로그래밍 언어는 원칙적으로 **위에서 아래로 실행**되지만,  
  코드의 특성이나 **비동기 환경**에서는 실행 순서가 달라질 수 있다.
- 특정 함수가 **끝난 후 실행되어야 하는 코드**를 실행할 때 콜백이 필요하다.

### 콜백 예제

```js
const print2 = function(n, callback){
  setTimeout(() => {
    let val = n + 1;
    console.log(val);
    if(val < 5){
      callback(val);
    }
  }, 1000);
};

print2(2, (n) => {
  print2(n, (n) => {
    print2(n, (n) => {
      print2(n, (n) => {
        print2(n, (n) => {});
      });
    });
  });
});
```

이와 같이 콜백 함수가 중첩되는 패턴을 **콜백 지옥 (Callback Hell, 드릴링)**이라고 한다.
