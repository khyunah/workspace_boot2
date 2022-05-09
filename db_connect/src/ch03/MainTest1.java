package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch02.DBClient;

public class MainTest1 {

	public static void main(String[] args) {

		// object는 메인메소드에서 new하기 때문에 언제 태어나서 언제 죽을수 있는 것들을 말하고
		// static으로 만들어진 녀석들은 프로그램 시작과 끝으로만 처리된다.
		// DBClient.getInstance()
		DBClient client = DBClient.getInstance();
		Connection connection = client.getConnection();
		ResultSet resultSet = null;

		try {
			// 데이터 1건 조회
			String selectQuery1 = "SELECT * FROM membertbl WHERE memberId = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			// 숫자 1은 첫번째 물음표를 뜻함
			preparedStatement.setString(1, "jsa");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			System.out.println("----------------------");

			// 데이터 2건 조회
			String selectQuery2 = "SELECT * FROM membertbl WHERE memberId IN(?, ?)";
			preparedStatement = connection.prepareStatement(selectQuery2);
			preparedStatement.setString(1, "jsa");
			preparedStatement.setString(2, "Han");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			System.out.println("-----------------");

			// insert 데이터 등록
			String insertQuery = "INSERT INTO membertbl VALUES(?, ?, ?)";
//			preparedStatement = connection.prepareStatement(insertQuery);
//			preparedStatement.setString(1, "boot1");
//			preparedStatement.setString(2, "개발자1");
//			preparedStatement.setString(3, "서울판교1");
//
//			int resultCount = 0;
//			resultCount = preparedStatement.executeUpdate();
//
//			if (resultCount >= 1) {
//				System.out.println("정상 등록 되었습니다.");
//			} else {
//				System.out.println("동일한 아이디가 존재하거나, 잘못된 입력입니다.");
//			}
			
			// update 데이터 수정
//			String updateQuery = "UPDATE membertbl SET memberName = ? WHERE memberId = ?";
//			preparedStatement = connection.prepareStatement(updateQuery);
//			preparedStatement.setString(1, "이름변경1");
//			preparedStatement.setString(2, "boot1");
//			int updateCount = preparedStatement.executeUpdate();
//			System.out.println("updateCount : " + updateCount);
			System.out.println("-------------------------");
			
			// delete 데이터 삭제
			String deleteQuery = "DELETE FROM membertbl WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, "boot1");
			
			int deleteCount = preparedStatement.executeUpdate();
			System.out.println(deleteCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
