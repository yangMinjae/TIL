# RestController와 파일 업로드 정리

## 1. ResponseEntity<T>

- RestController의 리턴데이터에 **Http 상태**를 실어 보내기 위한 객체  
- 반환 객체의 타입은 제네릭으로 명기함  
- 객체를 생성하여 사용하거나 아래와 같이 작성함

```java
new ResponseEntity<String>("success", HttpStatus.OK);
```

- 다음과 같은 방식으로 static 메서드를 활용하여 객체 생성 가능

```java
ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
```

- `status`는 HTTP 코드 추가, `body`는 실제 내용을 추가

---

## 2. 파일 업로드 (비동기)

### 1) input 태그를 통해 파일을 받아옴 (JSP View)

```html
<input type="file" name="uploadFile" multiple="multiple">
```

### 2) JS를 통해 비동기 요청을 보냄

```javascript
const uploadBtn = document.querySelector('#uploadBtn');
uploadBtn.addEventListener('click', () => {
  const formData = new FormData();
  const inputFile = document.querySelector('input[type="file"]');
  const files = inputFile.files;
  for (let i = 0; i < files.length; i++) {
    formData.append("uploadFile", files[i]);
  }
  fetch(`/uploadAsyncAction`, {
    method: 'post',
    body: formData
  })
  .then(response => response.json())
  .then(data => {
    console.log(data);
  })
  .catch(err => console.log(err));
});
```

### 🔁 코드 흐름 요약

1. 버튼에 이벤트 부여  
2. `FormData` 객체 생성  
3. `input`에서 파일 배열 가져오기 → `inputFile.files`  
4. `FormData`에 파일 추가  
5. `fetch`로 컨트롤러에 전송

---

### 3) 컨트롤러에서 파일을 받아옴

```java
public ResponseEntity<List<AttachFileDTO>> uploadAsyncPost(MultipartFile[] uploadFile)
```

> 파일을 받을 때 `@RequestBody` 어노테이션은 사용하지 않음

---

### 4) 파일을 업로드 폴더에 저장

- `File` 객체를 만들어 경로 설정  
- `MultipartFile`의 `transferTo(File 객체)` 메서드를 이용하여 파일 저장
