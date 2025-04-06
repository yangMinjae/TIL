# 2025/03/28

## 1. 스프링 프레임워크란
- **프레임워크와 라이브러리의 차이**  
  라이브러리는 개발자가 필요할 때 호출해서 쓰는 도구  
  프레임워크는 전체적인 흐름과 구조가 이미 잡혀 있고, 개발자는 그 안에 코드를 "넣는" 방식 (거꾸로 제어 - 제어의 역전, IoC)
- **장점**
  1. **빠른 구현 시간**  
     반복되는 기능들(DI, 트랜잭션 관리, 웹 설정 등)이 이미 제공되어 빠르게 개발 가능
  2. **쉬운 관리**  
     계층적 구조와 설정 파일 기반의 명확한 역할 분담 덕분에 유지보수, 협업이 쉬움
  3. **개발자들의 역량 획일화**  
     일관된 개발 방식과 아키텍처를 따르므로 숙련도와 무관하게 비슷한 수준의 코드 품질 유지 가능

---

## 2. 스프링의 주요 특징
- **POJO 기반 구성 (Plain Old Java Object)**  
  특별한 규칙 없이 일반 자바 객체로 구성 가능 → 유연하고 테스트하기 쉬움
- **의존성 주입 DI (Dependency Injection) 지원**  
  객체 간 의존 관계를 설정 파일이나 어노테이션을 통해 자동 주입 → 결합도 낮춤
- **AOP (Aspect Oriented Programming) 지원**  
  공통 기능(로깅, 트랜잭션 등)을 핵심 비즈니스 로직과 분리 → 코드 깔끔해짐
- **확장성이 높다**  
  다양한 외부 라이브러리와 쉽게 연동 가능하며, XML 또는 자바 기반 설정으로 유연하게 확장 가능

---

## 3. 스프링 MVC 구조
### 1) Presentation Layer
- 사용자 요청을 처리하고 화면(View)을 반환하는 계층
- Servlet, JSP, Controller 등이 위치하며 Spring MVC가 담당
### 2) Business Layer
- 핵심 비즈니스 로직을 담당 (예: 주문, 결제 처리 등)
- 보통 `xxxService` 클래스에서 처리하며, 트랜잭션도 여기서 수행
### 3) Persistence Layer
- DB와의 연결, CRUD 처리 담당
- MyBatis, JPA 등을 사용하여 SQL 매핑 처리

---

## 4. 스프링 MVC + MyBatis 구조도
```
[사용자] → Controller → Service → DAO/Mapper → MyBatis → DB
                          ↓
                      View(JSP)
```
- 사용자가 웹 요청을 보내면 Controller가 처리
- 비즈니스 로직은 Service가 처리
- DB 작업은 MyBatis를 통해 수행

---

## 5. Spring 프로젝트 구조
### 1) src 폴더1
- `src/main/java`: 실제 애플리케이션 로직 (Controller, Service 등)
- `src/main/resources`: 설정 파일, 템플릿, 정적 자원
- `src/test/java`: 테스트 코드
- `src/test/resources`: 테스트 설정 파일 및 리소스
### 2) src 폴더2 (Spring XML 설정 방식)
- `servlet-context.xml`: View 설정, InternalResourceViewResolver 등
- `root-context.xml`: 공통 설정, 트랜잭션, 서비스 등
- `web.xml`: DispatcherServlet 등록, 필터 설정 등
  - **DispatcherServlet**: 요청을 받아 적절한 Controller로 전달하고 View로 연결하는 Front Controller 역할
### 3) Maven
- 라이브러리/빌드 자동 관리 도구
- pom.xml에 설정만 하면 자동으로 jar 다운로드 및 빌드
### 4) pom.xml
- Java/Spring 버전, 의존성, 빌드 설정 등 전체 프로젝트 설정 파일

---

## 💡 기타 참고
- 상단 window 메뉴 → Web Browser → Chrome으로 브라우저 변경 가능
- `sendRedirect`: 서블릿에서 사용
- `forward`: JSP 내부 이동에서 사용

## 6. @Configuration, @Bean
- XML 없이 Bean 관리 가능
### 1) @Configuration
- 해당 클래스가 Spring 설정 클래스임을 의미함
- 내부에 있는 @Bean 메서드를 통해 Bean을 생성하고 스프링 컨테이너에 등록함
- 예: AnnoConfig 클래스에서 자바 코드로 직접 Bean 등록 및 설정
### 2) @Bean
- 메서드가 반환하는 객체를 Spring의 Bean으로 등록함
- `@Bean(name="id명")` 형태로 Bean 이름을 지정할 수 있음
- 메서드 이름도 Bean ID가 될 수 있지만, name 속성이 우선됨
### ✅ 예시 코드
```java
@Configuration
public class AnnoConfig {
    @Bean(name = "human2")
    public Person abc() {
        Set<String> hobbies = new HashSet<>();
        hobbies.add("낚시");
        hobbies.add("골프");
        hobbies.add("볼링");

        Person person = new Person();
        person.setName("박씨");
        person.setAge(25);
        person.setHobbies(hobbies);
        return person;
    }
}
```
### 3) 사용법
```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
Person person1 = ctx.getBean("human1", Person.class);
System.out.println("이름 : " + person1.getName());
System.out.println("나이 : " + person1.getAge());
System.out.println("취미 : " + person1.getHobbies());
```

---

## 7. @Component("id")
- `src/main/resources`에 Spring Bean 설정 XML 파일 생성
- `root-context.xml에 <context:component-scan base-package="org.joonzis.DI_3_component"/>` 추가하여 사용
### ✅ 사용법
```java
AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext3.xml");
TV tv = (TV) ctx.getBean("tv");
tv.powerOn();
tv.powerOff();
tv.volumeUp();
tv.volumeDown();
```
- applicationContext3.xml은 new-others-spring bean configuration file로 만들어진 파일이다.

---

## 8. Lombok DTO 어노테이션
- 생성자, Getter, Setter 등을 자동 생성해주는 어노테이션 제공
- 클래스 위에 붙여 사용
### ✅ 주요 어노테이션
- `@NoArgsConstructor` : 매개변수 없는 생성자
- `@AllArgsConstructor` : 모든 필드 포함한 생성자
- `@Getter`, `@Setter` : 각 필드에 대해 Getter/Setter 자동 생성
- `@Data` : 위의 기능들을 모두 포함

---

## 9. Controller 사용 방법
### 1) @RequestMapping 어노테이션
- 컨트롤러의 메서드 위에 사용하여 특정 경로 요청을 매핑
```java
@RequestMapping(value="member/result", method = RequestMethod.POST)
```
- value만 지정할 경우 `@RequestMapping("경로")`로 생략 가능
- 메서드의 반환값은 이동할 뷰 이름
- `Model` 객체를 이용해 JSP로 데이터 전달 (setAttribute와 유사)
### 2) DTO 전달 방법
```java
public String goResult1(Model model, StudentDto sDto) {
    model.addAttribute("sDto", sDto);
    return "result";
}
```
- dto객체를 매개변수로 넣으면, 자동으로 이전 뷰에서 전달된 폼내부의 값들이 dto에 매핑되어 전달된다
- 또는 `@ModelAttribute("이름")` 사용하여 자동 매핑
```java
public String goResult2(@ModelAttribute("s") StudentDto dto) {
    return "result";
}
```
- 이 방식은 addAttribute를 생략할 수 있으며, 결과 반환 view에서 ${s.속성명}과 같이 사용할 수 있다
- 이전 요청에서 받아온 정보를 그대로 넘길때 주로 사용
---

## 10. 테스트
### 1) 기본 테스트 및 로그 사용
```java
@Log4j
public class JDBCTests {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Test
    public void testConnection() {
        try(Connection conn = DriverManager.getConnection(...)) {
            log.warn(conn);
        } catch (Exception e) { }
    }
}
```
- `@Log4j`: log.info(), log.warn() 등을 사용할 수 있게 함
- `@Test`: 테스트용 메서드 지정
### 2) 스프링 컨테이너 이용
```java
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try(Connection con = dataSource.getConnection()){
            log.info(con);
        } catch(Exception e) { e.printStackTrace(); }
    }

    @Test
    public void testMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            log.info(session);
        } catch (Exception e) { }
    }
}
```
- `@Autowired`: 컨테이너에서 Bean을 자동 주입, new를 통해 객체생성할 필요 없음
- `@RunWith`, `@ContextConfiguration`: 스프링 테스트 환경 설정
- `@ContextConfiguration`의 괄호에는 스프링 컨테이너의 주소가 들어감. 테스트 경로에서만 사용(일반 클래스들에서는 없어도 등록된 bean들에 대해서는autowired가 작동한다.)
- `@ContextConfiguration`의 괄호에는 스프링 컨테이너의 주소가 들어감
