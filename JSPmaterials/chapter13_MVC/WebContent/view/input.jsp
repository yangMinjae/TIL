<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<div>
		<h1>원하는 정보의 버튼을 클릭하시오.</h1>
		<button onclick="req_time()">현재 시간 확인</button>
		<button onclick="req_date()">현재 날짜 확인</button>
	</div>
</body>
<script type="text/javascript">
	function req_time() {
		location.href="/chapter13_MVC/Controller1";
	}
	function req_date(){
		location.href = "/chapter13_MVC/Controller2"
	}
</script>
</html>