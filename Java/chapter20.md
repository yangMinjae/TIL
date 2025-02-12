# chapter 20

## 1. 제네릭 (Generic)

### 1.1 제네릭 개요
- Java 5부터 추가된 기능으로 **컴파일 시 타입 체크**를 수행하여 잘못된 타입 사용을 방지.
- 컬렉션 등에서 널리 사용됨.

### 1.2 제네릭의 이점
#### 1) **컴파일 시 강한 타입 체크**
- 실행 전에 타입 오류를 사전에 방지.

#### 2) **타입 변환 제거**
- 미리 타입을 지정하여 **불필요한 타입 변환** 없이 사용할 수 있음.

**비제네릭 코드**
```java
List list = new ArrayList();
list.add("hello");
String str = (String) list.get(0); // 타입 변환 필요
```

**제네릭 코드**
```java
List<String> list = new ArrayList<>();
list.add("hello");
String str = list.get(0); // 타입 변환 불필요
```

#### 3) **제네릭 클래스와 메소드 구현 가능**
- 2개 이상의 제네릭 타입 선언 가능.

#### 4) **사용 시 주의점**
- `T obj = new T();`, `T[] arr = new T[3];` → T의 크기를 알 수 없어 불가능.
- 하지만 `T[] arr;` 선언은 가능.

### 1.3 제네릭 클래스 예제
```java
class Box<T> {
    private T obj;
    
    public void setObj(T obj) { this.obj = obj; }
    public T getObj() { return obj; }
}
```

### 1.4 제네릭 사용 예제
```java
Box<String> box = new Box<>();
```
- **Primitive Type(기본형)은 사용할 수 없음.**

### 1.5 컴파일 시점에서의 구체화
```java
// T가 String으로 변환됨
class Box {
    private String obj;
    
    public void setObj(String obj) { this.obj = obj; }
    public String getObj() { return obj; }
}
```

---
### ✅ **제네릭을 사용하면 타입 안정성을 확보하고, 불필요한 타입 변환을 제거하여 코드의 가독성과 유지보수성을 높일 수 있음.**
