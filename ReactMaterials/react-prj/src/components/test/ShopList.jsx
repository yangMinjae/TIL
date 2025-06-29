import React, { useEffect, useState } from 'react';

const ShopList = () => {
  let tempList = [];
  const [productList, setProductList] = useState([]);
  const [inputObj, setInputObj] = useState({
    item : '',
    quantity : ''
  })
  const handleAdd = ()=>{
    tempList = productList.map(obj=>({...obj}));
    const exists = tempList.some(obj=> compareItem(inputObj.item,obj.item));
    if(exists){
      alert('이미 존재하는 품목');
      return;
    } 
    tempList.push({
      item : inputObj.item,
      quantity : inputObj.quantity
    });
    setProductList(tempList);
  }
  const handleRemove = (e)=>{
    tempList = productList.map(obj=>({...obj}));
    const index = Number(e.target.dataset.index);
    tempList = tempList.filter((_, i)=> i!==index);
    setProductList(tempList);
  }
  const compareItem = (item1, item2)=>{
    let item1NoSpace = item1.replace(/\s/g,'');
    let item2NoSpace = item2.replace(/\s/g,'');
    return item1NoSpace === item2NoSpace ? true : false
  }
  const handleInputChange = (e)=>{
    const name = e.target.name;
    const value = e.target.value;
    setInputObj({
      ...inputObj,
      [name] : value,
    })
  }
  const handleElementChange = (e)=>{
    tempList = productList.map(obj=>({...obj}));
    
    const index = e.target.dataset.index;
    const value = e.target.value;
    console.log(tempList);
    console.log(index);
    tempList[index].quantity = value;
    setProductList(tempList);
  }
  return (
    <div>
      <h1>간단한 쇼핑 목록</h1>
      <input 
      type="text" 
      placeholder='상품 이름' 
      value={inputObj.item} 
      name = 'item'
      onChange={handleInputChange}/>

      <input 
      type="number" 
      placeholder='수량' 
      value={inputObj.quantity} 
      name = 'quantity'
      onChange={handleInputChange}/>

      <button onClick={handleAdd}>추가</button>
      <ul>
        {productList.map((ele, key)=>{
          return(
            <li key={key} style={{ marginBottom: '8px' }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                <span style={{ width: '100px', display: 'inline-block' }}>{ele.item}</span>
                <input 
                type="number" 
                value={ele.quantity} 
                name='quantity' 
                data-index={key}
                onChange={handleElementChange}
                />
                <button data-index={key} onClick={handleRemove}>삭제</button>
              </div>
            </li>
            )
        })}
      </ul>
    </div>
  );
};

export default ShopList;