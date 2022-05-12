package ch01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTest {

	private DBClient dbClient;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet rs;

	public SelectTest() {
		dbClient = DBClient.getInstance();
		connection = dbClient.getConnection();
		preparedStatement = null;
		rs = null;
	}

	public ArrayList<EmployeesDto> select() {
		String selectQuery = "SELECT * FROM employees WHERE emp_no = 10024";

		ArrayList<EmployeesDto> result = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesDto dto = new EmployeesDto(rs.getString("emp_no"), rs.getString("birth_date"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		SelectTest dataTest = new SelectTest();
		ArrayList<EmployeesDto> result = dataTest.select();
		System.out.println(result);
		System.out.println(result.get(0).getEmp_no());
		System.out.println(result.get(0).getFirst_name());
		System.out.println(result.get(0).getLast_name());
		System.out.println(result.get(0).getBirth_date());
		System.out.println(result.get(0).getGender());
	}
}
