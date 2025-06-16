import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { addItem, removeItem } from '../actions/cartAction';
import formatKoreanCurrency from '../../util/display/display';

const CartWrapper = styled.div`
  max-width : 80%;
  margin : auto;
  table{
    width : 100%;
  }
  td{
    text-align : center;
  }
`
const Cart = () => {
  const cart = useSelector(state=>state.cart);
  const dispatch = useDispatch();
  const handlePlus = (e)=>{
    const key = e.target.dataset.key;
    dispatch(addItem(cart[key]));
  }
  const handleMinus = (e)=>{
    const key = e.target.dataset.key;
    const id = cart[key].id;
    dispatch(removeItem(id, 1));
  }
  const handleDelete = (e)=>{
    const key = e.target.dataset.key;
    const id = cart[key].id;
    dispatch(removeItem(id,99));
  }
  return (
    <CartWrapper>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>상품 이름</th>
            <th>수량</th>
            <th>가격</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {
            cart.map((ele, key)=>{
              return(
                <tr key = {key}>
                  <td>{key+1}</td>
                  <td>{ele.productName}</td>
                  <td>
                    <button data-key={key} name='plus' onClick={(e)=>handleMinus(e)}>-</button>
                    {ele.quantity}
                    <button data-key={key} name='minus' onClick={(e)=>handlePlus(e)} disabled={ele.quantity>98}>+</button>
                  </td>
                  <td>{formatKoreanCurrency(ele.price*ele.quantity)}</td>
                  <td><button data-key={key} name='delete' onClick={(e)=>handleDelete(e)}>삭제</button></td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </CartWrapper>
  );
};

export default Cart;