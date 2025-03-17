<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="now" value="<%=new Date() %>"/>
	<h3>fromatDate의 타입</h3>
	date타입 : <fmt:formatDate value="${now }" type="date"/> <br>
	time타입 : <fmt:formatDate value="${now }" type="time"/> <br>
	both타입 : <fmt:formatDate value="${now }" type="both"/> <br>
	
	<hr>
	
	<h3>formatDate의 스타일</h3>
	default : <fmt:formatDate value="${now }" type="both" dateStyle="default" timeStyle="default"/> <br>
	short : <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/> <br>
	medium : <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/> <br>
	<!-- 디폴트 = 미디엄 -->
	long : <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/> <br>
	full : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/> <br>
	
	<hr>
	
	<h3>formatDate의 패턴</h3>
	사용자 패턴 : <fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 E요일 a hh:mm:ss"/>
</body>
</html>