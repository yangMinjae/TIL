# chapter 06

## 객체 지향 프로그래밍 (OOP)

1.1 OOP란?
- 프로그램을 **객체** 단위로 구성하는 방식.
- 코드 재사용성과 유지보수성을 높일 수 있음.
- **캡슐화, 상속, 다형성**이 주요 특징.

1.2 객체와 클래스
- **객체(Object)**: 상태(필드)와 동작(메소드)을 가짐.
- **클래스(Class)**: 객체를 생성하는 **설계도**.

```java
class Car {
    String model;
    int speed;
    void run() {
        System.out.println(model + "가 달립니다.");
    }
}
```

1.3 객체 생성 및 사용
```java
Car myCar = new Car();
myCar.model = "BMW";
myCar.run();
```
