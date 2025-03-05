<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		아이디 <input type="text" name="id"> <br>
		비밀번호 <input type="password" name="pw"> <br>
		이름 <input type="text" name="name"><br>
		이메일 <input type="email" name="email"><br>
		성별 <input type="radio" name="gender" value="남">남 <input type="radio" name="gender" value="여">여<br>
		취미 <input type="checkbox" name="hobbies" value="게임"> 게임 <input type="checkbox" name="hobbies" value="영화"> 영화 <input type="checkbox" name="hobbies" value="수면"> 수면 <input type="checkbox" name="hobbies" value="운동"> 운동<br>
		<input type="button" onclick="send(this.form);" value="전송">
	</form>
</body>
<script type="text/javascript">
	function send(f) {
		if(!f.id.value){
			alert("아이디를 입력해주세요");
			f.id.focus();
			return;
		}
		if(!f.pw.value){
			alert("비밀번호를 입력해주세요");
			f.pw.focus();
			return;
		}
		if(!f.name.value){
			alert("이름을 입력해주세요");
			f.name.focus();
			return;
		}
		if(!f.email.value){
			alert("이메일을 입력해주세요");
			f.email.focus();
			return;
		}
		if(!f.gender.value){
			alert("성별을 선택해주세요");
			return;
		}
		let flag = false;
		for(let i of f.hobbies){
			if(i.checked){
				flag=true;
			}
		}
		if(!flag){
			alert("취미를 최소 한개 이상 선택해주세요.")
			return;
		}
		f.action="Ex04_servlet";
		f.submit();
	}
</script>
</html>