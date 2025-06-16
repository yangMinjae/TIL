import { ADD_ITEM, REMOVE_ITEM } from "../reducers/type";

function addItem(obj){

  return {
    type: ADD_ITEM,
    obj: obj
  };
}

function removeItem(id, num){
  return{
    type: REMOVE_ITEM,
    payload: num,
    id:id
  };
}

export {addItem, removeItem};