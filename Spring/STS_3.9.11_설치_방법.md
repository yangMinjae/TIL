# STS 3.9.11 설치 방법

## 1. 압축 풀기
- 다운로드한 STS 압축 파일을 원하는 위치에 압축 해제합니다.

## 2. 콘텐츠 설정 파일 추가
- 다음 경로에 `https-contents.xml` 파일을 넣습니다:

```
sts-bundle\sts-3.9.11.RELEASE\configuration\.settings\org.springsource.ide.eclipse.commons.content.core
```

## 3. Lombok 실행
- `lombok.jar` 파일을 **CMD(명령 프롬프트)** 를 통해 실행합니다:
```bash
java -jar lombok.jar
```

## 4. Spring MVC 템플릿 복사
- `org.springframework.templates.mvc-3.2.2` 압축 파일을 해제한 뒤, 다음 경로에 복사합니다:

```
워크스페이스\.metadata\.sts\content
```

## 5. spring mvc 만들기
1) new를 통해 spring legacy project 클릭
2) 우측하단 파란색 configure templates 클릭
3) 3개 메뉴중 첫번째, 세번째 삭제
4) 안나오면 .metadata\.plugins\org.springsource.ide.eclipse.commons.content.core 경로에 https-context.xml 넣기
