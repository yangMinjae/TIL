<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO dao = MemberDAO.getInstance();
	String id = request.getParameter("id");
	MemberVO vo1 = new MemberVO();
	vo1.setId(id);
	MemberVO vo = dao.getUserInfoByid(vo1); 
	pageContext.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<jsp:include page="index.jsp"/>
 	
 	<br> <hr> <br>
 	 <table>
      <thead>
         <tr>
            <th>회원번호</th>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>주소</th>
            <th>가입일</th>
         </tr>
      </thead>
      <tbody>
      	<c:choose>
      		<c:when test="${vo==null}">
      			<tr>
            		<td colspan="7">member 데이터가 없습니다. </td>
         		</tr>
      		</c:when>
      		<c:otherwise>
            	<tr>
               		<td>${vo.idx }</td>
			        <td>${vo.id }</td>
			        <td>${vo.pw }</td>
			        <td>${vo.name }</td>
			        <td>${vo.age }</td>
			        <td>${vo.addr }</td>
			        <td>${vo.regdate }</td>
          		</tr>	
      		</c:otherwise>
      	</c:choose>

      </tbody>
   </table>
</body>
</html>
