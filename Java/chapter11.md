# chapter 11

## 난수 생성 (Random)

1.1 `Math.random()` 사용
- 0.0 이상 1.0 미만의 난수를 생성.
- 특정 범위의 난수를 얻으려면 수식을 조정해야 함.
```java
// 1~10 사이의 난수 생성
int num = (int)(Math.random() * 10) + 1;
```

<br>

1.2 `Random` 클래스 사용
- `java.util.Random` 클래스를 이용하여 난수를 생성할 수 있음.
```java
import java.util.Random;
Random rand = new Random();
```

<br>

1.3 `nextInt()` 사용
- 0 이상 주어진 값 미만의 정수를 반환.
```java
int num = rand.nextInt(10); // 0~9 사이의 난수
```

<br>

1.4 `nextDouble()` 사용
- 0.0 이상 1.0 미만의 실수를 반환.
```java
double num = rand.nextDouble(); // 0.0~1.0 난수
```
