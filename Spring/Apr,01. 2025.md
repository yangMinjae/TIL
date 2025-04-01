# 2025/04/01
## 1) 절대경로와 상대경로

* 컨트롤러에서 forward 방식으로 주소를 리턴할 때는 주소 앞에 슬래시가 **있으나 없으나 무조건 절대 경로**로 인식한다.
* redirect 방식일 경우 슬래시가 있으면 **절대경로**, 없으면 **상대경로**로 이동한다.
* 상대경로는 **현재 디렉토리 기준**으로 계산된다.

---

## 2) 이벤트 버블링

`outer`, `middle`, `inner` 상자가 있다고 할 때:

* `outer`에만 클릭 이벤트가 걸려 있어도, `inner`를 클릭하면 이벤트가 버블링되어 `outer` 리스너도 실행된다.
* 이때 `target`은 실제 클릭한 요소 → 예: `inner`
* `currentTarget`은 리스너가 걸려 있는 요소 → 예: `outer`

**버블링(Bubbling)**: 이벤트가 **안쪽 → 바깥쪽**으로 전파되는 현상.

---

## 3) @RequestMapping

```java
@GetMapping({"/get", "/modify"})
```
* 두 경로에 대한 요청을 하나의 컨트롤러 메서드로 처리할 수 있다.
* 반환 타입이 `void`일 경우, 요청 경로와 동일한 뷰 이름으로 포워딩된다.
* 주로 **같은 로직을 공유하는 여러 경로**에서 사용한다.

---

## 4) 폼에서 필요한 데이터만 보내는 방법

```javascript
function remove() {
  let bnoEle = f.bno;     // bno를 담고 있는 input 태그
  f.innerHTML = '';
  f.appendChild(bnoEle);
  f.action = "/board/remove";
  f.submit();
}
```
* form 안의 불필요한 데이터 제거 후, 특정 요소만 다시 append 하여 submit한다.

---

## 5) redirect 방식으로 데이터 전달 (FlashAttribute)

1. 컨트롤러에서 매개변수로 `RedirectAttributes rttr`를 받는다.
2. `rttr.addFlashAttribute("속성명", 값)`으로 데이터 추가
3. 받는 컨트롤러에서는 `@ModelAttribute("속성명") 타입 변수명`으로 받아서 사용
4. 뷰에서도 `${속성명.프로퍼티}` 형태로 접근 가능

---

## 6) @RequestParam

```java
@RequestParam(value = "name", defaultValue = "손님", required = false)
```
| 속성 | 설명 |
|------|------|
| value | 요청 파라미터 이름 |
| defaultValue | 파라미터 없을 때 대체값 |
| required | true면 파라미터 없을 시 400 에러 발생 (기본값: true) |

* `defaultValue`가 있으면 `required=false`처럼 동작하여 에러 없음
* `required=false`만 쓰면 null이 들어올 수 있으므로 주의

---

## 7) 로컬스토리지(localStorage) 사용법

```javascript
function setStorageData(pageNum, amount) {
  let pageData = {
    pageNum: pageNum,
    amount: amount
  };
  localStorage.setItem('page_data', JSON.stringify(pageData));
}

function getStorageData() {
  return JSON.parse(localStorage.getItem('page_data'));
}

// 구조분해 할당 사용 예
let { pageNum, amount } = getStorageData();
```

* localStorage에는 문자열만 저장 가능 → JSON.stringify 필요
* get 시엔 JSON.parse로 객체로 변환
* 구조 분해 할당 일반화 : let{a, b} = 객체 -> 단 a, b가 객체의 프로퍼티 명이어야한다.
---

## 8) REST (Representational State Transfer)

* HTTP 기반의 **분산 시스템을 위한 아키텍처 스타일**
* **비동기 통신**과 자원 중심 설계에 적합
* GET, POST, PUT, DELETE 메서드를 기반으로 함

### 📌 관련 어노테이션

| 어노테이션 | 설명 |
|------------|------|
| `@RestController` | 뷰가 아닌 JSON 등 데이터 응답을 위한 컨트롤러 |
| `@ResponseBody` | 데이터를 그대로 클라이언트에 반환 |
| `@PathVariable` | URL 경로의 값을 변수로 받음 |
| `@RequestBody` | JSON 데이터를 객체로 바인딩 |
| `@CrossOrigin` | CORS (도메인 다를 때) 허용 설정 |
