import React from 'react';
import styled from 'styled-components';

const SidebarContainer = styled.div`
	width: 350px;
	height: 100vh;
	background-color: #dfe6e9; /* 연회색 */
	box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
	position: fixed;
	left: 0;
	top: 0;
`;

const SideBarFrame = () => {
	return <SidebarContainer />;
};


export default SideBarFrame;