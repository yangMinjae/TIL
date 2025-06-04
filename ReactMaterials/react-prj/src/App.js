import logo from './logo.svg';
import './App.css';
import TestComponent from './components/TestComponent'
import User from './components/User';
import UserList from './components/UserList';
import { useState } from 'react';
import Container from './components/Container';
import Container1 from './components/Container1';
import Counter from './components/Counter'
import InputTest from './components/InputTest';
function App() {
  let name = 'kim';
  const [age, setAge] = useState(20);
  // use라는 말이 붙으면 hook

  const myStyle = {
    color:'red',
    backgroundColor : 'yellow'
  }

  // const numbers = [1,3,5];
  // for (let i = 0; i < numbers.length; i++) {
  //   console.log(numbers[i]);
  // }

  // const numberList = numbers.map(i=>{
  //   return i*3;
  // })
  // numberList.forEach(i=>{
  //   console.log(i);
  // })


  return (
    /*<div className="App">
      <TestComponent name='kim'/>
      <TestComponent name='lee'/>
      <TestComponent name='park'/>
    </div>*/

    // <div className='App'>   {/* className='app'을 해줘야 됨 */}
    //   <User name="kim" age={20}/> 
    //   {/* 프로퍼티 값 지정 시 데이터 타입이 문자열이 아닌 경우 {} 중괄호 안에 값을 입력 ex)숫자*/}
    // </div>

    // <div className='App'>
    //   <UserList >
    //     <div className='text'>hello</div>
    //     <User name={name} age={age} setAge={setAge}/>
    //   </UserList>
    // </div>
    
    // <div>
    //   <Container/>
    // </div>

    // <Counter/>
    <InputTest/>
  );
}

export default App;
