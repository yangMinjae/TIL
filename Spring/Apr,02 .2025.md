# 2025/04/02
# 1. @RestController
- RestController는 컨트롤러와 달리 데이터를 리턴
- 비동기에서 사용
## 1) @GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")

- produces = "text/plain; charset=utf-8" 의미는 함수가 리턴하는 값이 주소가 아닌 문자열임을 나타냄  
- 클라이언트가 브라우저일 경우, produces를 명시하지 않으면 브라우저가 HTML로 오해하고 뷰 이름으로 처리할 수 있음  

```java
@GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")
public String getText() {
    return "hello";
}
```

---

## 2) @GetMapping(value = "/getObject", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })

- 클라이언트가 JSON을 원하면 JSON으로 응답 주고  
- 클라이언트가 XML을 원하면 XML로 응답  
- 기본은 xml이고, json 형식을 원하면 `~~~/getObject.json`처럼 뒤에 `.json`을 붙이면 json 형식으로 출력  
- 파라미터가 있을 경우에는 다음과 같이 입력 `/getObject.json?age=15`  
- Accept 헤더에 따라 응답 형식이 결정됨 (MIME 타입: `application/json`, `application/xml`)  

---

## 3) TestVO를 리턴하고 싶은데, 조건에 따라 HTTP 에러를 발생시키고 싶을 경우 다음과 같이 ResponseEntity를 이용한다.

```java
@GetMapping(value = "/check")
public ResponseEntity<TestVO> check(double age) {
    ResponseEntity<TestVO> result = null;
    TestVO vo = new TestVO(0,""+age);
    if(age > 150) {
        result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
    } else {
        result = ResponseEntity.status(HttpStatus.OK).body(vo);
    }
    return result;
}
```

- 150 이상의 age를 입력하면 502 에러 발생시킴  
- ResponseEntity는 HTTP 상태 코드 + 데이터(response body)를 함께 구성할 수 있음  

---

## 4) @PathVariable

```java
@GetMapping("/product/{cat}/{pid}")
public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
    return new String[] {"category: " + cat, "productId : " + pid};
}
```

- @RequestParam과 비슷한 역할  
- 주소를 기존의 쿼리스트링 형식이 아닌 `/product/샴고양이/1141` 같은 방식으로 사용할 수 있다  
- RESTful URL 구성 시 자주 사용됨  

---

## 5) @RequestBody

```java
@PostMapping("ticket")
public Ticket convert(@RequestBody Ticket t) {
    log.info("convert...ticket : " + t);
    return t;
}
```

- 이 어노테이션은 HTTP 요청 설정 객체(fetch 설정 객체)의 body 부분 데이터를 가져와 t의 멤버에 자동 매핑하는 역할  
- 요청 본문이 JSON이라면 Jackson 등의 라이브러리에 의해 객체로 변환됨  

### *HTTP 요청 설정 객체(fetch 설정 객체)*
- 다음과 같은 형식의 객체
- fetch 방식의 비동기 통신에 이용된다.

```javascript
{
  method : 'post',
  body : JSON.stringify({
    tno : 1,
    owner : 'kim',
    grade : 'gold'
  }),
  headers : {
    'Content-type' : 'application/json; charset=UTF-8'
  }
}
```

---

## 6) @RequestMapping의 consumes 속성

```java
@PostMapping(
  value="/new", 
  consumes = "application/json",
  produces = MediaType.TEXT_PLAIN_VALUE
)
```

- consumes는 수신되는 데이터의 포맷을 의미한다  
- 서버가 해당 형식의 Content-Type만 수용하도록 제한할 수 있음  
- produces는 응답 데이터의 형식 지정 (plain text, JSON 등)  

---

## 🔧 JS 모듈패턴 (자기 호출 익명 함수)

```javascript
const replyService = function(){
  let prvVar = 0;
  function add(callback){
    prvVar++;
    callback(prvVar);
  }

  return {
    add : add,
  };
}();

const rs = replyService;
rs.add(function(data){
  console.log(data);
});
```

- 기능별로 묶어 모듈화가 가능하다.  
- 내부의 민감한 변수들을 외부에 숨길 수 있다.  
  → (익명함수 전역변수 `prvVar`)는 외부에서 접근이 불가능  
- 클로저 기능을 이용 가능  
  → `prvVar`의 값은 `add`가 호출될 때 마다 증가한다.

---

### ① IIFE (Immediately Invoked Function Expression) 구조
- `function(){ ... }()` 형태로 함수가 **선언되자마자 바로 실행되는 구조**
- 이 덕분에 내부 스코프를 하나 만들고, **외부에 필요한 값만 리턴**할 수 있음

### ② 클로저에 의해 prvVar 값이 살아 있음
- `add()` 함수는 `prvVar`이 선언된 렉시컬 환경을 **기억하고 있어서**
- 함수가 몇 번 호출되든 `prvVar` 값이 계속 유지됨

### ③ 외부 접근 불가 → 정보 은닉 (Encapsulation)
- `prvVar`는 외부에서 `console.log(rs.prvVar)`처럼 **접근하려 해도 undefined**
- 실제로 `private` 키워드 없이도 private 변수처럼 사용할 수 있는 방식

### ④ 모듈화로 코드 정리 가능
- 여러 함수 (`add`, `getList`, `remove`, 등)를 모듈 내부에 정의하고,
- `return`으로 필요한 함수만 외부에 공개하면 관리가 쉬움

### ⑤ 객체로도 만들 수 있지만, 클로저 활용은 불가능
```javascript
// 아래와 같은 방식은 클로저에 의한 은닉은 불가능
const replyService = {
  prvVar: 0,
  add(callback) {
    this.prvVar++;
    callback(this.prvVar);
  }
};
```
- 이 경우 `replyService.prvVar`로 외부에서 직접 접근 가능 → 보안 측면에서 취약
