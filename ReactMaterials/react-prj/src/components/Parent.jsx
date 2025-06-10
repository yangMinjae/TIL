import React, { useContext } from 'react';
import { MyContext } from '../App';

const Parent = () => {
  const{str, number, setNumber, str1} = useContext(MyContext);
  return (
    <div>
      {str} <br />
      {number} <br />
      {str1} <br />
    </div>
  );
};

export default Parent;