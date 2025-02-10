# chapter 10

### 1. static 키워드

1.1 static이란?
- **클래스에 속하는 고정된 멤버**.
- 객체 생성 없이 사용 가능.

1.2 static 필드와 메소드
```java
class Car {
    static int totalCars;
    static void showCount() {
        System.out.println("총 차량 수: " + totalCars);
    }
}
```
