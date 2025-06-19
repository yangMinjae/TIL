import React from 'react';
import { useQuery } from '@tanstack/react-query';

const getPosts = async() =>{
    const resp = await fetch(`https://jsonplaceholder.typicode.com/posts/`);
    const result = await resp.json();
    return result;
}

const PostListExample = () => {

  const {data,isLoading,refetch} = useQuery({
    queryKey : ['posts'],
    queryFn : ()=> getPosts(),
    // initialData : [{
    //   id : 1,
    //   title : '데이터가 없습니다'
    // }],
    // select : data => data.map(post =>post.title),
    // staleTime : 1000*60*5, // 5분 fresh  + Infinity >> fetch가 딱 한번만 (refetch 막음)
    // gcTime : 1000 *60 *10 // 10분 동안 메모리(캐시)에 유지    언마운트가 되어도 10분동안은 살아있다   0으로 하면 캐시가 바로 삭제됨
  });
  
  if(isLoading) return <div>loading....</div>  

  console.log(data);
  return (
    <div>
     {
      data.map(post =>{
        return <p key={post.id}>{post.title}</p>
      })
     }
    </div>
  );
};

export default PostListExample;