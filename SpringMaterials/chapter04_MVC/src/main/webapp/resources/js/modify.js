//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);

const regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
const MAX_SIZE = 5242880; //5MB

let f = document.forms[0];
let bno = f.bno.value;
let pageDiv = document.querySelector("#page-data");
let amount = pageDiv.getAttribute("amount");
let pageNum = pageDiv.getAttribute("pageNum");
let resultUl = document.querySelector(".uploadResult ul");
let chooseBtn = document.querySelector("#chooseFile");
let inputFile = document.querySelector('input[type="file"]');
let initFlag = true;
let attachItems = document.querySelectorAll('.attachItem');
let uploadDiv = document.querySelector('.uploadDiv');
let cloneObj = uploadDiv.children[1].cloneNode(true);
let changed=f.changed;
console.log(changed);
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
  if(resultUl.children.length===0){
    changed.value="true";
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
chooseBtn.addEventListener('click',clickInput);
function clickInput(){
  resultUl.innerHTML='';
  document.querySelector('input[type="file"]').click();
}
showLi();
giveListener(inputFile);
function showLi(files=null){
  if(initFlag){
    initShow();
  }else{
    showUploadFile(files);
  }
}
function initShow(){
  let fileName='';
  let uuid='';
  let uploadPath='';
  let str = '';
  attachItems.forEach(item=>{
    uuid=item.getAttribute('uuid');
    fileName=item.getAttribute('fileName');
    uploadPath=item.getAttribute('uploadPath');
    str+=`<li>${fileName}</li>`
  })
  resultUl.innerHTML=str;
}

function giveListener(enitity){
	enitity.addEventListener('change',()=>{
    initFlag=false;
    const files = enitity.files
    let blindFlag = false;
    for(let i = 0; i<files.length;i++){
      if(!checkExtension(files[i].name,files[i].size)){
        blindFlag=true;
      }
    }
    showLi(files);
    if(blindFlag){
      uploadDiv.replaceChild(cloneObj.cloneNode(true),uploadDiv.children[1]);
      resultUl.innerHTML='';
      giveListener(document.querySelector('input[type="file"]'));
    }
  });
}

function checkExtension(fileName, fileSize){
	if(fileSize>=MAX_SIZE){
    alert("파일 사이즈 초과");
    return false;
  }
  if(regex.test(fileName)){
    alert("해당 종류의 파일은 업로드할 수 없습니다.");
    return false;
  }
  return true;
}

function showUploadFile(fileArr){
  if(!fileArr||fileArr.size==0){
    return;
  }
	fileArr=Array.from(fileArr);
  let str = '';
  fileArr.forEach(file=>{
    str+=`<li>${file.name}</li>`;
  })
  resultUl.innerHTML=str;
}