//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);
let f = document.forms[0];
let bno = f.bno.value;
let pageDiv = document.querySelector("#page-data");
let amount = pageDiv.getAttribute("amount");
let pageNum = pageDiv.getAttribute("pageNum");
document.querySelectorAll('.panel-body-btns button').forEach(btn=>{
  btn.addEventListener('click',(e)=>{
    if(e.currentTarget.getAttribute("id")=="modifyBtn"){
      modify();
    }else if(e.currentTarget.getAttribute("id")=="removeBtn"){
      remove();
    }else if(e.currentTarget.getAttribute("id")=="indexBtn"){
      goIndex();
    }
  })
})
function modify(){
  if(!f.title.value){
    alert("제목을 입력해주세요");
    f.title.focus();
    return;
  }
  if(!f.content.value){
    alert("내용을 입력해주세요");
    f.content.focus();
    return;
  }
  f.action="/board/modify";
  f.submit();
}
function remove(){
  let bnoEle=f.bno;     // bno를 담고 있는 input태그
  f.innerHTML='';
  f.appendChild(bnoEle);
  f.action="/board/remove"
  f.submit();
}
function goIndex(){
  location.href=`/board/list?pageNum=${pageNum}&amount=${amount}`;
}