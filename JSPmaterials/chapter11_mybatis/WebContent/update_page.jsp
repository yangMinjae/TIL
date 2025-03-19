<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MemberDAO dao = MemberDAO.getInstance(); 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberVO vo1 = new MemberVO();
	vo1.setId(id);
	vo1.setPw(pw);
	MemberVO vo = dao.getUpdateView(vo1);
	pageContext.setAttribute("vo", vo);
%>
<body>
	<jsp:include page="index.jsp"/>
	<br> <hr> <br>
	<form action="update.jsp">
		<table>
		<thead> 
			<tr> 
				<td>회원번호</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>주소</td>
				<td>가입일</td>
			</tr>
		</thead>
		<tbody>
			<tr> 
				<c:choose>
					<c:when test="${vo!=null }">
			               <td>${vo.idx }</td>
			               <td> ${vo.id }</td>
			               <td> <input type="text" name="pw" value="${vo.pw }"> </td>
			               <td> <input type="text" name="name" value="${vo.name }"> </td>
			               <td> <input type="text" name="age" value="${vo.age }"> </td>
			               <td> <input type="text" name="addr" value="${vo.addr }"> </td>
			               <td>${vo.regdate }</td>
			               <td hidden="true"> <input type="hidden" name="idx" value="${vo.idx}">  </td>
					</c:when>
					<c:otherwise>
						<td colspan="7">데이터 없음</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
		<tfoot>
            <tr>
               <th colspan="7">
                  <input type="button" value="수정" onclick="update(this.form)">&nbsp;&nbsp;
                  <input type="reset" value="다시 작성">
               </th>
            </tr>
		</tfoot>
	</table>
	</form>
</body>
	<script type="text/javascript">
		function update(f){
			if(!f.pw.value || !f.name.value || !f.age.value || !f.addr.value){
				alert("공란이 존재합니다. 값을 입력해주세요");
				return;
			}
			f.submit();
		}
	</script>
</html>