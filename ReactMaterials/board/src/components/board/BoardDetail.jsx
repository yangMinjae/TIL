import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import changeUnixTimeStamp from '../../util/unixHandle';

const BoardDetail = () => {

  /*
    1. idx 라는 param을 통해서 해당 컴포넌트로 이동
    2. 전달 받은 idx 파라미터를 통해 api에 데이터 요청
    3. 요청 받은 데이터 콘솔에 출력
  */
  const [board,setBoard] = useState(null);
  const [inputs, setInputs] = useState({
    title:'',
    writer:'',
    content:'',
  });
  const [isBeingModified, setIsBeingModified] = useState(false);
  const idx = useParams();
  const navigate = useNavigate();
  useEffect(()=>{
    getBoard(idx);
  },[])

  const getBoard = async(idx)=>{
    const resp = await axios.get(`/b/board/${idx.idx}`);
    if(resp.status===200){
      const data = resp.data;
      setBoard(data);
      setInputs({
        ...data
      })
    }else{
      new Error('오류 발생!..');
    }
  }
  

  const moveToBoardList = ()=>{
    navigate('/board');
  }

  const handleInputsChange=(e)=>{
  const name = e.target.name;
  const value = e.target.value;
  setInputs({
    ...inputs,
    [name]:value,
  })
  }

  const handleModify = ()=>{
    setIsBeingModified(prev=>!prev);
  }
  const handleSubmit = async()=>{
    const inputArr = Object.values(inputs);
    const isEmpty = inputArr.some(ele=>ele==='');
    
    if(isEmpty){
      alert('빈 칸이 있습니다.');
      return;
    }

    const resp = await axios.put('http://localhost:9091/b/board', {
      ...inputs
    },{
      headers:{
        "Content-Type":"application/json"
      }
    })
    
    alert("수정완료!");
    setIsBeingModified(prev=>!prev);
  }

  const handleDelete = async()=>{
    // eslint-disable-next-line no-restricted-globals
    if(confirm("정말 삭제하시겠습니까?")){
      const isDeleted = await axios.delete(`http://localhost:9091/b/board/${board.idx}`)
      if(isDeleted){
        alert('삭제 완료!');
        navigate('/board');
      }
    }
  }

  if(board===null) return <div>로딩중</div>
  return (
    <div>
      <div>
        {isBeingModified&&<h1>수정 페이지</h1>}
        <label>제목</label>
        <input 
        type="text" 
        name='title' 
        value={inputs.title} 
        onChange={(e)=> handleInputsChange(e)}
        readOnly={!isBeingModified}
        />
      </div>
      <div>
        <label>작성자</label>
        <input 
        type="text" 
        name='writer' 
        value={inputs.writer} 
        onChange={(e)=> handleInputsChange(e)}
        readOnly={true}
        />
      </div>
      <div>
        <label>내용</label>
        <textarea 
        name='content' 
        cols='30' 
        rows='10' 
        value={inputs.content} 
        onChange={(e)=> handleInputsChange(e)}
        readOnly={!isBeingModified}
        ></textarea>
      </div>
      <div>

        {isBeingModified 
        ? <button onClick={handleSubmit}>제출</button> 
        :<button onClick={handleModify}>수정</button>
        }
        <button onClick={handleDelete}>삭제</button>
        <button onClick={moveToBoardList}>목록으로 이동</button>

      </div>
    </div>
  );
};

export default BoardDetail;