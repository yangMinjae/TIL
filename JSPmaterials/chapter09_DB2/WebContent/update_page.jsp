<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	<br> <hr> <br>
	<h2>데이터 수정</h2>
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
				<%
					request.setCharacterEncoding("utf-8");
					String id = request.getParameter("id");
					String pw = request.getParameter("pw");
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					try{
						conn=DBConnect.getConnection();
						String sql = "select * from member where id = ? and pw = ?";
						ps=conn.prepareStatement(sql);
						ps.setString(1, id);
						ps.setString(2, pw);
						rs=ps.executeQuery();
						if(!rs.next()){%>
							<td colspan="7">데이터 없음</td>
						<%}else{%>
			               <td><%=rs.getInt(1) %></td>
			               <td><%=rs.getString(2) %></td>
			               <td> <input type="text" name="pw"> </td>
			               <td> <input type="text" name="name"> </td>
			               <td> <input type="text" name="age"> </td>
			               <td> <input type="text" name="addr"> </td>
			               <td> <%=rs.getString(7) %> </td>
			               <td hidden="true"> <input type="hidden" name="idx" value="<%=rs.getInt(1) %>">  </td>
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
			if(f.pw.value || f.name.value || f.age.value || f.addr.value){
				f.submit();
			}else{
				alert("최소 한개 필드의 값을 입력하세요");
			}
		}
	</script>
</html>