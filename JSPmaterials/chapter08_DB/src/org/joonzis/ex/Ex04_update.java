package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnect;

public class Ex04_update {
	// 김씨 이름을 "박씨"로 변경
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "update sample set name=? where name ='김씨'";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "박씨");
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("데이터 수정 완료!");
			}else {
				System.out.println("데이터 수정 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
