import React from 'react';
import styled from 'styled-components';
import ProductList from '../components/product/product/ProductList';

const Wrapper = styled.div``;
const MainBG = styled.div`
  margin: auto;
  max-width: 70%;
  min-height: 500px;
  background-image: url(/images/main/main1.jpg);
  background-size: contain;
  background-position: center;
  background-repeat: no-repeat;
  margin-bottom: 50px;
`;
const Main = ({data}) => {
  return (
    <Wrapper>
      <MainBG/>
      <ProductList data={data}/>
      {/*<ProductList/> 삽입 예정 */}
    </Wrapper>
  );
};

export default Main;