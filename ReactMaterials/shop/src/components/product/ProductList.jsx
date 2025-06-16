import React, { useEffect, useState } from 'react';
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
const MyButton = styled.button`
  display: block;
  margin: 0 auto;
  width : 150px;
  height : 70px;
`
const ProductList = ({data}) => {
  const total = data.length;
  const amountPerPage = 3;
  const [curr, setCurr] = useState(1);
  const [currArr, setCurrArr] = useState([]);
  function handleClick1(){
    setCurr(prev=>prev+1);
  }
  function handleClick2(){
    setCurr(1);
    setCurrArr(
      data.filter((_,key)=>{
        return key<amountPerPage*curr})
      );
    }
    useEffect(()=>{
      if(data.length!=0){
        setCurrArr(
          data.filter((_,key)=>{
            return key<amountPerPage*curr})
          );
      }
  },[data, curr]);
  return (  
    <div>
      <ProductGrid>
        {currArr.map(product=>{
          return <Product key={product.id} data={product}/>
        })}
      </ProductGrid>
      {
        amountPerPage*curr<total ? <MyButton onClick={handleClick1}>더보기</MyButton>
        :<MyButton onClick={handleClick2}>접기</MyButton>
      }
    </div>
  );
};

export default ProductList;