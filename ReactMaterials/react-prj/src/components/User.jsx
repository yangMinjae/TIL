import React from 'react';

// function User(props) {
//   return (
//     <div>
//       <h1>안녕하세요. 제 이름은 {props.name}입니다. 나이는 {props.age}살 입니다.</h1>
//     </div>
//   );
// }

function User({name, age, setAge}) {
  return (
    <div>
      <h1>안녕하세요. 제 이름은 {name}입니다. 나이는 {age}살 입니다.</h1>
      <button onClick={()=>setAge(100)}>나이 변경</button>
    </div>
  );
}

export default User;