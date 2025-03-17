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
	<c:set var="kor" value="${param.kor+0}"/>
	<c:set var="eng" value="${param.eng}"/>
	<c:set var="mat" value="${param.mat}"/>
	<c:set var="avg" value="${(kor+eng+mat)/3}"/>
	<c:set var="pass" value="합격"></c:set>
	<c:choose>
		<c:when test="${avg>=90}">
			<c:set var="grade" value="A"/>
		</c:when>
		<c:when test="${avg>=80 }">
			<c:set var="grade" value="B"/>
		</c:when>
		<c:when test="${avg>=70 }">
			<c:set var="grade" value="C"/>
		</c:when>
		<c:when test="${avg>=60 }">
			<c:set var="grade" value="D"/>
		</c:when>
		<c:otherwise>
			<c:set var="grade" value="F"/>
			<c:set var="pass" value="불합격"/>			
		</c:otherwise>
	</c:choose>
	국어 : <c:out value="${kor}"/> <br>
	영어 : <c:out value="${eng}"/> <br>
	수학 : <c:out value="${mat}"/> <br>
	평균 : <c:out value="${avg}"/> <br>
	PASS/FAIL : <c:out value="${pass}"/> <br>
</body>
</html>