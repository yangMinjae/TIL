<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		이름 : <input type="text" name="name"> <br>
		국어 : <input type="number" name="kor"><br>
		영어 : <input type="number" name="eng"><br>
		수학 : <input type="number" name="mat"><br>
		<input type="button" value="전송" onclick="send(this.form);">
	</form>
</body>
<script type="text/javascript">
	function send(f) {
		if(!f.name.value){
			alert("이름을 입력해주세요.");
			f.name.focus();
			return;
		}
		if(!f.kor.value){
			alert("수학 점수를 입력해주세요.");
			f.kor.focus();
			return;
		}
		if(!f.eng.value){
			alert("영어 점수를 입력해주세요.");
			f.eng.focus();
			return;
		}
		if(!f.mat.value){
			alert("수학 점수를 입력해주세요.");
			f.mat.focus();
			return;
		}
		f.action="Ex05_servlet";
		f.submit();
	}
</script>
</html>