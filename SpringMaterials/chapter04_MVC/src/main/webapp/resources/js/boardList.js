//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/boardList.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);

// 게시글 등록 버튼
document.querySelector("#registerBtn").addEventListener('click', ()=>{
  location.href=`/board/register`;
})
let pageDiv = document.querySelector("#page-data");
let amount = pageDiv.getAttribute("amount");
let pageNum = pageDiv.getAttribute("pageNum");
document.querySelectorAll(".aTitle").forEach(a=>{
  a.addEventListener('click',e=>{
    e.preventDefault();
    let bno = e.currentTarget.getAttribute("href");
    location.href=`/board/get?bno=${bno}&pageNum=${pageNum}&amount=${amount}`;
  })
})
document.querySelectorAll(".page-wrap a").forEach(a=>{
  a.addEventListener('click', e=>{
    e.preventDefault();
    let pageNum = e.target.getAttribute("href");
    console.log("href : "+ pageNum);
    console.log("amount : "+ amount);
    location.href = `/board/list?pageNum=${pageNum}&amount=${amount}`;
  })
})
