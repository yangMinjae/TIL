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
		<button onclick="send1()">안녕</button>
		<button onclick="send2()">hello</button>
	</div>
</body>
<script type="text/javascript">
	function send1() {
		location.href="/chapter15_MVC3/hangeul.do"
	}
	function send2() {
		location.href="/chapter15_MVC3/english.do"
	}
</script>
</html>