import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <div>
      <Link to='/'>홈</Link> &nbsp;&nbsp; | &nbsp;&nbsp;
      <Link to={'/board'}>게시판</Link>
      <hr />
    </div>
  );
};

export default Header;