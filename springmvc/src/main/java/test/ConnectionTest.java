package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		//127.0.0.1 : 로컬호스트
		String url = "jdbc:mysql://127.0.0.1:3306/exam?serverTimezone=UTC";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "root";
		String password = "1234";
		try {
			//1. 드라이버로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공!!");
			//2. DB서버에 접속하기
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션성공!!:"+con);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패!!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}








