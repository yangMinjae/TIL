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