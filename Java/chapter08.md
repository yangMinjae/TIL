# chapter 08

## 생성자 (Constructor)

1.1 생성자란?
- **객체가 생성될 때 자동 호출**되는 특수한 메소드.
- **객체의 필드 초기화** 역할.

1.2 생성자 선언
```java
class Car {
    String model;
    Car(String model) {
        this.model = model;
    }
}
```
