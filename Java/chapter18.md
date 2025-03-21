# chapter 18

## API

1.1 java.lang 패키지  
- 자바 프로그램의 **기본적인 클래스**를 담고 있는 패키지
- `import` 없이 사용 가능

**주요 클래스**

| **클래스** | 용도 |
|--------|---------------------------------------------------|
| `Object` | 자바 클래스의 최상위 클래스 |
| `System` | 표준 입출력, JVM 종료, GC 실행 요청 |
| `Class` | 클래스를 메모리로 로딩할 때 사용 |
| `String` | 문자열 저장 및 정보 조회 |
| `StringBuffer, StringBuilder` | 문자열 저장 및 조작 |
| `Math` | 수학 함수 이용 |
| `Wrapper` (`Byte`, `Short`, `Character`, `Integer`, `Float`, `Double`, `Boolean`, `Long`) | 기본 타입 데이터 객체화, 문자열 변환, 입력값 검사 |

**String, StringBuffer, StringBuilder 차이**  
- `String` : 문자열 연산이 적고 멀티스레드 환경에서 사용
- `StringBuffer` : 문자열 연산이 많고 멀티스레드 환경에서 사용
- `StringBuilder` : 문자열 연산이 많고 단일스레드이거나 동기화가 필요 없는 경우 사용

<br>

1.2 java.lang.Object 클래스  
- 모든 클래스의 **최상위 조상**
- 모든 클래스는 자동으로 `Object` 클래스를 상속받음
- 모든 클래스는 `Object` 클래스의 메서드를 사용 가능

**주요 메서드**

| **메서드** | 설명 |
|--------|---------------------------------------------------|
| `clone()` | 인스턴스 복제 (`Cloneable` 인터페이스 구현 필요) |
| `equals()` | 인스턴스 동등 비교 |
| `getClass()` | 클래스 정보 조회 |
| `hashCode()` | 해시 코드 값 반환 |
| `toString()` | 인스턴스 정보 문자열 반환 |

<br>

1.3 java.util 패키지  
- **유틸리티 클래스**들이 포함된 패키지
- **컬렉션(Collections) 클래스** : 정렬, 섞기, 탐색 등의 알고리즘 제공

**주요 클래스**

| **클래스** | 용도 |
|--------|---------------------------------------------------|
| `Arrays` | 배열 조작 (비교, 복사, 정렬, 검색) |
| `Calendar` | 운영체제의 날짜와 시간 정보 조회 |
| `Date` | 날짜와 시간 정보 저장 |
| `Objects` | 객체 비교, `null` 여부 검사 |
| `StringTokenizer` | 구분자로 문자열 분리 |
| `Random` | 난수 생성 |
