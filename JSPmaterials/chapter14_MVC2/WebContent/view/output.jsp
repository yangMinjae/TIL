<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. request확인</h2>
	<ul>
		<li>이름 : ${requestScope.name } </li>
		<li>나이 : ${requestScope.age } </li>
		<li>번호 : ${requestScope.phone } </li>
		<li>주소 : ${requestScope.addr } </li>
		<li>자기 소개 : ${requestScope.self } </li>
	</ul>
	
	<h2>2. session확인</h2>
	<ul>
		<li>이름 : ${sessionScope.name } </li>
		<li>나이 : ${sessionScope.age } </li>
		<li>번호 : ${sessionScope.phone } </li>
		<li>주소 : ${sessionScope.addr } </li>
		<li>자기 소개 : ${sessionScope.self } </li>
	</ul>
	
	<h2>3. vo확인</h2>
	<ul>
		<li>이름 : ${vo.name } </li>
		<li>나이 : ${vo.age } </li>
		<li>번호 : ${vo.phone } </li>
		<li>주소 : ${vo.addr } </li>
		<li>자기 소개 : ${vo.self } </li>
	</ul>
	
	<h2>4. map확인</h2>
	<ul>
		<li>이름 : ${map.name } </li>
		<li>나이 : ${map.age } </li>
		<li>번호 : ${map.phone } </li>
		<li>주소 : ${map.addr } </li>
		<li>자기 소개 : ${map.self } </li>
	</ul>
</body>
</html>