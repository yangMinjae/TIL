<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type1 = request.getParameter("type1");		// name
	// String type2 = request.getParameter("type2");		// age
	session.removeAttribute(type1);					// name 속성 삭제
	// session.removeAttribute(type2);					// age 속성 삭제
	response.sendRedirect("Ex06_01_session.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>