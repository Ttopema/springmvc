package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 커넥션관리 자원반납 모든 DB관련 메소드에서 공통으로 처리하는 부분을 구현
 * 
 * DB연동과 관련된 기능을 유틸리티처럼 제공하는 클래스
 * 1. 드라이버로딩
 * 2. DB서버연결
 * 3. 자원반납
 */
public class DBUtil {
	//드라이버로딩 - DBUtil클래스가 로딩될때 자동으로 드라이버가 로딩되도록 작업
	//=> static{}에 정의한 코드는 DBUtil클래스가 클래스로더에 의해 메모리에 로딩될때 자동으로 실행된다.
	//   따라서 코드가 한 번 실행되도록 할 수 있다.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩실패!!");
			e.printStackTrace();
		}
	}
	//DB서버에 연결하고 Connection을 리턴하는 메소드
	public static Connection getConnect() {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
		String user = "exam";
		String password = "exam";
		Connection con= null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//자원반납을 위한 메소드
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


















