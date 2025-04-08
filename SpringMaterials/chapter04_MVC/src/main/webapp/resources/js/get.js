//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);
let f = document.forms[0]
let pageDiv = document.querySelector("#page-data");
let amount = pageDiv.getAttribute("amount");
let pageNum = pageDiv.getAttribute("pageNum");
document.querySelectorAll('button').forEach(btn=>{
	  btn.addEventListener('click',(e)=>{
			let bno = f.bno.value;
	    if(e.currentTarget.getAttribute("id")=="modifyBtn"){
	    	location.href=`/board/modify?bno=${bno}&pageNum=${pageNum}&amount=${amount}`;
	    }else if(e.currentTarget.getAttribute("id")=="indexBtn"){
	    	location.href=`/board/list?pageNum=${pageNum}&amount=${amount}`;
	    }else if(e.currentTarget.getAttribute("id")=="replyBtn"){
				// 댓글 등록 버튼
				registerModalPage();
			}else if (e.currentTarget.getAttribute('id')=='closeModalBtn'){
				closeModal();
			}else if (e.currentTarget.getAttribute('id')=='addReplyBtn'){
				registerReply();
			}else if (e.currentTarget.getAttribute('id')=='modifyReplyBtn'){
				modifyReply();
			}else if (e.currentTarget.getAttribute('id')=='removeReplyBtn'){
				removeReply();
			}
	  })
	})
// -------------------------------댓글 관련 스크립트----------------------------------
const rs = replyService;
// 댓글 목록 가져오기
showList();
function showList(){
	const bno = f.bno.value;
	const replyUL = document.querySelector(".chat");
	let msg = '';
	rs.getList(bno, function(data){
		data.forEach(a=>{
			msg+=`<li data-rno=${a.rno}>`;
			msg+=	`<div>`;
			msg+=		`<div class="chat-header">`;
			msg+=			`<strong>${a.replyer}</strong>`;
			msg+=			`<small class="pull-right">${myDate(a.replyDate)}</small>`;
			msg+=		`</div>`;
			msg+=		`<p>${a.reply}</p></p>`;
			msg+=	`</div>`;
			msg+=`</li>`;
		})
		replyUL.innerHTML=msg;
		document.querySelectorAll(".panel-footer-body li").forEach(
			a=>{
				a.addEventListener('click',(e)=>{
					modifyModalPage(e.currentTarget);
				})
			}
		)
	})
}

function myDate(format){
	let date = new Date(format);
	return date.getFullYear()+"/"+formatting(date.getMonth()+1)+"/"+formatting(date.getDate());
}
function formatting(string){
	string = String(string);
	if(string.length==1){
		string = "0"+string;
	}
	return string;
}

// ----------------모달 관련 스크립트---------------------
const modal = document.querySelector("#modal");
const inputReply = document.querySelector("input[name='reply']");
const inputReplyer = document.querySelector("input[name='replyer']");
const inputReplydate = document.querySelector("input[name='replydate']");
const addReplyBtn = document.querySelector("#addReplyBtn");
const modifyReplyBtn = document.querySelector("#modifyReplyBtn");
const removeReplyBtn = document.querySelector("#removeReplyBtn");

function openModal(){
	modal.style.display="block";
}
function closeModal(){
	modal.style.display="none";
}
function registerModalPage(){
	openModal();
	// 보여질 목록 수정
	regReplyModalStyle();
	// input 내용 초기화
	inputReply.value='';
	inputReplyer.value='';
}
function regReplyModalStyle(){
	modifyReplyBtn.classList.add('hide');
	removeReplyBtn.classList.add('hide');
	inputReplydate.closest("div").classList.add('hide');
	inputReplyer.removeAttribute('readonly');
	addReplyBtn.classList.remove('hide');
}
function registerReply(){
	if(!inputReply.value){
		alert("댓글을 입력해주세요");
		inputReply.focus();
		return;
	}
	if(!inputReplyer.value){
		alert("작성자를 입력해주세요");
		inputReplyer.focus();
		return;
	}
	rs.add({
		reply:inputReply.value,
		replyer:inputReplyer.value,
		bno:f.bno.value
	},function(data){
		closeModal();
		showList();
	})
}
// 댓글 리스트 클릭 이벤트
let rno;
function modifyModalPage(li){
	openModal();
	modifyReplyModalStyle();
	rno = li.getAttribute('data-rno');
	rs.get(rno,result=>{
		inputReply.value=result.reply;
		inputReplydate.value=myDate(result.replyDate)
		inputReplyer.value=result.replyer;
	})
}
function modifyReplyModalStyle(){
	inputReplydate.closest("div").classList.remove('hide');
	modifyReplyBtn.classList.remove('hide');
	removeReplyBtn.classList.remove('hide');
	addReplyBtn.classList.add('hide');
	inputReplyer.setAttribute('readonly',true);
	inputReplydate.setAttribute('readonly',true);
	inputReply.value='';
	inputReplydate.value='';
	inputReplyer.value='';
}
function modifyReply(){
	if(!inputReply.value){
		alert('댓글을 입력해주세요');
		inputReply.focus();
		return;
	}
	if(rno||rno==0){
		rs.update(rno,{
			reply:inputReply.value
		},
			result=>{
			alert(result);
			closeModal();
			showList();
		})
	}
}
function removeReply() {

	if(rno||rno==0){
		rs.remove(f.bno.value, rno,result=>{
			alert(result);
			closeModal();
			showList();
		})
	}
}

//-------------------------첨부 파일 스크립트-----------------------

fetch(`/board/getAttachList/${f.bno.value}`)
.then(response=>response.json())
.then(result=>console.log(result))
.catch(err=>console.log(err));
