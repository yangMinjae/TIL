# 2025/03/31
## 1. root-context 의존성 주입

### 🔹 Mapper 스캔 설정

```xml
<mybatis-spring:scan base-package="org.joonzis.mapper"/>
```

- 해당 패키지 내 **모든 인터페이스**를 스캔하여 Bean으로 등록
- 단, 스캔 대상 인터페이스는 반드시 **mapper.xml에 등록**돼 있어야 함  
  (즉, namespace와 id가 일치하는 쿼리가 있어야 함)

### 🔹 컴포넌트 스캔 설정과 구분

```xml
<context:component-scan base-package="org.joonzis.DI_3_component"/>
```

- 이 설정은 `@Component`, `@Service`, `@Repository`, `@Controller`가 붙은 **클래스들**만 Bean으로 등록
- 클래스 기반 의존성 주입용

---

## 2. @Service 어노테이션

- 해당 클래스가 **Service 역할**임을 나타냄
- 스프링이 자동으로 객체를 생성해서 **스프링 빈으로 등록**

### 🔹 사용 예시

```java
@Service
public class BoardServiceImpl implements BoardService {
    ...
}
```

### 🔹 Bean 등록을 위해 context 설정 필요

```xml
<context:component-scan base-package="org.joonzis.service"/>
```

- 해당 패키지에 있는 클래스들 중 `@Service`가 붙은 클래스들을 Bean으로 등록

---

## 3. Mapper 인터페이스 (= dynamic web project의 DAO)

### 🔹 작성 순서

1. **인터페이스와 메서드 작성**  
   - 메서드 이름은 **mapper.xml의 쿼리 id 속성과 일치**해야 함

2. **mapper.xml에 namespace 작성**

```xml
<mapper namespace="org.joonzis.mapper.BoardMapper">
```

3. **mapper.xml에 쿼리 작성**

```xml
<select id="getList" resultType="BoardVO">
  SELECT * FROM board
</select>
```

4. **root-context.xml에 Mapper 스캔 설정**

```xml
<mybatis-spring:scan base-package="org.joonzis.mapper"/>
```

- 해당 패키지의 모든 인터페이스가 자동으로 Bean 등록됨

---

## 4. 클래스 단위의 @RequestMapping 설정

```java
@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list...");
        model.addAttribute("list", service.getList());
    }
}
```

- 클래스 단위로 공통 경로 지정 가능 (`@RequestMapping("/board/*")`)
- 하위 메서드에서는 `@GetMapping("/list")`처럼 세부 경로 설정
- 실제 요청 주소는 `/board/list`
- `return`에서 `/board`를 생략하는 건 불가능

---

## 5. redirect 방식

```java
return "redirect:/board/modify";
```

- 명시적으로 `redirect:`를 붙이면 **리다이렉트 방식**
- 기본은 `forward`

---

## 6. location.href는 기본적으로 GET 방식

```javascript
location.href = "/board/list";
```

- 서버에 **GET 방식**으로 요청을 보냄 (폼 제출 X, 단순 URL 이동)

---

## 7. JS에서 CSS 파일 동적 추가

```javascript
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/boardList.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);
```

- 자바스크립트로 **CSS를 동적으로 적용**할 수 있는 방법
