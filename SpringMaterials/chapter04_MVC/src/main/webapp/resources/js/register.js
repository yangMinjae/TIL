const CSS_FILE_PATH = '/resources/css/register.css';
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;

document.head.appendChild(linkEle);
let f = document.forms[0]
// 버튼들 클릭 이벤트
// 새 게시글 등록 버튼 - register()함수 호출
document.querySelectorAll('.panel-body-btns button').forEach(btn=>{
  btn.addEventListener('click',(e)=>{
    if(e.currentTarget.getAttribute("id")=="registerBtn"){
      register();
    }else if(e.currentTarget.getAttribute("id")=="resetBtn"){
      f.reset();
    }else if(e.currentTarget.getAttribute("id")=="indexBtn"){
      goIndex();
    }
  })
})

function register(){
  if(!f.title.value){
    alert("제목을 입력해주세요");
    f.title.focus();
    return;
  }
  if(!f.writer.value){
    alert("작성자를 입력해주세요");
    f.writer.focus();
    return;
  }
  if(!f.content.value){
    alert("내용 입력해주세요");
    f.content.focus();
    return;
  }
  f.action="/board/register";
  f.submit();
}
function goIndex(){
  location.href="/board/list"
}