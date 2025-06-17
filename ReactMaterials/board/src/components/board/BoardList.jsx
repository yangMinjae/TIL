import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const BoardList = () => {
  const[boardList, setBoardList] = useState([]);
  const navigate = useNavigate();

  const getBoardList = async()=>{
    // 2. 게시글 목록 데이터 받아오기
    const resp = await axios.get('/b/boardList');
    if(resp.status===200){
      const data = resp.data;
      console.log(data);
      // 3. 게시글 목록 데이터 상태 값에 할당
      setBoardList(data);
    }else{
      new Error('데이터 실패..');
    }
  }
  const handleMoveWritePage = ()=>{
    navigate('/write');
  }
  useEffect(()=>{
    getBoardList();   // 1. 게시글 목록 조회 함수 호출
  }, []);
  return (
    <div>
      <div>
        <button onClick={handleMoveWritePage}>새 게시글 등록</button>
      </div>
      <ul>
        {
          boardList.map(board=>{
            return(
              <Link to={`/board/${board.idx}`} key={board.idx}>
                <li>{board.title}</li>
              </Link>
            ) 
          })
        }
      </ul>
    </div>
  );
};

export default BoardList;