package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnect;

public class Ex05_delete {
	// no가 1인 데이터 삭제
public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "delete from sample where no=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("데이터 삭제 완료!");
			}else {
				System.out.println("데이터 삭제 실패!");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				if(conn!=null)conn.rollback();
			} catch (Exception e2) {
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
}
