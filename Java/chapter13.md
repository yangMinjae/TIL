# chapter 13

## 접근 제어자 (Access Modifier)

1.1 정보 은닉 (Information Hiding)
- 내부 정보를 숨기고 필요한 정보만 노출.
- **필드**는 숨기고, **생성자와 메소드**는 공개.
- 접근 여부는 **접근 제어자**로 결정.

1.2 접근 제어자의 종류
| 접근 제어자 | 동일 클래스 | 하위 클래스 | 동일 패키지 | 외부 패키지 |
|------------|------------|------------|------------|------------|
| private    | O          | X          | X          | X          |
| default    | O          | X          | O          | X          |
| protected  | O          | O          | O          | X          |
| public     | O          | O          | O          | O          |

- 일반적인 사용법:
  - **필드**: `private`
  - **생성자**: `public`
  - **메소드**: `public`
  
1.3 Getters & Setters
- `private` 필드에 접근하기 위해 사용.
- **Setter**: 값을 설정하는 메소드.
- **Getter**: 값을 가져오는 메소드.

```java
public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

- `boolean` 타입의 Getter는 `is`를 사용.
```java
public boolean isKorean() {
    return isKorean;
}
```

