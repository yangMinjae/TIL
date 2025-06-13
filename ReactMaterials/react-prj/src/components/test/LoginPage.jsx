import React, { useEffect, useState } from 'react';

const Login = (props)=>{ 

  return(
    <div>

      아이디 : <input 
      type="text" 
      name="id" 
      value={props.auth.id} 
      onChange={props.onChange}/> <br />

      비밀번호 : <input 
      type="text" 
      name="password" 
      value={props.auth.password} 
      onChange={props.onChange}/> <br />

      <button onClick={props.callBack}>로그인</button>
    </div>
  );
}
const Logout = (props)=>{
  
  return(
    <div>
      <h3>안녕하세요. {props.name}님</h3>
      <button onClick={props.callBack}>로그아웃</button>
    </div>
  )
}
const LoginPage = () => {
  const authInfo = {
    id : 'admin',
    password : '1234'
  }

  let [auth, setAuth] = useState({id:'', password:''});
  let [ck, setCk] = useState(true);

  function changeCK(){
    if (!ck){
      setCk(true);
      setAuth({
        id:'',
        password:''
      })
    } 
    else{
      const {id, password} = auth;
      if(authInfo.id==id&&authInfo.password==password){
        setCk(false);
      }else{
        alert('id/pw 불일치');
      }
    }
  }

  function handleInputChange(e){
    const name = e.target.name;
    const value = e.target.value;
    setAuth({
      ...auth,
      [name] : value,
    })
  }

  return (
    <div>
      <h1>로그인 / 로그아웃</h1>
      {
        ck ?
        <Login callBack = {changeCK} auth = {auth} setAuth={setAuth} onChange={handleInputChange}/>
        : 
        <Logout name = {auth.id} callBack = {changeCK}/>
      }
    </div>
  );
};

export default LoginPage;