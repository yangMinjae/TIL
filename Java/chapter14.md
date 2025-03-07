# chapter14
## 다형성 (Polymorphism)
<br>

1.1 다형성(Polymorphism)  
* `부모클래스 객체명 = new 자식();` → **객체의 타입은 자식이 아니라 부모 클래스이다!**  
* 부모 클래스의 객체는 자식 클래스의 객체를 저장할 수 있다. (**업캐스팅**)  

<br><br>1.2 업 캐스팅(Upcasting)  
* 부모 클래스의 참조 변수에 자식 클래스의 객체를 저장하는 것  
* **부모 클래스에 존재하지 않는 멤버는 호출할 수 없다.** (한계)  
  → **즉, 자식 클래스만 가지고 있는 멤버는 호출 불가!**  

<br><br>1.3 다운 캐스팅(Downcasting)  
* `부모클래스 객체명1 = new 자식();` 형식으로 객체를 생성하면, 이 객체의 타입은 부모 클래스가 된다.  
* 이를 **자식 클래스 타입으로 변경하는 것**이 다운 캐스팅이다.  

📌 **예제 코드**  
```java
부모클래스 참조변수1 = new 자식클래스();
자식클래스 참조변수2 = (자식클래스) 참조변수1;
```