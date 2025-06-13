import React, { useEffect, useRef, useState } from 'react';

const Display = (props) => {

  const handleClick = (e)=>{
    const name = e.target.name;
    switch (name) {
      case 'incr':

        if(props.curr>=props.max){
          return;
        }

        props.setCurr(prev=>prev+1);
        break;
      case 'decr':

        if(props.curr<=0){
            return;
        }

        props.setCurr(prev=>prev-1);
        break;

      default:
        break;
    }
  }
  return (
    <div>
      <div>총 {props.curr}/{props.max}명</div>
      <button name = "incr" onClick={handleClick} ref={props.ref[0]}>증가</button>
      <button name = "decr" onClick={handleClick} ref={props.ref[1]}>감소</button>
      {
        props.curr == props.max &&
        <h3 style={{color : 'red'}}>인원이 가득 찼습니다.</h3>
      }
    </div>
  );
};

export default Display;