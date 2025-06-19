import { useQuery } from '@tanstack/react-query';
import React from 'react';

// 패칭 함수
const getPosts = async(number) =>{
  const resp = await fetch(`https://jsonplaceholder.typicode.com/posts/${number}`);
  const result = await resp.json();
  return result;
}

const Example = ({number}) => {

  const {data,isLoading,refetch} = useQuery({
    queryKey : ['posts', number],
    queryFn : ()=> getPosts(number),
    staleTime : 3000, // 3초
    
  });
  if(isLoading) return <div>loading....</div>  
  console.log(number);
  return (
    <div>
      {/* refetch를 실행시키면 다시 불러옴 > 강제로 fetch시키는 방식 */}
      <button onClick={refetch}>다시 불러오기</button>  
      <div>{data.title}</div>
    </div>
  );
};

export default Example;