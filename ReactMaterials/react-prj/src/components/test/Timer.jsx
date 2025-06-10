import React, { useEffect, useRef, useState } from 'react';

const Timer = () => {
  // const [time, setTime] = useState(0);
  // let intervalId = useRef(null);
  // const startTimer = ()=>{
  //   if(intervalId.current !=null) return;
  //   intervalId.current = 
  //   setInterval(() => {
  //     setTime(prev=>prev+1);
  //   },1000);
  // }
  // const pauseTimer = ()=>{
  //   if(intervalId.current == null) return;
  //   clearInterval(intervalId.current);
  //   intervalId.current=null;
  // }
  // const resetTimer = ()=>{
  //   setTime(0);
  //   if(intervalId.current == null) {
  //     return;}
  //   clearInterval(intervalId.current);
  //   intervalId.current=null;
  // }
  // -------------useEffect 버전--------------
  // const [time, setTime] = useState(null);
  // let id = useRef(null);
  // const startTimer = ()=>{
  //   if(!id.current){
  //     if(time==null){
  //       setTime(0);
  //     }
  //     if(time!=null){
  //       setTime(prev=>Number(prev));
  //     }
  //   }
  // }
  
  // const pauseTimer = ()=>{
  //   if(id.current && time!=null){
  //     setTime(prev=>prev+'');
  //     clearTimeout(id.current);
  //     id.current=null;
  //   }
  // }
  // const resetTimer = ()=>{
  //   setTime(null);
  //   clearTimeout(id.current);
  //   id.current=null;
  // }
  // useEffect(()=>{
  //   if(time!=null&& (typeof time === 'number' && isFinite(time))){
  //     id.current = setTimeout(() => {
  //       setTime(prev=>prev+1);
  //     },1000);
  //   }
  //   return ()=>{
  //     if(id.current){
  //       clearTimeout(id.current);
  //     }
  //   }
  // },[time])
  // -------------refined version --------------
  const [time, setTime] = useState(0);
  let id = useRef(null);
  const [flag, setFlag] = useState(false);
  const startTimer = ()=>{
    if(flag === false){
      console.log('???');
      setFlag(true);
    }
  }
  
  const pauseTimer = ()=>{
    setFlag(false);
  }
  const resetTimer = ()=>{
    setFlag(false);
    clearInterval(id.current);
    setTime(0);
  }
  useEffect(()=>{
    if(flag){
      id.current = setInterval(() => {
        setTime(prev=>prev+1);
      },1000);
    }
    return ()=>{
      if(id.current){
        clearInterval(id.current);
      }
    }
  },[flag])

  // **********중요! : 제 3의 변수를 사용하면 쉽게 풀린다.*********
  // useEffect 사용시 flag 사용을 고려하자
  return (
    <div>
      <h1>Timer</h1>
      <div>경과시간 : {time}초</div>
      <button onClick={startTimer}>시작</button>
      <button onClick={pauseTimer}>정지</button>
      <button onClick={resetTimer}>초기화</button>
    </div>
  );
};

export default Timer;