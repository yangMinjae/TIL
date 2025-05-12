let f = document.forms[0];
const name = f.name;
const id=f.id;
const pw = f.pw;
const pwCheck = f.pwCheck;
const main = document.querySelector("#main");
const submit = document.querySelector("input[name='submit']");
const reset = document.querySelector("input[name='reset']");
const idValidate = document.querySelector("input[name='idValidate']");
main.addEventListener('click',()=>{
  location.href="/";
});
submit.addEventListener('click',()=>{
	console.log("submit");	
});
  

idValidate.addEventListener('click',()=>{	
  if(!id.value){
    alert("아이디를 입력해주세요");
    id.focus();
    return;
  }
  let idval=id.value;
  fetch('/sample/validateId',{
    method:'post',
    body:idval,
    headers:{
      'Content-Type':'text/plain; charset=utf-8'
    }
  })
  .then(res=>res.text())
  .then(result=>{
	  console.log(result);
	  if(result=="Available"){
		  id.setAttribute("readonly",true);
		  id.style.backgroundColor='grey';
      isValidateCheck=true;
	  }else if(result=="Taken"){
      alert("이미 존재하는 아이디 입니다.");
      id.value='';
      id.focus();
      isValidateCheck=false;
	  }
  })
  .catch(err=>console.log(err))
});
let isValidateCheck=false;
reset.addEventListener('click',()=>{
  name.value='';
  id.value='';
  id.removeAttribute('readonly');
  id.style.backgroundColor='white';
  pw.value='';
  pwCheck.value='';
  isValidateCheck=false;
});
submit.addEventListener('click',()=>{
	  if(!name.value){
		    alert("이름을입력해주세요");
	    name.focus();
	    return;
	  }
	  if(!id.value){
	    alert("아이디를 입력해주세요");
	    id.focus();
	    return;
	  }
	  if(!pw.value){
	    alert("비밀번호를 입력해주세요");
	    pw.focus();
	    return;
	  }
	  if(pwCheck.value!=pw.value){
	    alert("비밀번호를 확인해주세요");
	    pwCheck.focus();
	    return;
	  }
    if(!isValidateCheck){
      alert("아이디 중복 확인을 해주세요");
      return;
    }
    f.submit;
})


