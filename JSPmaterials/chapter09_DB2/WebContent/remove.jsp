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
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=DBConnect.getConnection();
			String sql = "DELETE FROM MEMBER WHERE ID=? AND PW=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			int result = ps.executeUpdate();
			if(result>0){
				request.setAttribute("delete", "true");
			}else{
				request.setAttribute("delete", "false");				
			}
			request.getRequestDispatcher("view_all.jsp").forward(request, response);
			conn.commit();
		}catch(Exception e){
			try{
			if(conn!=null)conn.rollback();				
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}finally{
			try{
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>