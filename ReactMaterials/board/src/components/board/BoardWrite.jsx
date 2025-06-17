import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardWrite = () => {

  const [inputs, setInputs] = useState({
    title:'',
    writer:'',
    content:'',
  });
  const navigate = useNavigate();
  const registerBoard = async()=>{
    // 1. 빈 값 검증 방법-1
    // const {title, writer, content} = inputs;
    // if(!title || !writer || !content){
    //   alert("모든 내용을 입력해주세요.");
    //   return;
    // }

    // 2. 빈 값 검증 방법-2
    const inputArr = Object.values(inputs);
    const isEmpty = inputArr.some(value => value ==='');
    if(isEmpty){
      alert("모든 내용을 입력해주세요.");
      return;
    }
    const resp = await axios.post('http://localhost:9091/b/board', inputs, 
      {
        headers:{
          'Content-Type': 'application/json'
        }
      }
    )
    if(resp.data=='success'){
      navigate('/board');
    }
  }
  const resetInputs = ()=>{
    setInputs({
      title:'',
      writer:'',
      content:'',
    })
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
  return (
    <div>
      <div>
        <label>제목</label>
        <input type="text" name='title' value={inputs.title} onChange={(e)=> handleInputsChange(e)}/>
      </div>
      <div>
        <label>작성자</label>
        <input type="text" name='writer' value={inputs.writer} onChange={(e)=> handleInputsChange(e)}/>
      </div>
      <div>
        <label>내용</label>
        <textarea name='content' cols='30' rows='10' value={inputs.content} onChange={(e)=> handleInputsChange(e)}></textarea>
      </div>
      <div>
        <button onClick={registerBoard}>등록</button>
        <button onClick={resetInputs}>다시 입력</button>
        <button onClick={moveToBoardList}>목록으로 이동</button>
      </div>
    </div>
  );
};

export default BoardWrite;