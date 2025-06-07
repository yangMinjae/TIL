import React, { useEffect, useState } from 'react';

const CounterTest = () => {
  const [number, setNumber] = useState(-1);
  const [count, setCount] = useState(0);
  // const setValues = ()=>{
  //   setNumber(prev=>prev<3?prev+1:prev);
  //   setCount(prev=>prev+1);
  // }
  useEffect(()=>{
    setNumber(prev=>prev<3?prev+1:prev);
  },[count]);
  return (
    <div>
      number : {number}<br/>
      count : {count}<br/>
      <button onClick={()=>setCount(prev=>prev+1)}>Click!</button>
    </div>
  );
};

export default CounterTest;