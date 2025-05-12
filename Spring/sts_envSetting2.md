# 환경설정 (Multipart 및 Spring Security 설정)

## 📁 멀티파트(파일 업/다운로드) 사용 시 환경설정

### 1. `web.xml`

1. `web-app` 태그의 `version` 속성을 `3.1`로 변경  
2. `web-app` 태그의 `xsi:schemaLocation` 속성 변경  
   - 기존: `http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd`  
   - 변경: `http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_3_1.xsd`

3. `servlet` 태그 내, `load-on-startup` 태그 아래에 아래 설정 추가:

```xml
<multipart-config>
   <location>C:\upload</location>
   <max-file-size>20971520</max-file-size>
   <max-request-size>41943040</max-request-size>
   <file-size-threshold>20971520</file-size-threshold>
</multipart-config>
```

---

### 2. `servlet-context.xml`

`<beans>` 태그 내부에 다음 내용 추가:

```xml
<beans:bean id="multipartResolver" class="org.springframework.web.multipart.support.StandardServletMultipartResolver">
</beans:bean>
```

---

## 🔐 Spring Security 환경설정

### 1. Dependency 설정

- `spring-security-web (5.0.6)`  
  [🔗 Link](https://mvnrepository.com/artifact/org.springframework.security/spring-security-web)

- `spring-security-config (5.0.6)`  
  [🔗 Link](https://mvnrepository.com/artifact/org.springframework.security/spring-security-config)

- `spring-security-core (5.0.6)`  
  [🔗 Link](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core)

- `spring-security-taglibs (5.0.6)`  
  JSP에서 시큐리티 태그 라이브러리 사용  
  [🔗 Link](https://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs)

---

### 2. Bean 설정

- `src/main/webapp/WEB-INF/spring` 경로에  
  ➤ `New > Other > Spring Bean Configuration File` 추가

- `xsi:schemaLocation` 속성에서 아래와 같이 수정:  
  ```xml
  http://www.springframework.org/schema/security/spring-security-5.0.xd 
  ->
  http://www.springframework.org/schema/security/spring-security.xsd
  ```
- 두번째 url에서 '-5.0'을 지워준다.
---

### 3. `web.xml` 설정

#### 3-1. 인코딩 필터 아래 추가

```xml
<!-- 스프링 시큐리티 필터 -->
<filter>
   <filter-name>springSecurityFilterChain</filter-name>
   <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
   <filter-name>springSecurityFilterChain</filter-name>
   <url-pattern>/*</url-pattern>
</filter-mapping>
```

#### 3-2. 필터 아래 컨텍스트 설정 추가

```xml
<context-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>
      /WEB-INF/spring/root-context.xml
      /WEB-INF/spring/security-context.xml
   </param-value>
</context-param>
```

---