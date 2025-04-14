# Spring Security 설정 정리

## 1. Dependency 설정 후

- `src-main-webapp-WEB-INF-spring` 경로에
  - `New > Others > Spring Bean Configuration File` 추가

---

## 2. `<security:http>` 설정

### 2-1. 기본 로그인 폼 설정

```xml
<security:http auto-config="true">
    <security:form-login />
</security:http>
```

- 보호된 리소스 접근 시 로그인 페이지로 리디렉션
- 로그인 성공/실패 시 기본 URL(`/login`) 사용
- 커스텀 로그인 페이지 설정:
  - `<security:form-login login-page="/customLogin" />`
  - 로그인 폼에서 `form action="/login"` 지정
  - `input` 태그 이름은 `username`, `password`
  - CSRF 대응 hidden input 필요:
    ```html
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
    ```

### 2-2. 로그인 성공 핸들러 지정

```xml
<security:form-login authentication-success-handler-ref="customLoginSuccess" />
```

- `customLoginSuccess`는 `AuthenticationSuccessHandler` 구현체여야 함
- 권한에 따라 리다이렉트 가능:

```java
List<String> roleNames = new ArrayList<>();
authentication.getAuthorities().forEach(auth -> {
    roleNames.add(auth.getAuthority());
});
if (roleNames.contains("ROLE_ADMIN")) {
    response.sendRedirect("/sample/admin");
} else if (roleNames.contains("ROLE_MEMBER")) {
    response.sendRedirect("/sample/member");
} else {
    response.sendRedirect("/");
}
```

---

## 3. `<security:logout>` 설정

```xml
<security:logout logout-url="/customLogout" invalidate-session="true" />
```

- `logout-url`: 해당 URL 요청 시 로그아웃 처리 (컨트롤러 호출되지 않음)
- `invalidate-session`: true → 세션 제거, false → 인증 정보만 제거

---

## 4. `<security:intercept-url>` 설정

```xml
<security:intercept-url pattern="/sample/all" access="permitAll" />
<security:intercept-url pattern="/sample/member" access="hasRole('ROLE_MEMBER')" />
```

- URL 패턴에 따른 접근 제한 설정

---

## 5. `<security:access-denied-handler>` 설정

```xml
<security:access-denied-handler error-page="/accessError" />
```

- 권한 부족 시 이동할 페이지 지정

또는

```xml
<security:access-denied-handler ref="customAccessDeniedHandler" />
```

- `customAccessDeniedHandler`는 `AccessDeniedHandler` 구현 클래스

---

## 6. Bean 등록 관련

- `@Component`, `@Service`, `@Repository`는 자동 등록 시 클래스 이름의 첫 글자를 소문자로 ID 지정
- 직접 등록 시:
```xml
<bean id="myBean" class="com.example.MyClass" />
```

---

## 7. `<security:authentication-manager>` 설정

### 7-1. 메모리 기반 사용자 인증

```xml
<security:authentication-manager>
  <security:authentication-provider>
    <security:user-service>
      <security:user name="member" password="{noop}member" authorities="ROLE_MEMBER" />
      <security:user name="admin" password="{noop}admin" authorities="ROLE_ADMIN, ROLE_MEMBER" />
    </security:user-service>
  </security:authentication-provider>
</security:authentication-manager>
```

### 7-2. DB 기반 사용자 인증

```xml
<security:authentication-manager>
  <security:authentication-provider>
    <security:jdbc-user-service 
        data-source-ref="dataSource" 
        users-by-username-query="select userid, userpw, enabled from tbl_member where userid=?" 
        authorities-by-username-query="select userid, auth from tbl_member_auth where userid=?" />
    <security:password-encoder ref="bcryptPasswordEncoder" />
  </security:authentication-provider>
</security:authentication-manager>
```

- `users-by-username-query`의 결과 컬럼명은 `userid`, `userpw`, `enabled`
- `authorities-by-username-query`는 사용자 권한 가져오기

```xml
<bean id="bcryptPasswordEncoder" 
      class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>
```

---

## 🕒 로그인 세션

- 로그인 시 인증 정보는 세션에 저장
- 기본 유효 시간: 30분
- 권한 없는 페이지 접근 시: HTTP 403 오류

## 8. CustomUserDetailService 및 커스텀 인증 처리

### 8-1. CustomUserDetailService 이용

```xml
<security:authentication-manager>
    <security:authentication-provider user-service-ref="customUserDetailService">
    </security:authentication-provider>
</security:authentication-manager>
```

- `user-service-ref` 속성을 통해 bean 등록된 커스텀 UserDetailService 사용 가능

---

### 8-2. `@ToString` 어노테이션

- 해당 객체의 `toString()` 메서드를 자동 구현해줌

---

### 8-3. CustomUser, CustomUserDetailService 구성

#### 1) Security용 Mapper Interface 및 XML

```xml
<select id="read" resultMap="memberMap">
	SELECT 
		mem.*, auth.auth 
	FROM 
		tbl_member mem LEFT JOIN tbl_member_auth auth
	ON 
		mem.userID=auth.userID
	WHERE 
		mem.userId=#{userId}
</select>
```

#### 2) resultMap 설정

- JOIN 또는 1:N 관계(컬렉션)의 경우 `resultMap` 필요

```xml
<resultMap type="org.joonzis.domain.MemberVO" id="memberMap">
	<result property="userId" column="userId"/>
	<result property="userPw" column="userPw"/>
	<result property="userName" column="userName"/>
	<result property="regDate" column="regDate"/>
	<result property="updateDate" column="updateDate"/>
	<result property="enabled" column="enabled"/>
	<collection property="authList" resultMap="authMap"/>
</resultMap>

<resultMap type="org.joonzis.domain.AuthVO" id="authMap">
	<result property="userId" column="userId"/>
	<result property="auth" column="auth"/> 
</resultMap>
```

#### 3) CustomUser 클래스

```java
@Getter
public class CustomUser extends User {
	private MemberVO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, MemberVO member) {
		super(username, password, authorities);
	}

	public CustomUser(MemberVO vo) {
		super(vo.getUserId(), vo.getUserPw(),
			vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		this.member = vo;
	}
}
```

- `stream()` → 스트림 반환
- `map()` → 변환
- `collect(Collectors.toList())` → List로 변환

#### 4) CustomUserDetailService 클래스

```java
@Log4j
@Component
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("load user by userName : " + username);
		MemberVO vo = mapper.read(username);
		
		log.warn("member mapper : " + vo);
		return vo == null ? null : new CustomUser(vo);
	}
}
```

#### 5) `security-context.xml` 설정

```xml
<security:authentication-manager>
	<security:authentication-provider user-service-ref="customUserDetailService">
		<security:password-encoder ref="bcryptPasswordEncoder"/>
	</security:authentication-provider>
</security:authentication-manager>
```

- `user-service-ref`: 작성한 UserDetailService 객체의 bean id
- `password-encoder` 역시 필요

---

### 8-4. JSTL에서 sec 태그 사용

#### 1) 로그인 정보 출력

```jsp
<sec:authentication property="principal.username"/>
<sec:authentication property="principal.member.userName"/>
<sec:authentication property="principal.member.userId"/>
<sec:authentication property="principal.authorities" />
<sec:authentication property="principal" var="pinfo"/>
```

#### 2) 로그인 여부 검사

```jsp
<sec:authorize access="isAuthenticated()">
```

---

### 8-5. 실행 흐름 요약

1. 로그인 시도
		- 사용자가 /customLogin페이지에 로그인 하면 username과 password가 Spring Security에 전달
2. CustomUserDetailService.loadUserByUsername()호출
3. 2번의 함수가 mapper 인터페이스의 read 메서드 호출
4. read를 통해 받은 vo를 통해 CustomUser 생성
5. 로그인정보가 session에 저장되고 jstl의 sec 태그를 통해 접근가능하다

---

### 8-6. Remember-Me 설정

```xml
<security:remember-me data-source-ref="dataSource" token-validity-seconds="604800"/>
```

- DB 테이블 예:

```sql
CREATE TABLE persistent_logins (
	username VARCHAR2(64) NOT NULL,
	series VARCHAR2(64) PRIMARY KEY,
	token VARCHAR2(64) NOT NULL,
	last_used TIMESTAMP NOT NULL
);
```

- `input` 태그:

```html
<input type="checkbox" name="remember-me">
```

- 로그아웃 시 자동 삭제 설정:

```xml
<security:logout delete-cookies="remember-me" />
```