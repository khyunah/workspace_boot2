package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "shopdb";
	private static final String DB_CAHRSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	//
	private Connection conn;

	// 싱글톤 처리
	private static DBClient dbClient;

	// 외부 클래스에서 생성하지 못하도록 생성자를 private 
	private DBClient() {}

	// 프로그램이 실행되자마자 메모리에 올라가서 코드 실행되어
	// dbClient에 생성자의 주소가 담기는 것.
	public static DBClient getInstance() {
		if (dbClient == null) {
			dbClient = new DBClient();
		}
		return dbClient;
	}

	public Connection getConnection() {
		if (conn == null) {
			// "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CAHRSET);

			try {
				// MYSQL JDBC 드라이버 클래스를 로딩해서 드라이버매니저 클래스에 등록하기
				Class.forName("com.mysql.cj.jdbc.Driver"); // ㅡ> 힙메모리에 올려줌
				// DriverManager 객체를 사용해서 DB서버에 접근할수 있어짐.

				// 접속 연결 ( 소켓의 스트림 꺼내는것과 같은 )
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");

			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		return conn;
	}

	public void connectionClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn = null;
		}
	}
}
