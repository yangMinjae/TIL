# React 설치 및 개발환경 설정 (React Installation & Development Setup)

## 1. Node.js 설치 (Installing Node.js)

- 수업 기준 권장 버전: `v20.17.0`
- 설치 시 별다른 커스텀 설정 없이 "다음" 연타
- 설치 완료 후 다음 명령어로 설치 확인:
  ```bash
  node -v
  npm -v
  npx -v
  ```
- `npm`은 Node.js 패키지 매니저이고, `npx`는 패키지를 실행할 때 사용

<br>

## 2. React Developer Tools 설치 (Install React Developer Tools)

- **Chrome Web Store**에서 설치
- 설치 후 React 기반 페이지에 접속하면 크롬 개발자 도구에 React 탭 생성됨
- 컴포넌트 구조 확인, props 및 state 추적 가능

<br>

## 3. VS Code 확장 프로그램 (VS Code Extensions)

React 개발에 도움이 되는 추천 확장 프로그램:

1. **Reactjs code snippets**  
   - `rfc`, `rcc` 등 단축어로 코드 자동 생성
2. **ESLint**  
   - 코드 문법 오류 및 스타일 실시간 검사
3. **IntelliCode**  
   - AI 기반 코드 추천 기능
4. **Live Server**  
   - 정적 HTML 페이지를 실시간으로 확인할 수 있는 로컬 서버 실행
5. **Open in Browser**  
   - HTML 파일을 마우스 우클릭으로 바로 브라우저에서 열기
6. **Auto Rename Tag**  
   - HTML/JSX 태그 수정 시 자동으로 짝 태그도 수정됨

<br>

## 4. 프로젝트 생성 및 실행 (Create & Run React Project)

### 4.1 프로젝트 생성

- VS Code에서 `터미널(Command Prompt)` 열기
- 워크스페이스(작업 폴더) 경로에서 다음 명령어 입력:

  ```bash
  npx create-react-app@latest [프로젝트이름]
  ```

  > `@latest` 옵션은 최신 버전의 CRA 템플릿을 사용하여 프로젝트 생성

### 4.2 프로젝트 실행

- 프로젝트 폴더로 이동:

  ```bash
  cd [프로젝트이름]
  ```

- 개발 서버 실행:

  ```bash
  npm start
  ```

- 실행 중지: `Ctrl + C`
- 중지 후에도 `npm start`로 언제든 다시 실행 가능

<br>

## 5. npm install 명령어 (Understanding `npm install`)

### 5.1 특정 라이브러리 설치

```bash
npm install [라이브러리이름]
```

- 예: `npm install axios`
- 기능:
  - `node_modules` 폴더에 라이브러리 설치
  - `package.json`의 `dependencies`에 추가

### 5.2 전체 라이브러리 일괄 설치

```bash
npm install
```

- 보통 프로젝트를 git에서 clone 한 후 실행
- `node_modules` 폴더는 `.gitignore`에 의해 공유되지 않음
- 따라서 `package.json`의 정보를 기반으로 모든 라이브러리 재설치

<br>
