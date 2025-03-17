<%@page import="org.joonzis.bean.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PersonVO vo = new PersonVO();
	vo.setName(request.getParameter("name"));
	vo.setAge(Integer.parseInt(request.getParameter("age")));
	vo.setHeight(Double.parseDouble(request.getParameter("height")));
	vo.setAddr(request.getParameter("addr"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>
	 	이름 : <%=vo.getName() %>
	 	나이 : <%=vo.getAge() %>
	 	키 : <%=vo.getHeight() %>
	 	주소 : <%=vo.getAddr() %>
	 </h1>
</body>
</html>

