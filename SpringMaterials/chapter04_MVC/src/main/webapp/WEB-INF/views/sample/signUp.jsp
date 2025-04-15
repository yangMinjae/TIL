<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form method="post" action="/smaple/signUp">
			<table>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>아이디 : </td>
					<td><input type="text" name="id"></td>
					<td><input type="button" name="idValidate" value="중복 확인"></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 : </td>
					<td><input type="password" name="pwCheck"></td>
				</tr>
				<tr>
					<td><input type="button" value="초기화" name="reset"></td>
					<td><input type="button" value="전송" name="submit"></td>
				</tr>
			</table>
			
		</form>
	</div>
	<input type="button" id="main" value="메인 화면">
</body>
<script type="text/javascript" src="/resources/js/signUp.js"></script>
</html>