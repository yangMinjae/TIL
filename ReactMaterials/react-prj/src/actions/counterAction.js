import { INCREASE, DECREASE } from "../reducers/type";

function increase(num){
  return{
    type : INCREASE,
    payload : num,
  }
}

function decrease(){
  return{
    type : DECREASE,
    payload : -1,
  }
}
export {increase, decrease};