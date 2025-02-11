# chapter 17

### 1. 예외 (Exception)

#### 1.1 예외 (exception)  
- 오류의 일종이며, 프로그램 실행 시 또는 컴파일 시 발생하는 **불능 상태**를 의미.  

  1) **오류**: 에러, 개발자가 손댈 수 없는 수준  
  2) **예외**: 개발자가 **회피할 수 있는 수준**  
  3) **예외 클래스의 계층 구조**:
     ```
     Object → Throwable → Exception
     ```
  4) **모든 예외는 `java.lang.Exception` 클래스로 처리 가능**.

<br>

#### 1.2 예외 처리 형식  
```java
try {
    ...
    // 예외가 발생할 가능성이 있는 구역
    ...
} catch (예외를 받는 매개변수) {
    // 받은 예외를 처리하는 구역
} finally {
    // 예외 유무를 떠나 무조건 실행되는 구역
}
```
<br>

#### 1.3 예외 처리 팁  
- 어떤 exception인지 모를때 `e.printStackTrace();`로 확인 가능  
```java
try {
    ...
    // 예외가 발생할 가능성이 있는 구역
    ...
} catch (Exception e) {
    e.printStackTrace();
} 
```

<br>

#### 1.4 throws(예외 떠넘기기)  
- 메소드를 호출한 곳으로 예외를 떠넘긴다.  
- 떠넘길 예외 클래스를 쉼표(`,`)로 구분해서 나열할 수 있다.  
- `throws` 키워드가 붙어있는 메소드는 반드시 `try` 블록 내에서 호출되어야 한다.  

```java
public class Ex06_exception {
    public static void main(String[] args) {
        try{
            divide(5,0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static void divide(int num1, int num2) throws ArithmeticException {            // exception을 호출한곳으로 떠넘기겠다.
        System.out.println("몫 : " + (num1/num2));
        System.out.println("나머지 : " + (num1%num2));
    }
}
```
<br>

#### 1.5 사용자 정의 예외
- 사용자가 직접 예외를 정의 할 수 있다.
- Exception 클래스를 상속해야한다.
- 다음과 같은 형식으로 정의
``` java
class MyException extends Exception{
	// 경고 없애려고 넣은거니까 신경 안써도 된다.
	private static final long serialVersionUID = 1L;
	public MyException(String msg) {
		super(msg);
	}
```
- 다음과 같이 활용
``` java
		try {
			throw new MyException("내가 만든 예외");	// 예외 강제 발생
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
```

