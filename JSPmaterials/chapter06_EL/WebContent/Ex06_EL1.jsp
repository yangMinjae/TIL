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
		String[] arr = {"노래", "춤", "음주"};
		request.setAttribute("HOBBIES", arr);
		request.getRequestDispatcher("Ex06_EL2.jsp").forward(request, response);
	
	%>
</body>
</html>





