import React, { useState } from 'react';

const InputTest = () => {

  const [text, setText] = useState('');
  const handleChangeText = (e)=>{
    setText(e.target.value);
  }
  const handleReset = ()=>{
    setText('');
  }
  return (
    <div>
      <input type='text'
      onChange={handleChangeText}
      value = {text}
      />
      <button onClick={handleReset}>초기화</button>
      <div>
        <b>값 : {text}</b>
      </div>
    </div>
  );
};

export default InputTest;