import React from "react"
import axios from "axios"
// axios
const boardRegisterAxios = async (board) =>{
  const resp = await axios.post(`http://localhost:6060/board`, board);
  if(resp.status !== 200) throw new Error ("에러 발생!");
  const data = await resp.data;
  return data;
}
// fetch
const boardRegisterFetch = async (board) =>{
  const resp = await fetch(`/board`, {
    body : JSON.stringify(board),
    method : 'post',
    headers : {
      'Content-type' : 'application/json; charset=utf-8'
    }
  });
  if(!resp.ok) throw new Error ("에러 발생!");
  const data = await resp.text();
  return data;
}

export default {
  boardRegisterAxios,
  boardRegisterFetch,
}