import React, { useState } from 'react';

const FormTest = () => {
  const [user, setUser] = useState({
    name: '',
    age: '',
    email: '',
    gender: '남자',
    addr: '강남'
  });
  const clearData = () => {
    setUser({
      name : '',
      age : '',
      email : '',
      gender: '남자',
      addr: '강남'
    })
  }

  const handleInputChange = (e) =>{
    const name = e.target.name;
    const value = e.target.value;
    // =>
    //const{name, value} = e.target;
    setUser({
      ...user,
      [name] : value
    })
  }

  const handleSubmit = ()=>{
    console.log(user.name, user.age, user.email, user.gender, user.addr);
    
  }
  return (
    <div>
      <form>
        이름
        <br />
        <input type="text" name='name' onChange={handleInputChange} value={user.name}/>
        <br />

        나이
        <br />
        <input type="number" name='age' onChange={handleInputChange} value={user['age']}/>
        <br />

        이메일
        <br />
        <input type="email" name='email' onChange={handleInputChange} value={user.email}/>
        <br />
        성별
        <br/>
        남<input type="radio" value={'남자'} name='gender' onChange={handleInputChange} checked={user.gender=='남자'}/>
        여<input type="radio" value={'여자'} name='gender' onChange={handleInputChange} checked={user.gender=='여자'}/><br/>

        지역
        <br/>
        <select name='addr' onChange={handleInputChange} value={user.addr}>
          <option value="강남" >강남</option>
          <option value="강서" >강서</option>
          <option value="강동" >강동</option>
          <option value="강북" >강북</option>
        </select>
        <br/>
        <button type='button' onClick={handleSubmit}>Click!</button>
        <button type='button' onClick={clearData}>초기화</button>
      </form>

      <div>이름 : {user.name}</div>
      <div>나이 : {user.age}</div>
      <div>이메일 : {user.email}</div>
      <div>성별 : {user.gender}</div>
      <div>주소 : {user.addr}</div>
    </div>
  );
};

export default FormTest;