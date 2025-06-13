import { ADD_ITEM, DELETE_ITEM } from "../reducers/type";

function addItem(){
  return{
    type : ADD_ITEM,
  };
}

function deleteItem(id){
  return{
    type : DELETE_ITEM,
    id : id,
  };
}

export {addItem, deleteItem}
