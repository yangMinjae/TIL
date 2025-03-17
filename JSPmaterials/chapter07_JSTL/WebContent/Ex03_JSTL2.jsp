<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="${param.num1+0}"/>
	<c:set var="num2" value="${param.num2+0}"/>
	첫번째 수 : <c:out value="${num1}"/> <br>
	두번째 수 : <c:out value="${num2}"/> <br>
	
	<hr>
	<h1>EL을 이용하여 큰 수 출력하기 ( 삼항 연산자 )</h1>
	큰 수 : <c:out value="${num1>num2?num1:num2}"></c:out>
	<h1>JSTL을 이용하여 큰 수 구하기</h1>
	<c:if test="${num1>num2}">
		${num1}
	</c:if>
	<c:if test="${num1<num2}">
		${num2}
	</c:if>
	<!-- parameter로 넘어온 형식은 문자열이므로 제대로 된 비교가 이루어 지지 않는다. -->
	
	<h1>JSTL을 이용하여 큰 수 구하기2</h1>
	<c:choose>
		<c:when test="${num1>num2}">
			${num1}
		</c:when>
		<c:otherwise>
			${num2}
		</c:otherwise>
	</c:choose>
	
</body>
</html>