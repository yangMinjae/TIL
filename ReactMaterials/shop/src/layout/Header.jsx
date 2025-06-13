import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
const Wrapper = styled.div`
  position: relative;
  max-width: 70%;
  min-height: 120px;
  margin: 0 auto;
  margin-bottom: 10px;
  border-bottom: 3px solid gray;
`

const Logo = styled.div`
  position: relative;
  top: 50px;
  left: 0;
  width: 180px;
  height: 40px;
  background-image: url(/images/headerLogo.png);
  background-repeat: no-repeat;
  background-size: contain;
`
const Header = () => {
  return (
    <Wrapper>
      <Link to={'/'}>
        <Logo/>
      </Link>
    </Wrapper>
  );
};

export default Header;