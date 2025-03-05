package org.joonzis.ex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Ex01_Connection {
	public static void main(String[] args) {
		
		// 1. Connection 객체
		Connection conn = null;
		
		try {
			// 2. Oracle jdbc 드라이브 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 3. 접속 정보 생성
			String user = "scott";
			String password = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			// 4. DriverManager : 자바를 오라클 jdbc에 연결 시켜주는 클래스
			conn = DriverManager.getConnection(url,user,password);
			
			// 5. 연결 확인 메세지
			System.out.println("DB 연결 성공");
			
			// 6. 접속 종료
			conn.close();
			
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 오류");
		}catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
}
