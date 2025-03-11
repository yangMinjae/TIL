<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String id = null;
	Cookie[] a = request.getCookies();
	if(a!=null&&a.length>0){
		for(int i=0;i<a.length;i++){
			if(a[i].getName().equals("save_id")){
				id=URLDecoder.decode(a[i].getValue(),"utf-8");	
				break;
			}
		}
	}
%>
</head>
<body>
	<form action="Practice_id_check2.jsp">
	<%if(id!=null){%>
	아이디 : <input type="text" name="id" value="<%=id %>">
	<%}else{%>
	아이디 : <input type="text" name="id">
	<%} %>
	<br><br>
		<input type="checkbox" name="save_id"> 아이디 기억하기 <br>
		<input type="submit">
	</form>
</body>
</html>