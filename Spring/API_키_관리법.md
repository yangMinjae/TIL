# API 키 관리법

### 1) `src/main/resources` 폴더에 properties 파일 생성

파일명: `OpenAI_apikey.properties`

```properties
key.openAI = api키입니다 어쩌구저쩌구
```

---

### 2) `root-context.xml`에 bean 추가

```xml
<bean
	class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
	<property name="locations"
		value="classpath:OpenAI_apiKey.properties" />
</bean>
```

- `PropertyPlaceholderConfigurer`는 Spring이 제공하는 클래스이며, `.properties` 파일을 읽어주는 역할을 함  
- `locations`는 properties 파일의 위치를 의미  
- `value="classpath:OpenAI_apiKey.properties"`는 실제 경로로, `src/main/resources` 폴더가 대상 경로임

---

### 3) 코드에서 properties 파일의 속성을 호출
```java
	@Value("${key.openAI}")
	private String aiApiKey;
```
- 위와 같이 @Value("${properties파일의 속성명}") 어노테이션을 통해 key 정보를 가져올 수 있다.
