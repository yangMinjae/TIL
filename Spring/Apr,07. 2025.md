# 2025/04/07

## 1. input file 태그 초기화

- `input file` 태그는 `form.name.value = ''`와 같은 형식으로 데이터를 초기화할 수 없음.
- 대신 **노드 복사 후 교체** 방식 사용:

```javascript
let uploadDiv = document.querySelector('.uploadDiv');
let cloneObj = uploadDiv.firstElementChild.cloneNode(true); // 해당 노드를 복사
uploadDiv.replaceChild(cloneObj.cloneNode(true), uploadDiv.firstElementChild);
```

> 뷰 로드 시점에 빈 input file 태그를 복사해두고, 특정 조건에 `replaceChild`를 통해 초기화 시점에 해당 태그를 덮어씌움  
> - `replaceChild(new, old)` : old를 new로 대체

---

## 2. Resource - `org.springframework.core.io.Resource`

- 파일 다운로드 시 사용
- `ResponseEntity<Resource>` 반환 시 `produces = MediaType.APPLICATION_OCTET_STREAM_VALUE` 지정
- `FileSystemResource`: 실제 파일 시스템의 파일을 스트림으로 응답 가능

---

## 3. @ResponseBody

- 리턴 값을 HTTP 응답 본문(body)에 그대로 담겠다는 의미
- `@RestController`에서는 `@ResponseBody` 생략 가능

---

## 4. 파일 다운로드 컨트롤러

```java
@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
@ResponseBody
public ResponseEntity<Resource> downloadFile(String fileName) {
    log.info("download file..." + fileName);
    Resource resource = new FileSystemResource("C:\upload\" + fileName);
    log.info("resource..." + resource);
    String resourceName = resource.getFilename();
    HttpHeaders headers = new HttpHeaders();

    try {
        headers.add("Content-Disposition", "attach; fileName=" +
            new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
    } catch (Exception e) {
        e.printStackTrace();
    }

    return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
}
```

### 실행 흐름
1. 프론트에서 파일 이름 파라미터 전달
2. `Resource` 구현체 생성으로 파일 접근 준비
3. `resource.getFilename()` 호출
4. `HttpHeaders` 객체 생성
5. `headers.add`를 통해:
   - `"Content-Disposition"` : attach → 브라우저가 다운로드 실행
   - `"fileName"` : 파일 이름 지정
6. 파일 이름 인코딩:
   - `getBytes("utf-8")` → ISO-8859-1로 변환 필요
7. 다운로드 수행

---

## 5. URL 인코드 / 디코드

- 쿼리 스트링에서 한글, 공백, 특수문자 등 인코딩 필요
- JS: `encodeURIComponent(문자열)`
- Java 컨트롤러: `URLDecoder.decode(문자열)`
- 스프링에서는 파라미터 형식이면 자동 디코딩
- 단, HTTP 요청 body는 자동 처리 안 됨

---

## 6. @Param 사용법 (MyBatis)

- 매퍼 인터페이스에서:

```java
@Param("변수명1") int bno, @Param("변수명2") int bno2
```

- 매퍼 XML에서는 다음과 같이 사용가능:

```xml
#{변수명1}, #{변수명2}
```

---

## 7. `<selectKey>` 태그

```xml
<insert id="insertTest" parameterType="">
    <selectKey keyProperty="bno" resultType="int" order="BEFORE">
        select seq_board.nextval from dual
    </selectKey>
    INSERT INTO TBL_BOARD VALUES (
        #{bno},
        #{title},
        #{content},
        #{writer},
        sysdate,
        null,
        0
    )
</insert>
```

- `mapper.xml`에서 VO를 통해 `bno`가 안 들어온 상황
- `selectKey`로 insert 전에 시퀀스 실행
- `keyProperty`: VO의 해당 필드(`bno`)에 쿼리 결과 저장
- 서비스에서는 이후 `vo.getBno()` 가능
