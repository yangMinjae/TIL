import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { decrease, increase } from '../actions/counterAction';
import { addItem, deleteItem } from '../actions/cartAction';

const Proudct = () => {
  // store에 접근해서 state 가져오기
  const counter = useSelector(state => state.counter.count);
  // 1. cart state 가져오기
  const cart = useSelector(state => state.cart);

  // dispatch를 사용하기 위한 준비
  const dispatch = useDispatch();

  // state를 변경하는 함수들
  const handleIncrease = () =>{
    dispatch(increase(1));
  }
  const handleDecrease = () =>{
    dispatch(decrease());
  }

  const handleAdd = () =>{
    dispatch(addItem());
  }
  const handleRemove = (key) =>{
    console.log(key);
    dispatch(deleteItem(key));
  }
  return (
    <div>
      <h1>Hello Redux</h1>
      <p>{counter}</p>
      <button onClick={handleIncrease}>+</button>
      <button onClick={handleDecrease}>-</button>
      <br />
      <br />
      <br />
      <br />
      <hr />
      <br />
      <br />
      <h1>상품 카트</h1>
      <ul>
      {
        /*
          cart를 이용해서 map -> 화면에 출력
          상품 이름만 출력
        */
       cart.map((ele, key)=>{
        return(
        <li style={{border:'solid', width : '200px'}} key={key}>
          <div>
            id : {ele.id}
          </div>
          <div>
            상품명 : {ele.productName}
          </div>
          <div>
            가격 : {ele.price}
          </div>
          <button onClick={()=>handleRemove(ele.id)}>아이템 삭제</button>
        </li>
        )
       })
      }
      </ul>
      <button onClick={handleAdd}>아이템 추가</button>
    </div>
  );
};

export default Proudct;