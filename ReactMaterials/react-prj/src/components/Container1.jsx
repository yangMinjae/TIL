import React from 'react';
import '../css/Container.css'
const Container1 = () => {
  const obj = {
    header:['품목', '가격'],
    data : [
      {product : '과자', price : '1000원'},
      {product : '사탕', price : '2000원'},
      {product : '음료수', price : '3000원'}
    ]
  }
  return (
    <div>
      <table>
        <thead>
          <tr>
            {
              obj.header.map(ele=>{
                return <th>{ele}</th>;
              })
            }
          </tr>
        </thead>
        <tbody>
          {obj.data.map(ele => {
            return(
            <tr>
              <td>{ele.product}</td>
              <td>{ele.price}</td>
            </tr>);
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Container1;