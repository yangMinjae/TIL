import React from 'react';

const UserList = (props) => {
  return (
    <div>
      {props.children}
    </div>
    // app.js에서 다음과 같은 구조일 때, 위와 같이 전달
    // <div className='App'>
    //   <UserList >
    //     <User name="kim" age={20}/>
    //   </UserList>
    // </div>
  );
};

export default UserList;