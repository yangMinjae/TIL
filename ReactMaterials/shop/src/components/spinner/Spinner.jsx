import React from 'react';
import styled, { keyframes } from 'styled-components';

const SpinnerContainer = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    height: 200px; /* 스피너를 중앙에 배치하기 위한 높이 설정 */
`;
const spinAnimation = keyframes`
    to {
        transform: rotate(360deg);
    }
`;
const SpinnerMain = styled.div`
    width: 40px;
    height: 40px;
    border: 4px solid #f3f3f3;
    border-top: 4px solid #3498db;
    border-radius: 50%;
    animation: ${spinAnimation} 1s linear infinite;
`;

function Spinner(props) {
    return (
        <SpinnerContainer>
            <SpinnerMain/>
        </SpinnerContainer>
    );
}
export default Spinner;