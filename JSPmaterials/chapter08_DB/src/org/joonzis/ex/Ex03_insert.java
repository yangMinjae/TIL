package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnect;

public class Ex03_insert {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "insert into sample(no, name, reg_date) " + 
					" values(sample_seq.nextval, ?, sysdate)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "김씨");
			int result = ps.executeUpdate();
			if(result > 0) {
				System.err.println("데이터 추가 완료");
				conn.commit();
			}else {
				System.out.println("데이터 추가 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
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





