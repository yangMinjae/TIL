import React from 'react';

const TestComponent = (props) => {
  console.log(props);
  return (
    <div>
      안녕하세요. {props.name}
    </div>
  );
};
export default TestComponent;