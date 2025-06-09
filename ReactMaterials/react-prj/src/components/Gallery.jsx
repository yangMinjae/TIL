import React, { useState } from 'react';

const Gallery = () => {
  const images = [
    "https://picsum.photos/id/1018/300/300",
    "https://picsum.photos/id/1025/300/300",
    "https://picsum.photos/id/1035/300/300",
    "https://picsum.photos/id/1043/300/300",
    "https://picsum.photos/id/1059/300/300",
    "https://picsum.photos/id/1062/300/300",
    "https://picsum.photos/id/1069/300/300",
    "https://picsum.photos/id/1074/300/300",
    "https://picsum.photos/id/1080/300/300",
    "https://picsum.photos/id/1084/300/300"
  ];
  const [src, setSrc] = useState(0);
  const handleClick = (e)=>{
    const name = e.target.name;
    switch (name) {
      case 'prev':
        setSrc(prev=>{
          console.log((prev-1+images.length)%images.length);
          return (prev-1+images.length)%images.length;
        });
        
        break;
      
      case 'next':
        setSrc(prev=>{
          console.log((prev+1)%images.length);
          return (prev+1)%images.length;
        });
        break;
    
      default:
        break;
    }
  }
  return (
    <div>
      <h2>갤러리</h2>
      <h3>사진{src+1}</h3>
      <div>
        <img src={images[src]} alt="???" />
        <br />
        <button name='prev' onClick={handleClick}>이전</button>
        <button name='next' onClick={handleClick}>다음</button>
      </div>
    </div>
  );
};

export default Gallery;