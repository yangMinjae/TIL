import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

const Main = () => {
  const nav = useNavigate();
  return (
    <div>
      <h1>Main 페이지 입니다.</h1>
      <Link to={'/view/10?search=postName&q=demo#test'}>View 페이지로 이동</Link>
      <button onClick={()=>nav('/write')}>write 페이지로 이동</button>
    </div>
  );
};

export default Main;