<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 최소, 최대 값 화면에 출력 -->
	<c:set var="num1" value="${param.num1+0}"/>
	<c:set var="num2" value="${param.num2+0}"/>
	<c:set var="min" value="${num1>num2?num2:num1}"/>
	<c:set var="max" value="${num1>num2?num1:num2}"/>
	<%
		String[] foods=request.getParameterValues("foods");
		pageContext.setAttribute("foods", foods);
	%>
	<h3>최소 : ${min}</h3>
	<h3>최대 : ${max}</h3>
	<!-- 2. 최소 값 부터 최대 값 까지 1 씩 증가하는 값 출력 -->
	<h3>사이의 값 출력</h3>
	<c:forEach var="i" begin="${min}" end="${max}" step="1">
		${i} <br>
	</c:forEach>
	<!-- 3. 향상 forEach를 이용하여 음식 종류 출력 -->
	<h3>좋아하는 음식</h3>
	<c:forEach var="item" items="${foods}">
		${item } <br>
	</c:forEach>
	<h3>좋아하는 음식2</h3>
	<c:forEach var="item" items="${paramValues.foods}">
		${item } <br>
	</c:forEach>
</body>
</html>