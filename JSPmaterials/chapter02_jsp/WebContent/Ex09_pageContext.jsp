<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpServletRequest httpRequest = (HttpServletRequest)pageContext.getRequest();
		// jsp가 아닌 java에서는 이렇게 써야한다.
	%>
	request 기본 객체와 pageContext.getRequest()의 동일 여부 :
	<%= httpRequest ==request %>
	<br>
	pageContext.getOut() 메소드를 사용한 데이터 출력 :
	<% pageContext.getOut().print("안녕하세요"); %>
</body>
</html>