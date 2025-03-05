
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String tel = request.getParameter("tel");
	String[] hobbies = request.getParameterValues("hobbies");
	String addr = request.getParameter("addr");
	String foods = request.getParameter("foods");
	// out.print("내용"); // 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이용자 정보</h1>
	<ul>
		<li>이름 : <%=name %></li>
		<li>나이 : <%=age %></li>
		<li>전화번호 : <%=tel %></li>
		<li>성별 : <%=gender %></li>
		<li>취미 : 
		<% if(hobbies!=null){
			for(int i = 0; i< hobbies.length;i++){%>
				<%=hobbies[i]%>
			<% }
		}else{%>
			없음
		<%}%>
		</li>
	</ul>
</body>
</html>