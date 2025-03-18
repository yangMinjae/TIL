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
	MemberVO vo = new MemberVO();
	MemberDAO dao = MemberDAO.getInstance();
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	int idx = Integer.parseInt(request.getParameter("idx"));
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(age);
	vo.setAddr(addr);
	vo.setIdx(idx);
	int result = dao.update(vo);
	pageContext.setAttribute("result", result);
%>
<c:choose>
		<c:when test="${result>0 }">
			<script>
				alert("데이터 수정 성공!");
				location.href="view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("데이터 수정 실패!");
				location.href="view_all.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>