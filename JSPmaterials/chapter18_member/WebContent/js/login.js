let sendData;

/* ---------- Form 관련 요소들 ----------------*/
const f = document.forms[0];
const LOGIN_FAIL_MSG = '아이디 또는 비밀번호가 일치하지 않습니다.';

/* ---------- 함수 ----------------*/
/*
	1. 버튼들 클릭 함수 걸어주기
	2. 메인 버튼 클릭 시 메인화면 이동
	3. 로그인 버튼 클릭 시 login() 함수 실행
	4. login() 함수 - 아이디, 비밀번호 빈 값 검증 후 데이터 전송
		- json 형식으로 id, pw 데이터 전송
			(프로퍼티 명 : mId, mPw, cmd)
			* cmd = login
	5. DB내에 id와 pw가 일치하면 'success' 리턴
	6. 일치하는 데이터가 없으면 'fail' 리턴
	7. 'success' 시 메인 화면으로 이동
	8. 'fail' 시 오류 문구 출력(LOGIN_FAIL_MSG)   
*/
// 
document.querySelectorAll('button').forEach(btn=>{
	btn.addEventListener('click',()=>{
		let type = btn.getAttribute("id");
		if(type=='loginBtn'){
			login();
		}else if(type=='mainBtn'){
			main();
		}
	})
})
function login(){
	let formData = new FormData(f);
	let jsonData = JSON.stringify(
		Object.fromEntries(
			formData.entries()));
	fetch(`MemberAsyncController`,{
		method:'post',
		body:jsonData,
		headers:{
			'Content-type':'application/json; cahrset=utf-8'
		}
	}).then(response=>response.json()).
	then(data=>{
		if(data.result===1){
			alert("로그인 성공");
			location.href='MemberController?cmd=mainPage';
		}else{
			alert("아이디와 비밀번호를 확인해주세요");
			f.reset();
		}
	}).catch(err=>console.log(err));
}
function main(){
	location.href=`MemberController?cmd=mainPage`;
}






