import React, { useReducer } from 'react';

const reducer = (state, action) =>{
  switch(action.type){
    case 'INCREASE' :
      return {count : state.count + action.payload};
    case 'DECREASE' :
      return {count : state.count - action.payload};
    case 'RESET' :
      return {count : 0}
    default :
      throw new Error('unsupported action type : ', action.type);
  }
}
const ReducerTest = () => {
  const initialState = {count:0};
  const [state, dispatch] = useReducer(reducer, initialState)
  return (
    <div>
      <p>count : {state.count}</p>
      <button onClick={()=> dispatch({type:'INCREASE', payload : 1})}>증가</button>
      <button onClick={()=> dispatch({type:'DECREASE', payload : 1})}>감소</button>
      <button onClick={()=> dispatch({type:'RESET'})}>초기화</button>
    </div>
  );
};

export default ReducerTest;