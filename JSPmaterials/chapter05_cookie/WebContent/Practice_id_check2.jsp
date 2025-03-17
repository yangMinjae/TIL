<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Cookie cookie = null;
	String id = request.getParameter("id");
	String save_id = request.getParameter("save_id");
	if(save_id!=null){
		cookie = new Cookie("save_id",URLEncoder.encode(id,"utf-8"));
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}else{
		cookie = new Cookie("save_id",id);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
%>
</head>
<body>
	<a href="Practice_id_check1.jsp">로그인 화면으로 이동</a>
</body>
</html>