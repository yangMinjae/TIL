<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.joonzis.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// 전달 받은 파라미터들을 가지고 insert
	// 데이터 삽입이 성공/실패
	// view_all.jsp로 이동(데이터 삽입 확인 용도)
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	Connection conn = null;
	PreparedStatement ps = null;
	try{
		conn=DBConnect.getConnection();
		String sql = "insert into member values(member_seq.nextval, ?,?,?,?,?,sysdate)";
		
		ps=conn.prepareStatement(sql);
		ps.setString(1,id);
		ps.setString(2,pw);
		ps.setString(3,name);
		ps.setInt(4, Integer.parseInt(age));
		ps.setString(5,addr);
		
		int result = ps.executeUpdate();
		if(result>0){
			System.out.println("데이터 추가 완료");
			conn.commit();
		}else{
			System.out.println("데이터 추가 실패");
		}
		response.sendRedirect("view_all.jsp");
	} catch (Exception e) {
		e.printStackTrace();
		try {
			conn.rollback();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		response.sendRedirect("view_all.jsp");
	} finally {
		try {
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
%>
</head>
<body>

</body>
</html>