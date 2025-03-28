<%@page import="java.sql.ResultSet"%>
<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"/>

	<br> <br> <hr>
	
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
				<%
					request.setCharacterEncoding("utf-8");
					String id = request.getParameter("id");
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					try{
						conn=DBConnect.getConnection();
						String sql = "select * from member where id = ?";
						ps=conn.prepareStatement(sql);
						ps.setString(1, id);
						rs=ps.executeQuery();
						if(!rs.next()){%>
							<td colspan="7">데이터 없음</td>
						<%}else{%>
			               <td><%=rs.getInt(1) %></td>
			               <td><%=rs.getString(2) %></td>
			               <td><%=rs.getString(3) %></td>
			               <td><%=rs.getString(4) %></td>
			               <td><%=rs.getInt(5) %></td>
			               <td><%=rs.getString(6) %></td>
			               <td><%=rs.getDate(7) %></td>
						<%}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						try{
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();			
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				%>
			</tr>
		</tbody>
	</table>

</body>
</html>