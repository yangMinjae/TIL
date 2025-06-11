import { combineReducers } from "redux";
import counter from "./counter";
import cart from "./cart";

// 여러 reducer를 사용하는 경우 reducer를 하나로
// 묶어주는 함수
const rootReducer = combineReducers({
  counter, cart, // counter 리듀서, cart 리듀서
});

export default rootReducer