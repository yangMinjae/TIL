document.querySelectorAll('.menu a').forEach(a=>{
  a.addEventListener('click',(e)=>{
    e.preventDefault();
    let menu = e.target.getAttribute('href');
    if(menu === 'boardList'){
      location.href='/board/list?pageNum=1&amount=10';
    }
  });
})
const btnSignIn = document.querySelector("#signIn")
const btnSignUp = document.querySelector("#signUp")
function setStorageData(pageNum,amount){
  let pageData = {
    pageNum : pageNum,
    amount : amount
  };
  localStorage.setItem('page_data',JSON.stringify(pageData));
}
function getStorageData(){
  return JSON.parse(localStorage.getItem('page_data'));
}

let principal;
let userPrincipal;
async function getPrincipal(){
  try{
    const response = await fetch('/api/currentUser.json');
    userPrincipal = await response.json();
    principal = userPrincipal.principal;
    if(principal&&principal!="anonymousUser"){
    	btnSignIn.innerText="로그아웃";
    	isLogIn=true;
    }
  } catch(e){
    console.error('에러 : ',e)
  }
}
getPrincipal();

btnSignIn.addEventListener('click',(e)=>{
  if(e.currentTarget.innerText=="로그인"){
    location.href="/customLogin";
  }else if(e.currentTarget.innerText=="로그아웃"){
    location.href="/customLogout";
  }
})
const params = new URLSearchParams(location.search);
const logoutStatus = params.get("logout");
if(logoutStatus=="success"){
  alert("로그아웃 성공!");
}
btnSignUp.addEventListener('click',()=>{
	location.href="/sample/signUp"
})
