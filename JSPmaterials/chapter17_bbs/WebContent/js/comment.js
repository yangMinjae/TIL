function insert_comment(f){
	if(!f.writer.value){
		alert('작성자를 입력하세요.');
		f.writer.focus();
		return;
	}
	if(!f.pw.value){
		alert('비밀번호를 입력하세요.');
		f.pw.focus();
		return;
	}
	if(!f.content.value){
		alert('내용을 입력하세요.');
		f.content.focus();
		return;
	}
	let formData = new FormData(f);
	// 직렬화
	let serializedData = new URLSearchParams(formData).toString();
	
	fetch(`CommentController?${serializedData}`)
	.then(response =>response.json())
	.then(json=>{
		console.log(json.result);
		f.reset();	// 삽입 성공 후 input 데이터 비우기		
		showCommList();	
	})
	.catch(err=>console.log(err))
}
showCommList(); // 페이지가 로드 되면서 리스트 함수 실행
// 댓글 리스트 함수
function showCommList(){
	// url에서 특정 파라미터 가녀오는 코드
	let b_idx = new URLSearchParams(location.search).get('cmd');
	b_idx=b_idx.substr(b_idx.indexOf('=')+1);
	let sendData = `cmd=commList&b_idx=${b_idx}`;
	let msg = '';
	let date;
	fetch(`CommentController?${sendData}`)
	.then(response =>response.json())
	.then(json=>{
		let cList = JSON.parse(json.cList);
		cList.forEach(cvo=>{
			
			msg+=`<tr>`;
			msg+=`<td>${cvo.c_idx}</td>`;
			msg+=`<td>${cvo.writer}</td>`;
			msg+=`<td>${cvo.content}</td>`;
			msg+=`<td>${myTime(cvo.reg_date)}</td>`;
			msg+=`<td>
	         		<input type="button" onclick="remove_comment(${cvo.pw},${cvo.c_idx})" value="삭제">
				</td>`;
			msg+=`</tr>`;
		})
		if(!msg){
			msg+=`<tr>`;
			msg+=`<td colspan="5">댓글이 없습니다.</td>`
			msg+=`</tr>`;
		}
		document.querySelector("#commBody").innerHTML=msg;
	})
	.catch(err=>console.log(err))
}

function myTime(unixTimeStamp){
	// 1. 밀리초로 넘어오면 / 1000을 해준다.
	//let myDate = new Date(unixTimeStamp/1000);
	// 초로 넘어오면 그냥 사용
	let myDate = new Date(unixTimeStamp);
	let date = myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();
	return date;
}
function remove_comment(pw, c_idx){

	let sendData =`cmd=removeComment&c_idx=${c_idx}`;
	let remove = prompt("댓글 비밀번호를 입력하세요");
	if(!remove){
		alert("비밀번호를 입력해주세요");
		return;
	}

	if(remove==pw){
		fetch(`CommentController?${sendData}`).
		then(response =>response.json())
		.then(json=>{
			console.log(json.result);
			showCommList();
		})
		.catch(err=>console.log(err))
	}else{
		alert("비밀번호가 일치하지 않습니다.");
		return;
	}
}