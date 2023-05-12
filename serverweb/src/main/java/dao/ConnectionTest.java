package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		//127.0.0.1 : 로컬호스트
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "exam";
		String password = "exam";
		
		try {
			//1.드라이버로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!!");
			//2.DB서버에 접속하기
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션 성공!!" + con); //mysql객체가 연결된다. //oracle객체가 연결된다.
													//즉, 리턴타입의 다형성이 적용되었다!!
													//어떤 객체가 매핑되었냐에 따라 다르게 값을 리턴하기 때문이다!!
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
