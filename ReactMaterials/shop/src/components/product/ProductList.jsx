import React, { useState } from 'react';
import styled from 'styled-components';
import Product from './Product';

const ProductGrid = styled.div`
  max-width: 70%;
  margin-right: auto;
  margin-left: auto;
  display: grid;
  grid-template-rows: 1fr;
  grid-template-columns: 1fr 1fr 1fr;
`;

const ProductList = ({data}) => {
  const total = data.length;
  const amountPerPage = 3;
  const [curr, setCurr] = useState(1);
  const [currArr, setCurrArr] = useState(data.filter((_,key)=>{
    return key<amountPerPage*curr;
  }))
  function handleClick1(){
    setCurr(prev=>prev+1);
    setCurrArr(
      data.filter((_,key)=>{
    return key<amountPerPage*curr})
    );
    console.log(curr);
    console.log(currArr);
  }
  function handleClick2(){
    setCurr(prev=>prev+1);
    setCurrArr(
      data.filter((_,key)=>{
    return key<amountPerPage*curr})
    );
    console.log(curr);
    console.log(currArr);
  }
  return (
    <ProductGrid>
      {currArr.map(product=>{
        return <Product key={product.id} data={product}/>
      })}
      {
        amountPerPage*curr<=total ? <button onClick={handleClick1}>더보기</button>
        :<button onClick={handleClick2}>접기</button>
      }
    </ProductGrid>
  );
};

export default ProductList;