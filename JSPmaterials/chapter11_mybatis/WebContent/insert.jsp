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
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(Integer.parseInt(age));
	vo.setAddr(addr);
	
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.insert(vo);
	pageContext.setAttribute("result", result);
%>
	<c:choose>
		<c:when test="${result > 0 }">
			<script type="text/javascript">
				alert("멤버 등록에 성공했습니다.");
				location.href='view_all.jsp';
			</script>	
		</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("멤버 등록에 실패했습니다.");
			location.href='view_all.jsp';
		</script>
	</c:otherwise>
	</c:choose>
</head>
<body>
	
</body>
</html>