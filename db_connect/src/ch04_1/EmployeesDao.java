package ch04_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch03.ShopDto;

public class EmployeesDao implements IEmployeesDao {

	private DBClient client;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet rs;

	public EmployeesDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
		preparedStatement = null;
		rs = null;
	}

	// 직급별 직원 조회하기
	@Override
	public ArrayList<EmployeesTitleDto> selectTitle(String title) {
		String selectTitleQuery = 
				"SELECT *"
				+ "FROM employees AS e"
				+ "INNER JOIN titles AS t"
				+ "ON e.emp_no = t.emp_no"
				+ "WHERE t.title = ? "
				+ "AND t.to_date = '9999-01-01'";
		ArrayList<EmployeesTitleDto> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectTitleQuery);
			preparedStatement.setString(1, title);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesTitleDto dto = new EmployeesTitleDto(rs.getString("emp_no"), rs.getString("birth_date"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
						rs.getString("title"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 사원번호로 이름, 직급, 연봉 조회하기
	@Override
	public ArrayList<EmployeesSalaryDto> selectSalary(String emp_no) {
		String selectSalaryQuery = 
				"SELECT e.first_name, e.last_name, t.title, s.salary"
				+ "FROM employees AS e"
				+ "INNER JOIN salaries AS s"
				+ "ON e.emp_no = s.emp_no"
				+ "INNER JOIN titles AS t"
				+ "ON e.emp_no = t.emp_no"
				+ "WHERE e.emp_no = ? "
				+ "AND s.to_date = '9999-01-01'"
				+ "GROUP BY s.emp_no";
		ArrayList<EmployeesSalaryDto> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectSalaryQuery);
			preparedStatement.setString(1, emp_no);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesSalaryDto dto = new EmployeesSalaryDto(rs.getString("emp_no"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("title"), rs.getString("salary"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 부서별 직원 조회하기
	@Override
	public ArrayList<EmployeesDeptDto> selectDept(String dept_no) {
		String selectDeptQuery = 
				"SELECT *"
				+ "FROM employees AS e"
				+ "INNER JOIN dept_emp AS d"
				+ "ON e.emp_no = d.emp_no"
				+ "WHERE d.dept_no = ? ";
		ArrayList<EmployeesDeptDto> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectDeptQuery);
			preparedStatement.setString(1, dept_no);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesDeptDto dto = new EmployeesDeptDto(rs.getString("emp_no"), rs.getString("birth_date"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
						rs.getString("dept_no"), rs.getString("from_date"), rs.getString("to_date"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 입력한 입사날짜 이후의 입사 직원 조회하기
	@Override
	public ArrayList<EmployeesFromDateDto> selectFromDate(String from_date) {
		String selectFromDateQuery = 
				"SELECT *"
				+ "FROM employees AS e"
				+ "INNER JOIN dept_emp AS d"
				+ "ON e.emp_no = d.emp_no"
				+ "WHERE d.from_date > ? ";
		ArrayList<EmployeesFromDateDto> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectFromDateQuery);
			preparedStatement.setString(1, from_date);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesFromDateDto dto = new EmployeesFromDateDto(rs.getString("emp_no"), rs.getString("birth_date"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"),
						rs.getString("dept_no"), rs.getString("from_date"), rs.getString("to_date"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 부서별 현재 매니저 정보 조회하기
	@Override
	public ArrayList<EmployeesManagerInfoDto> selectManagerInfo(String dept_no) {
		String selectManagerInfoQuery = 
				"SELECT *"
				+ "FROM employees AS e"
				+ "INNER JOIN dept_manager AS d"
				+ "ON e.emp_no = d.emp_no"
				+ "WHERE d.dept_no = ? "
				+ "AND d.to_date = '9999-01-01'";
		ArrayList<EmployeesManagerInfoDto> result = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(selectManagerInfoQuery);
			preparedStatement.setString(1, dept_no);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				EmployeesManagerInfoDto dto = new EmployeesManagerInfoDto(rs.getString("emp_no"),
						rs.getString("birth_date"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("gender"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		EmployeesDao dao = new EmployeesDao();

		// 직급별 직원 조회 하기
//		ArrayList<EmployeesTitleDto> selectTitle = dao.selectTitle("Staff");
//		System.out.println(selectTitle);

		// 사원번호로 이름과 직급, 연봉 조회하기
//		ArrayList<EmployeesSalaryDto> selectSalary = dao.selectSalary("10005");
//		System.out.println(selectSalary);

		// 부서번호로 부서별 직원 정보 조회하기
//		ArrayList<EmployeesDeptDto> selectDept = dao.selectDept("d007");
//		System.out.println(selectDept);

		// 입력한 입사날짜 이후의 입사 직원 조회하기
//		ArrayList<EmployeesFromDateDto> selectFromDate = dao.selectFromDate("1995-01-01");
//		System.out.println(selectFromDate);

		// 부서별 현재 매니저 정보 조회하기
		ArrayList<EmployeesManagerInfoDto> selectManagerInfo = dao.selectManagerInfo("d005");
		System.out.println(selectManagerInfo);

	}
}
