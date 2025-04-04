# 18장 스프링 AOP 및 파일 업로드 정리 (Spring AOP & File Upload)

## 1. `root-context.xml`

### 1.1 `<context:annotation-config>`
- 스프링에서 애너테이션 기반의 의존성 주입을 활성화함
- 주로 `@Autowired`, `@Resource`, `@PostConstruct`, `@PreDestroy` 등의 표준 애너테이션을 처리할 수 있게 해줌

### 1.2 `<aop:aspectj-autoproxy>`
- AspectJ 스타일의 AOP를 사용할 때 자동으로 프록시를 생성하도록 설정
- 주로 `@Aspect`, `@Before`, `@After`, `@Around` 애너테이션 사용 시 적용

---

## 2. AOP 관련 애너테이션

### 2.1 `@AfterThrowing`
```java
@AfterThrowing(
    pointcut = "execution(* org.joonzis.service.SampleService*.*(..))",
    throwing = "exception"
)
```
- `pointcut`: `AfterThrowing`이 적용될 대상 메서드 지정
- `throwing`: 예외 객체를 해당 이름의 매개변수로 전달
- 실행 메서드의 매개변수 이름과 동일해야 함

### 2.2 `args` 속성
```java
execution(* org.joonzis.service.SampleService*.doAdd(String, String)) && args(str1, str2)
```
- `args`: 메서드에서 전달받은 인자를 AOP에서 참조할 수 있게 해줌
- 인자명은 실제 메서드 매개변수 이름과 같아야 함

---

## 3. 트랜잭션 처리

### 3.1 `@Transactional`
- 클래스 또는 메서드 위에서 사용
- 해당 메서드에서 실행되는 DB 쿼리들이 하나의 트랜잭션으로 묶임
- 하나라도 실패 시 전체 롤백
- 클래스 위에 사용 시: 클래스 내 모든 `public` 메서드에 적용
- 메서드 위에 사용 시: 해당 메서드에만 적용

---

## 4. 파일 업로드 & 다운로드

### 4.1 JSP 폼
```html
<form action="uploadFormAction" method="post" enctype="multipart/form-data">
  <input type="file" name="uploadFile" multiple="multiple">
</form>
```
- `method="post"` 고정
- `enctype="multipart/form-data"` 필요
- `multiple="multiple"`: 여러 파일 업로드 허용

### 4.2 자바스크립트에서 FormData 사용 예
```javascript
for (let i = 0; i < files.length; i++) {
  formData.append("uploadFile", files[i]);
}
```
- 동일한 이름으로 `append`해도 덮어쓰기 되지 않음
- `multiple` 속성과 함께 동작

---

## 5. 파일 처리 관련 클래스 및 메서드

### 5.1 `File` 객체
```java
File saveFile = new File(uploadFolder, uploadFileName);
```
- 실제 파일이 아닌 파일 경로를 나타냄
- `uploadFolder`: 저장할 폴더 경로
- `uploadFileName`: 파일명

### 5.2 `MultipartFile.transferTo(File)`
```java
multipartFile.transferTo(File객체);
```
- 업로드된 파일을 지정된 경로의 파일로 저장

---

## 6. `MultipartFile` 주요 메서드

| 메서드 | 설명 |
|--------|------|
| `getOriginalFilename()` | 원본 파일명 반환 |
| `getSize()` | 파일 크기 반환 (바이트) |
| `transferTo(File)` | 파일 저장 수행 |

---

## 7. 경로 구분자 (`File.separator`)
- 예: Windows 기준 `\`
```java
String path = "upload" + File.separator + "2025" + File.separator + "04" + File.separator + "04";
File dir = new File(path);
dir.mkdirs(); // 해당 경로의 디렉토리를 모두 생성
```
