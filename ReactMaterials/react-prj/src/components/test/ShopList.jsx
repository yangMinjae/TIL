import React, { useEffect, useState } from 'react';

const ShopList = () => {
  const [productList, setProductList] = useState([]);
  const [inputObj, setInputObj] = useState({
    item : '',
    quantity : ''
  })
  const handleAdd = ()=>{
    console.log(productList);
    const exists = productList.some(obj=> compareItem(inputObj.item,obj.item));
    if(exists){
      alert('이미 존재하는 품목');
      return;
    } 
    productList.push({
      item : inputObj.item,
      quantity : inputObj.quantity
    })
  }
  const handleRemove = ()=>{

  }
  const compareItem = (item1, item2)=>{
    let item1NoSpace = item1.replace(/\s/g,'');
    let item2NoSpace = item2.replace(/\s/g,'');
    return item1NoSpace === item2NoSpace ? true : false
  }
  const handleChange = (e)=>{
    const name = e.target.name;
    const value = e.target.value;
    setInputObj({
      ...inputObj,
      [name] : value,
    })
  }
  return (
    <div>
      <h1>간단한 쇼핑 목록</h1>
      <input 
      type="text" 
      placeholder='상품 이름' 
      value={inputObj.item} 
      name = 'item'
      onChange={handleChange}/>

      <input 
      type="number" 
      placeholder='수량' 
      value={inputObj.quantity} 
      name = 'quantity'
      onChange={handleChange}/>

      <button onClick={handleAdd}>추가</button>
      <ul>
        {productList.map((ele, key)=>{
          return(
          <li key={key} style={{ display: 'flex', alignItems: 'center', gap: '8px', marginBottom: '8px' }}>
            <span style={{ width: '100px', display: 'inline-block' }}>{ele.item}</span>
            <input type="number" />
            <button>삭제</button>
          </li>)
        })}
      </ul>
    </div>
  );
};

export default ShopList;