# 2025/04/03

## 1. 주소를 통해 원하는 데이터 선택

```java
@RequestMapping("/reply")
@GetMapping(
  value = "/{rno}",
  produces = {
    MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_VALUE
  }
)
```

- 위와 같은 컨트롤러로 데이터를 보낼 경우, XML이 아닌 JSON 데이터를 받고자 하면 다음과 같은 주소로 보내면 됨  
→ `fetch('/reply/' + rno + '.json')`

---

## 2. HTTP 요청 설정 객체

- `fetch` 사용 시 `method` 형식을 지정하지 않으면 기본적으로 GET 방식으로 전송됨
- 다음과 같이 필요한 속성만 작성 가능:

```javascript
{ method: 'delete' }
```

---

## 3. 문자열 포맷 (JavaScript)

```javascript
문자열.padStart(2, "0");
```

- 문자열 길이가 2보다 짧으면 앞에 `"0"`으로 채움
- 2보다 길면 그대로 반환

---

## 4. `closest()` 사용법 (JavaScript)

```javascript
inputReplydate.closest("div");
```

- 내 부모 중 가장 가까운 `div` 반환

---

## 5. 태그 객체 class 속성 변경

```javascript
태그객체.classList.add('hide');
태그객체.classList.remove('hide');
```

- `classList.add()` : class 속성 목록에 `hide` 추가  
- `classList.remove()` : class 속성 목록에서 `hide` 제거

💡 class 속성에는 여러 값이 들어갈 수 있기 때문에, `setAttribute` 방식보다 `classList` 방식이 편리함  
예시:
```html
class="btn btn-sec btn-primary"
```
- 클래스 속성은 `btn`, `btn-sec`, `btn-primary` 세 개가 적용됨

---

## 6. `innerHTML` vs `textContent`

- `innerHTML` : 내부의 모든 HTML 코드 가져옴
- `textContent` : 태그 안의 텍스트만 가져옴

> 다중 태그일 경우:
```javascript
요소.textContent.firstChild.trim()
```
- 원하는 대상의 데이터만 추출 가능

---

## 7. AOP (Aspect-Oriented Programming)

- 비즈니스 코드, 자바 레벨에서의 흐름 중 특정 시점에 실행되도록 하는 역할  
- 필터(Filter)와 비슷한 개념
