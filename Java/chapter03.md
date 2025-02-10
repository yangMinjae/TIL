# chapter 03

### 1. 타입 변환 (Type Casting)

1.1 타입 변환이란?
- 데이터를 한 타입에서 다른 타입으로 변환하는 과정.
- 자동(묵시적) 변환과 강제(명시적) 변환으로 나뉨.

1.2 자동 타입 변환 (Implicit Casting)
- 작은 크기의 타입에서 큰 크기의 타입으로 변환될 때 자동으로 변환됨.
- `byte → short → int → long → float → double` 순서로 변환 가능.
```java
int num = 10;
double dNum = num; // 자동 변환
```

1.3 강제 타입 변환 (Explicit Casting)
- 큰 크기의 타입을 작은 크기의 타입으로 변환할 때 사용.
- `(타입)`을 명시적으로 지정해야 함.
```java
double dNum = 10.5;
int num = (int) dNum; // 강제 변환, 소수점 이하 버려짐
```

1.4 변환 시 주의점
- 자동 변환은 값 손실이 없음.
- 강제 변환은 값이 잘릴 수 있음.
