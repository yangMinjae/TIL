# 2025/03/28
# Spring 프로젝트 환경 설정 정리

## 1. pom.xml 기본 설정
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

## 7. DB연결시
- 수업자료의 `log4jdbc.log4j2.properties` 파일을 `src/main/resources`에 넣기

---

## 8. root-context.xml 설정
- 파일 열고 하단 `Namespaces`에서 `context`, `mybatis-spring` 체크

---

## 9. HikariCP 사용시 설정
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
## 10. Transaction 사용시 추가 설정
### root-context.xml
1) Namespaces에서 aop, tx 체크
2) 다음의 태그들 추가
```xml
	<bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>

	<tx:annotation-driven />
```

## 11. 파일 업 다운 기능 구현시 추가 설정
### 1.web.xml
1)web-app태그의 version 속성 3.1로 변경
2)web-app태그의 xsi:schemaLocation의 속성 "http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_3_1.xsd"
	->두번째 url의 web-app_2_5_ -> web-app_3_1_

3)servlet 태그 안, load-on-startup 태그 밑에 다음 복붙
```xml
<multipart-config>
   <location>C:\\upload</location>
   <max-file-size>20971520</max-file-size>
   <max-request-size>41943040</max-request-size>
   <file-size-threshold>20971520</file-size-threshold>
</multipart-config>
```
### 2.servlet-context.xml

최상위 beans 태그 안 다음 추가
```xml
<beans:bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver">
</beans:bean>
```

