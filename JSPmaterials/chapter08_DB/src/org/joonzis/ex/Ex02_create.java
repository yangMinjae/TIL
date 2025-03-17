package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnect;

public class Ex02_create {
	// 시퀀스 생성
	// sample_seq (시작 값 1, 증가 값 1)
	
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "create sequence sample_seq "
					+ "start with 1 increment by 1";
			
			ps = conn.prepareStatement(sql);
			ps.execute();
			System.out.println("sample_seq 시퀀스 생성 성공");
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
