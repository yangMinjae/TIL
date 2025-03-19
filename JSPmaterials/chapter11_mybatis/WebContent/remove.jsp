<%@page import="org.joonzis.ex.MemberDAO"%>
<%@page import="org.joonzis.ex.MemberVO"%>
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
	<%
		MemberDAO dao = MemberDAO.getInstance(); 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		int result = dao.remove(vo);
		pageContext.setAttribute("result", result);
	%>
	<c:choose>
		<c:when test="${result>0 }">
			<script>
				alert("데이터 삭제 성공!");
				location.href="view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("데이터 삭제 실패!");
				location.href="view_all.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>