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
	이름 : <c:out value="${name }"/> <br>
	주소 : <c:out value="${addr }"/> <br>
	전화번호 : <c:out value="${phone }"/> <br>
</body>
</html>