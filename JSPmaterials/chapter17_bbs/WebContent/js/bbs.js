function moveInsertPage(){
	location.href="BBSController?cmd=insertBBSPage";	
}
function view_all(){
	location.href="BBSController?cmd=allList";
}
function insert(f){
	if(!f.writer.value){
		alert("작성자를 입력해 주세요");
		f.writer.focus();
		return;
	}
	if(!f.title.value){
		alert("제목을 입력해 주세요");
		f.title.focus();
		return;
	}
	if(!f.pw.value){
		alert("비밀번호를 입력해 주세요");
		f.pw.focus();
		return;
	}
	if(!f.content.value){
		alert("내용를 입력해 주세요");
		f.content.focus();
		return;
	}
	f.action="BBSController"
	f.submit();
}
function removeBBS(i){
	let remove = confirm("정말로 삭제하시겠습니까?");
	if(remove){		
	location.href="BBSController?cmd=removeBBS="+i;
	}
}
function updatePage(){
	location.href="BBSController?cmd=updatePage";
}
function update(f, pw){
	if(!f.title.value){
		alert("제목을 입력해 주세요");
		f.title.focus();
		return;
	}
	console.log(pw);
	if(!f.pw.value){
		alert("비밀번호를 입력해주세요");
		f.pw.focus();
		return;
	}
	if(f.pw.value!=pw){
		alert("비밀번호가 일치하지 않습니다.");
		f.pw.focus();
		return;
	}
	if(!f.content.value){
		alert("내용를 입력해 주세요");
		f.content.focus();
		return;
	}
	f.action="BBSController";
	f.submit();
}