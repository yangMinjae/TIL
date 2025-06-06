import React, { useEffect, useState } from 'react';
const Counter = () => {
  // let count = 0;
  const handlePrintCount = ()=>{
    setCount(prev=>prev+1);
    setCount(prev=>prev+2);
    setCount(prev=>prev+3);
  }

  const[count, setCount] = useState(0);

  useEffect(()=>{
    console.log('렌더링 완료');
    return () =>{
      console.log('clean up')
    }
  })
  return (
    <div>
      <p>{count}번 클릭!!</p>
      <button onClick={handlePrintCount}>Click!!</button>
    </div>
  );
};

export default Counter;