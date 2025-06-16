import { act } from "react";
import { ADD_ITEM, REMOVE_ITEM } from "./type";


const initialState = [

];
const cart = (state=initialState, action)=>{
  let existingIndex = null;
  switch(action.type){
    case ADD_ITEM:  
      existingIndex = state.findIndex(item => item.id == action.obj.id);
    
      if(existingIndex!==-1){
        return state.map((item,index)=>
          index === existingIndex
            ?{...item, quantity:item.quantity+1}
            : item
        );
      }else{
        return[...state, action.obj];
      }
    
    case REMOVE_ITEM:    
      existingIndex = state.findIndex(item => item.id == action.id);

      return state.map((item)=>{
        if(item.id == action.id){
          if (item.quantity > action.payload) {
            let temp1 = { ...item, quantity: item.quantity - action.payload };
            return temp1;
           }
        }else{
          return item;
        }
      }).filter(item=>item!==undefined);

    default:
      return state;
  }
}
export default cart;