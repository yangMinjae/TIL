import React, { useReducer } from 'react';

const ReducerTest = () => {
  const initialState = {count:0};
  const reduce = (state, action) =>{

  }
  const [state, dispatch] = useReducer(reduce, initialState)
  return (
    <div>
      <p>count : </p>
      <button onClick={()=> dispatch({type:'INCREASE', payload : 1})}>증가</button>
    </div>
  );
};

export default ReducerTest;