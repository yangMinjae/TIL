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
	<form action="Ex06_JSTL2.jsp">
		<h3>일반 forEach</h3>
		<p>최소 크기 : <input type="number" name="num1"> </p>
		<p>최대 크기 : <input type="number" name="num2"> </p>
		<hr>
		<h3>향상 forEach</h3>
		<input type="checkbox" name="foods" value="한식"> 한식
		<input type="checkbox" name="foods" value="중식"> 중식
		<input type="checkbox" name="foods" value="일식"> 일식
		<input type="checkbox" name="foods" value="양식"> 양식
		<input type="checkbox" name="foods" value="분식"> 분식
		<br>
		<button>전송</button>
	</form>
</body>
</html>