import React from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';
import DetailHead from './DetailHead';
import DetailBody from './DetailBody';
import Spinner from '../spinner/Spinner';

const DetailWrapper = styled.div`
  margin : 60px auto 0;
  max-width : 1200px;
  width : 80%;
`;

const Detail = ({data}) => {
  const {pId} = useParams();

  // 1번 방법 - filter
  const product = data.filter(obj=>obj.id===parseInt(pId));

  // 2번 방법 - find
  const product1 = data.find(obj=>obj.id===parseInt(pId));
  if(!product1) return <Spinner/>;
  return (
    <DetailWrapper>
      <DetailHead data={product1}/>
      <DetailBody detail = {product1.detail}/>
    </DetailWrapper>
  );
};

export default Detail;