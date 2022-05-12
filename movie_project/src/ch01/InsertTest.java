package ch01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertTest {

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public InsertTest() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
		preparedStatement = null;
	}

	public void insert() {
		String insertQuery = "INSERT INTO test11 VALUES('홍길동', 20, '부산')";

		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			int result = preparedStatement.executeUpdate();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InsertTest dataTest = new InsertTest();
		dataTest.insert();
	}
}
