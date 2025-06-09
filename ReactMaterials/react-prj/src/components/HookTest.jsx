import React, { useState } from 'react';

function useInput(initialValue){
  const [value, setValue] = useState(initialValue);

  const handleChange = e =>{
    setValue(e.target.value);
  }

  return{
    value,
    onChange : handleChange
  }
}
const HookTest = () => {

  const firstName = useInput('');
  const lastName = useInput('');

  console.log(firstName, lastName);

  return (
    <div>
      <input type="text" {...firstName}/>
      <input type="text" {...lastName}/>
      <p>Full Name : {firstName.value} {lastName.value}</p>
    </div>
  );
};

export default HookTest;