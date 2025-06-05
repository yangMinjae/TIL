# 2025/06/04

## 1. React 프로젝트 구조 (Project Structure)

1. **node_modules**  
   - Maven의 `pom.xml`처럼 의존성을 관리하는 폴더
   - `npm install`로 설치된 모든 라이브러리 저장

2. **public**  
   - 정적 자원 (이미지 등) 보관
   - 주요 파일: `index.html`
     - `<div id="root"></div>`: React 앱이 삽입되는 최상위 DOM

3. **package.json**  
   - 프로젝트의 의존성(dependencies), 스크립트, 이름, 버전 등 메타데이터 포함
   - 예시:
     ```json
     "dependencies": {
       "axios": "^1.4.0"
     }
     ```
     - `axios`: 비동기 통신을 위한 라이브러리 (AJAX와 유사)

4. **App.js**  
   - React의 루트 컴포넌트
   - `index.js`에서 `root` div에 렌더링될 요소를 이 파일이 포함

5. **props**  
   - 부모 컴포넌트가 자식 컴포넌트에게 전달하는 데이터
   - 단방향으로만 전달 가능 (자식 → 부모 불가)

<br>

## 2. VS Code 단축 코드 스니펫 (React Code Snippets)

| 단축어 | 설명 |
|--------|------|
| `rcc` | 클래스형 컴포넌트 자동 생성 (React.Component 상속, render 메서드 포함) |
| `rsc` | 기본 함수형 컴포넌트 생성 (Named Export 방식) |
| `rsf` | 함수 선언식으로 함수형 컴포넌트 생성 + `export default` 포함 |

※ 프로퍼티로 문자열 외 데이터 전달 시, 중괄호 `{}` 사용  
※ 여러 개의 props를 받을 경우 구조 분해 할당 사용 가능

```jsx
function User({name, age}) {
  return (
    <div>
      <h1>안녕하세요. 제 이름은 {name}입니다. 나이는 {age}살 입니다.</h1>
    </div>
  );
}
```

<br>

## 3. 부모 상태 변경 (Changing Parent State from Child)

1. 부모에서 useState 선언
   ```jsx
   const [age, setAge] = useState(20);
   ```

2. JSX에서 자식 컴포넌트에 props 전달
   ```jsx
   <User name={name} age={age} setAge={setAge} />
   ```

3. 자식 컴포넌트에서 props 구조분해 후 이벤트 처리
   ```jsx
   function User({name, age, setAge}) {
     return (
       <div>
         <h1>안녕하세요. 제 이름은 {name}입니다. 나이는 {age}살 입니다.</h1>
         <button onClick={() => setAge(100)}>나이 변경</button>
       </div>
     );
   }
   ```

<br>

## 4. JSX 스타일링 (Styling in JSX)

### 1) 인라인 스타일링

```jsx
<div style={{color: 'red'}}>hello</div>
```

### 2) 스타일 객체를 외부에 선언

```jsx
const myStyle = {
  color: 'red',
  backgroundColor: 'yellow'
};

<div style={myStyle}>hello</div>
```

<br>

## 5. JSX 반복문 (Loops in JSX)

- `map()` 함수 사용
- 중괄호 사용시 return하고 사용 안하면 return없이 태그만 입력

```jsx
const Container1 = () => {
  const obj = {
    header: ['품목', '가격'],
    data: [
      {product: '과자', price: '1000원'},
      {product: '사탕', price: '2000원'},
      {product: '음료수', price: '3000원'}
    ]
  };

  return (
    <div>
      <table>
        <thead>
          <tr>
            {obj.header.map(ele => <th>{ele}</th>)}
          </tr>
        </thead>
        <tbody>
          {obj.data.map(ele => (
            <tr>
              <td>{ele.product}</td>
              <td>{ele.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
```

<br>

## 6. setState 기본 사용법 (Using setState)

```jsx
const [text, setText] = useState('');

<div>
  <input type='text' onChange={handleChangeText} />
  <button onClick={() => setText('')}>초기화</button>
  <div>
    <b>값: {text}</b>
  </div>
</div>
```

- 사용자가 입력 → `text` 변경 → 값이 실시간 반영됨

<br>

## 7. setState의 비동기 처리 주의 (setState with Previous State)

```jsx
const handlePrintCount = () => {
  setCount(prev => prev + 1);
  setCount(prev => prev + 2);
  setCount(prev => prev + 3);
};
```

- 위와 같이 작성해야 비동기 업데이트 순서 문제 방지 가능
