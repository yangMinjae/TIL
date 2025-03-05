package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex02_update {

	public static void main(String[] args) {
		
		// 김씨의 나이를 100 살로
		// 지역을 '마포'로 변경
		
		// Ex03_delete.java 에서는
		// 김씨 데이터 삭제
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn=DBConnection.getConnection();
			String sql = "UPDATE PERSON SET AGE = ?, REGION = ? WHERE NAME = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 100);
			ps.setString(2, "마포");
			ps.setString(3, "김씨");
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("데이터 수정 성공");
			}else {
				System.out.println("데이터 수정 실패");
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
