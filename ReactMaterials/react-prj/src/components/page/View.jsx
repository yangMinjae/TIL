import React from 'react';
import { Outlet, useLocation, useParams } from 'react-router-dom';

const View = () => {
  // useParams();
  // REST 방식처럼 파라미터를 url에 설정하여 사용하는 방법
  // 1. const{파라미터} = useParams();
  // 2. const 변수명 = useParams().파라미터명
  const {postId}= useParams();
  const po = useParams().postId;
  const location = useLocation();
  console.log(location);
  
  // useLocation()
  // hash : 주소의 #문자열 뒤 값
  // pathname : 현재 주소 경로
  // search : ?를 포함한 쿼리스트링
  // state : 페이지로 이동 시 임의로 넣을 수 있는 값
  // key : location 객체의 고유 값
  
  return (
    <div>
      <h1>View 페이지 입니다.</h1>
      <h1>{postId}번 View 페이지1</h1>
      <h1>{po}번 VIew 페이지2</h1>
      <Outlet></Outlet>
    </div>
  );
};

export default View;