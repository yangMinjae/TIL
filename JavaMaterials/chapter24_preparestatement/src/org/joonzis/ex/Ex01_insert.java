package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex01_insert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			// 주의!! 띄어쓰기, 세미콜론(삭제)
			String sql = "insert into person values(?,?,?)";
			
			ps = conn.prepareStatement(sql);
			// ? 에 데이터 set
			ps.setString(1, "김씨");
			ps.setInt(2, 50);
			ps.setString(3, "부산");
			
			int result = ps.executeUpdate();
			
			if(result >0) {
				System.out.println("데이터 삽입 성공");
			}else {
				System.out.println("데이터 삽입 실패");
			}
			conn.commit();
		}catch (Exception e) {
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {				
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
