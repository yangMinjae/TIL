import React, { useState } from 'react';
function useInput(initialValue){
  const [value, setValue] = useState(initialValue);

  const handleChange = (e)=>{
    setValue(e.target.value);
  }

  return{
    value ,
    onChange : handleChange
  }
}
const ExampleQ1 = () => {
  const firstInput = useInput(0);
  const secondInput = useInput(0);
  const [result, setResult] = useState(0);

  function handleClick(e){
  const val1 = Number(firstInput.value);
  const val2 = Number(secondInput.value);
  switch (e.target.name) {
    case 'plus':
      setResult(val1+val2);
      break;
    case 'minus':
      setResult(val1-val2);
      
      break;
    case 'multiply':
      setResult(val1*val2);
        
      break;
    case 'divide':
      setResult(val1/val2);
        
      break;
    default:
      break;
  }
}

  return (
    <div>
      <input type="number" name='num1' {...firstInput}/>
      <input type="number" name='num2' {...secondInput}/>
      <br/>
      <button onClick={handleClick} name='plus'>더하기</button>
      <button onClick={handleClick} name='minus'>빼기</button>
      <button onClick={handleClick} name='multiply'>곱하기</button>
      <button onClick={handleClick} name='divide'>나누기</button>
      <br />
      <div>결과 : {result}</div>
    </div>
  );
};

export default ExampleQ1;