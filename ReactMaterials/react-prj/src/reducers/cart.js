import { ADD_ITEM, DELETE_ITEM } from "./type";

const initialState = [
  {id:1, productName : 'hat', price : 2000},
];

const cart = (state=initialState, action) => {
  switch (action.type) {
    case ADD_ITEM:
      if(state.length!=0){
        return [...state, {...state[state.length-1],id:state[state.length-1].id+1}]
      }else{
        return initialState;
      }

    case DELETE_ITEM:
      return state.filter((ele)=>{
        return ele.id!=action.id})

  
    default:
      return state;
  }
}

export default cart;