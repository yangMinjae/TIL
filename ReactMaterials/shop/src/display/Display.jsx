import React, { useEffect, useState } from 'react';
import Header from '../layout/Header';
import styled from 'styled-components';
import Main from '../layout/Main';
import { Routes, Route } from 'react-router-dom';

import Detail from '../components/detail/Detail';
import axios from 'axios';
import Cart from '../components/cart/Cart';

const Container = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-direction: column;
`;
const HeaderArea = styled.div`
    width: 100%;
    background-color : white;
    position : sticky;
    top : 0;
    z-index : 9999;
`;
const Body = styled.div`
    width: 100%;
    min-height: 50vh;
`;

const Display = () => {

  const [products, setProducts] = useState([]);

  useEffect(()=>{
    run3();
  },[]);

  const run3 = ()=>{
    axios.get('/api/products')
    .then(response=>
      setProducts(response.data)
    );
  }
  return (
  <Container>
    <HeaderArea>
      <Header/>
    </HeaderArea>
    <Body>
      <Routes>
        <Route path='/' element={<Main data={products}/>}/>
        <Route 
          path='/detail/:pId'
          element = {<Detail data={products}/>}/>
        <Route 
          path='/cart'
          element = {<Cart/>}/>
      </Routes>
    </Body>
  </Container>
  );
};

export default Display;