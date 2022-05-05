package ch01.kha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	// DB 연결을 하기 위한 준비물

	// DB 계정 접속 정보
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	// 연결 객체
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public DBConnectionTest() {
		try {
			// 매개변수의 클래스를 로드해준다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 커넥션 연결 ( 소켓의 스트림 연결하는 것과 같은 맥락 )
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			// 자바에서 작성한 문자열을 데이터베이스의 쿼리문으로 바꿔주는 역할
			stmt = conn.createStatement();

			// 문자열의 쿼리문을 보내서 결과 저장하기 
			String sql = "SELECT * FROM studenttbl";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String studName = rs.getString("studName");
				String major = rs.getString("major");
				System.out.println("studName : " + studName + ", major : " + major);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DBConnectionTest();
	}
}
