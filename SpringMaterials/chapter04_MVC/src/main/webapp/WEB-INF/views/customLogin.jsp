<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<h2>${error }</h2>
	<h2>${logout }</h2>
	
	<form action="/login" method="post">
		<div>
			아이디 : <input type="text" name="username">
		</div>
		<div>
			비밀번호 : <input type="password" name="password">
		</div>
		<br>
		<div>
			<input type="checkbox" name="remember-me">자동 로그인
		</div>
		<div><input type="submit"></div>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
		<input type="button" id="main" value="메인 화면">
</body>
<script type="text/javascript">
const main = document.querySelector("#main");
main.addEventListener('click',()=>{
  location.href="/";
})
</script>
</html>