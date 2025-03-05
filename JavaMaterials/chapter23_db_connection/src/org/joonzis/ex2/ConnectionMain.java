package org.joonzis.ex2;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionMain {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 오류");
		}catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

}
