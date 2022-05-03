package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MainTest {

	// DB 서버와 연결하기 위한 준비물
	private Connection conn; // DB 커넥션 연결 객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
	// 프로토콜 / 본인 ip:포트번호 /
	// 데이터베이스이름?serverTimezone=Asia/Seoul&characterEncoding=UTF-8

	// SQL문을 실행하고 그 결과를 반환해주는 녀석 Statement
	// 하나의 Statement는 하나의 결과에 대해서만 열려있다. 다른게 열려있다면 인터페이스가 자동으로 닫아줌 
	private Statement stmt; // String으로 쿼리문 작성할건데 String을 쿼리문으로 변경해주는 녀석
	private ResultSet rs; // 결과값을 받아주는 녀석, 행단위로 결과를 들고온다.
	

	public MainTest() {

		try {
			// reflect 기법 ㅡ> 컴파일 시점의 문자열을 런타임 시점에 실제 클래스가 존재하는지 확인
			// 메모리 (heap) 영역에 올라간다.
			// Class ㅡ> 생성자가 없는데 메소드를 호출하면 자동으로 생성자가 실행된다.
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Driver driver = new Driver();

			// DBMS와 연결을 한것
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			// 자바에서 작성한 String의 쿼리문을 데이터베이스로 보내주는 녀석 
			stmt = conn.createStatement();
			// 쿼리문을 날리고
			String sql1 = "select * from membertbl";
			// 결과를 rs에 저장
			rs = stmt.executeQuery(sql1);
			
			while (rs.next()) {
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
				System.out.println("id : " + memberId + ", " + "name : " + memberName);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// 코드의 시작점
	public static void main(String[] args) {
		new MainTest();
	} // end of main
}
