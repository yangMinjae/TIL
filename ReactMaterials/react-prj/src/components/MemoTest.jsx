import React, { useMemo, useState } from 'react';

function Multiply({num1, num2}){

  // const result = () =>{
  //   console.log('Calculationg...');
  //   return num1 * num2;
  // }
  const result = useMemo(()=>{
    console.log('Calculationg...');
    return num1 * num2;
  },[num1, num2]);
  return (
    <div>
      <p>첫 번째 숫자 : {num1}</p>
      <p>두 번째 숫자 : {num2}</p>
      <p>두 숫자의 곱 : {result}</p>
    </div>
  )
}

const MemoTest = () => {
  const handleInputChange = (e)=>{
    const {name, value} = e.target;
    switch (name) {
      case 'number1':
        setNumber1(value);
        break;
      case 'number2':
        setNumber2(value);
        break;

      case 'count' :
        setCount(prev=>prev+Number(value));
      break;

      default :
        break;
    }
  }
  const [number1, setNumber1] = useState(5);
  const [number2, setNumber2] = useState(3);
  const [count, setCount] = useState(0);
  return (
    <div>
      <input 
        type='number'
        name='number1'
        value={number1}
        onChange={handleInputChange}/>
      <input 
        type='number'
        name='number2'
        value={number2}
        onChange={handleInputChange}/>
      <br/>
      <br/>
      <Multiply num1={number1} num2={number2}/>
      <br/>
      <br/>
      <span>{count}</span>
      <br/>
      <button name='count' onClick={handleInputChange} value={1}>증가</button>
      <button name='count' onClick={handleInputChange} value={-1}>감소</button>
    </div>
  );
};

export default MemoTest;