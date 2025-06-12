import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import formatKoreanCurrency from '../../../util/display/display';

const Item = styled.div`
    color: black;
    text-align: left;
    margin : 30px;
    padding : 20px;
    border-radius : 10px;
    box-shadow : 5px 5px 5px 5px #e8e4e4;

    &{
        transition: all 0.2s linear;
    }
    &:hover{
        transform : scale(1.01);
    }
    h4{
        margin-top:10px;
        font-size : 1.5em;
        font-weight : bold;
    }
    p{
        font-size : 1em;
        padding : 0;
        margin : 0;
    }
    span {
        font-size : 1.2em;
        font-weight : 500;
    }
`;
const Product = ({data}) => {
  return (
    <Link 
      to={`/detail/${data.id}`}
      style={{textDecoration:'none'}}
      >
      <Item>
        <img 
          src={process.env.PUBLIC_URL+`/images/product/${data.main}`}
          width='100%'/>
        <h4>{data.title}</h4>
        <p>{data.content}</p>
        <span>{formatKoreanCurrency(data.price)}</span>
      </Item>
    </Link>
  );
};

export default Product;