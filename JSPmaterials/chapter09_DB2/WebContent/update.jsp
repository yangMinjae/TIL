
<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	public static void update(String a, String b, int idx){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "update member set "+a+"=? where idx = ?";
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, b);
			ps.setInt(2, idx);
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("데이터 수정 완료!");
				conn.commit();
			}else {
				System.out.println("데이터 수정 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try{
			conn.rollback();				
			}catch(Exception e2){	
				e2.printStackTrace();
			}
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
%>
</head>
<body>
	<%	
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");

		if(pw!=null && !pw.equals("")){
			update("pw", pw, idx);
		}
		if(name!=null && !name.equals("")){
			update("name", name, idx);
		}
		if(age!=null && !age.equals("")){
			update("age", age, idx);
		}
		if(addr!=null && !addr.equals("")){
			update("addr" , addr, idx);
		}
		response.sendRedirect("view_all.jsp");


	%>
</body>
</html>