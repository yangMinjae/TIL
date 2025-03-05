<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>페이지 이동 중간 페이지</h1>
	<div>이름 : <%=name %></div>
	<div>나이 : <%=age %></div>
	
	<br> <hr> <br>
	<!-- 1. a 태그로 이동하기 -->
	<!-- 파라미터 전달 x -->
	<a href="Ex05_03_page_move.jsp">파라미터x</a>
	<!-- 파라미터 전달 o -->
	<a href="Ex05_03_page_move.jsp?name=<%=name %>&age=<%=age %>">파라미터o</a>
	<br> <hr> <br>
	
	<!-- 2. location 객체로 이동하기-->
	<button onclick="location.href='Ex05_03_page_move.jsp'">파라미터x</button>
	<button onclick="location.href='Ex05_03_page_move.jsp?name=<%=name%>&age=<%=age%>'">파라미터o</button>
	
	<!-- 3. forward로 이동하기 -->
	<%
		// request.getRequestDispatcher("Ex05_03_page_move.jsp").forward(request, response);
		// 01에서 부터 넘어온 request객체를 그대로 재활용
		// forward의 특징: 페이지는 넘어가지만 주소는 그대로
	%>
	<br> <hr> <br>
	
	<!-- 4. redirect로 이동하기 -->
	<%
		// response.sendRedirect("Ex05_03_page_move.jsp");
		// 얘는 url 변경됨.
	%>
</body>
</html>