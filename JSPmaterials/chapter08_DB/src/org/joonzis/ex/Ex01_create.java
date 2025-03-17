package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnect;

public class Ex01_create {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnect.getConnection();
			
			String sql = "create table sample("
					+ "    no number primary key,"
					+ "    name varchar2(20) not null,"
					+ "    reg_date date not null"
					+ ")";
			
			ps = conn.prepareStatement(sql);
			ps.execute();
			System.out.println("sample 테이블 생성 성공");
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
