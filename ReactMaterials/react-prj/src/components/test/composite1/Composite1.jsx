import React, { useEffect, useRef, useState } from 'react';
import InputCount from './InputCount';
import Display from './Display';

const Composite1 = () => {
  const [max, setMax] = useState(0);
  const [flag, setFlag] = useState(false);
  const [curr, setCurr] = useState(0);
  const incrBtnRef = useRef(null);
  const decrBtnRef = useRef(null);
  useEffect(()=>{
    if(curr==0){
      if(decrBtnRef.current)
      decrBtnRef.current.setAttribute('disabled',true);
    }else if(curr>0){
      if(decrBtnRef.current)
      decrBtnRef.current.removeAttribute('disabled');
    }
    
    if(max!=0 && curr==max){
      if(incrBtnRef.current)
      incrBtnRef.current.setAttribute('disabled',true);
    }else if(curr<max-1){
      if(incrBtnRef.current)
      incrBtnRef.current.removeAttribute('disabled');
    }

  },[max, curr]);
  return (
    <div>
      <InputCount 
      setMax = {setMax} 
      setFlag = {setFlag} 
      setCurr={setCurr} 
      max = {max} 
      ref = {[incrBtnRef, decrBtnRef]}
      />
      {flag ? 
      <Display 
      max = {max} 
      curr = {curr} 
      setCurr = {setCurr} 
      ref = {[incrBtnRef, decrBtnRef]}
      />:''}
    </div>
  );
};

export default Composite1;