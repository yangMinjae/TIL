package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex03_delete {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "DELETE FROM PERSON WHERE NAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "김씨");
			
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println(result);
				System.out.println("데이터 삭제 성공");
			}else {
				System.out.println("데이터 삭제 실패");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				if(conn!=null) {
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
