# 2025/03/28
# Spring 프로젝트 환경 설정 정리

## 1. pom.xml 설정
1. `java-version` → 11로 변경
2. `springframework-version` → 5.0.7.RELEASE로 변경
3. dependency의 <groupId>log4j</groupId>의 `<scope>runtime</scope>` 주석 처리
4. `javax.servlet(artifactId가 servlet-api인것)` → version 3.1.0, `artifactId`는 `javax.servlet-api`로 변경
5. `junit` → version 4.12로 변경
6. plugin 내 `source`와 `target` → 11로 변경
- 설정 후: 프로젝트 우클릭 → Maven → update Project

---

## 2. web.xml 추가 인코딩 설정
### 📌 `<web-app>안, </web-app><servlet-mapping>` 아래에 다음 내용 추가:
```xml
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

---

## 3. contextPath 변경
- 서버 더블클릭
- 좌측 하단 Modules 클릭
- 표의 Row 클릭 → Edit → Path를 `/` 로 변경

---

## 4. Lombok dependency 추가
```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.0</version>
    <scope>provided</scope>
</dependency>
```

---

## 5. STS에서 build path 추가 방법
- 기존 Eclipse처럼 `Add External JARs`로 추가
- 좌측 메뉴에서 `Deployment Assembly` → `Add` → `Java Build Path Entries` → 원하는 JAR 추가

---

## 6. 자주 쓰이는 JAR
- **spring-tx** (5.0.7): 트랜잭션 관리  
  https://mvnrepository.com/artifact/org.springframework/spring-tx
- **spring-jdbc** (5.0.7): DB 연동  
  https://mvnrepository.com/artifact/org.springframework/spring-jdbc
- **spring-test** (5.0.7): 단위 테스트  
  https://mvnrepository.com/artifact/org.springframework/spring-test
- **HikariCP** (2.7.8): 고성능 커넥션 풀  
  https://mvnrepository.com/artifact/com.zaxxer/HikariCP
- **MyBatis** (3.4.6): DB 프레임워크  
  https://mvnrepository.com/artifact/org.mybatis/mybatis
- **mybatis-spring** (1.3.2): 스프링 연동용 MyBatis  
  https://mvnrepository.com/artifact/org.mybatis/mybatis-spring
- **Log4jdbc** (1.16): DB 로그 출력용  
  https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4.1

---

## 7. 수업자료
- `log4jdbc.log4j2.properties` 파일을 `src/main/resources`에 넣기

---

## 8. root-context.xml 설정
- 파일 열고 하단 `Namespaces`에서 `context`, `mybatis-spring` 체크

---

## 9. HikariCP 설정
### 📌 root-context.xml에 다음 코드 추가
```xml
<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
    <!-- log4jdbc -->
    <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
    <property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@localhost:1521:XE" />
    <property name="username" value="scott" />
    <property name="password" value="tiger" />
</bean>

<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
    <constructor-arg ref="hikariConfig" />
</bean>

<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
</bean>

<mybatis-spring:scan base-package="org.joonzis.mapper" />
```
