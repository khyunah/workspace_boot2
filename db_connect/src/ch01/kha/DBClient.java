package ch01.kha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

// DBClient 재활용성 높이기 
// 데이터 베이스이름을 입력받아서 DB연결하기 
@Getter
@Setter
public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_CAHRSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";
	private String databaseName;

	private Connection conn;

	private static DBClient dbClient;

	private DBClient(String databaseName) {
		this.databaseName = databaseName;
	}

	public static DBClient getInstance(String databaseName) {
		if (dbClient == null) {
			dbClient = new DBClient(databaseName);
		}
		return dbClient;
	}

	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, databaseName, DB_CAHRSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

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
