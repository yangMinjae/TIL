import React, { useState } from 'react';

const InputCount = (props) => {
  const [input, setInput] = useState(0);
  return (
    <div>
      <div>최대 인원을 정하시오</div>
      <input type="number" value={input} onChange={(e)=>setInput(e.target.value)}/>
      <button onClick={()=>{
        if(input<1){
          alert('1이상의 값을 입력하세요');
          return
        }
        if(input==props.max){
          return
        }
        props.setCurr(0);

        props.setMax(input)
        props.setFlag(true);
      }}>확인</button>
    </div>
  );
};

export default InputCount;