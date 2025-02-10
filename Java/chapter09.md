# chapter 09

### 1. this 키워드

1.1 this란?
- **객체 자신을 가리키는 키워드**.
- 인스턴스의 필드나 메소드를 참조할 때 사용.

1.2 this의 주요 사용처
```java
class Car {
    String model;
    Car(String model) {
        this.model = model;
    }
}
```
