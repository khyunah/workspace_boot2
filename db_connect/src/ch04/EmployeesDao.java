package ch04;

import java.sql.Connection;

public class EmployeesDao implements IEmployeesDao {

	private DBClient client;
	private Connection connection;
	
	public EmployeesDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}

	// 직급별 직원 조회하기 
	@Override
	public void selectTitle(String title) {
		String selectTitleQuery = "select *\r\n"
				+ "from employees as e\r\n"
				+ "inner join titles as t\r\n"
				+ "on e.emp_no = t.emp_no\r\n"
				+ "where t.title = ? ";
		
	}

	@Override
	public void selectSalary(String emp_no) {
		
	}

	@Override
	public void selectDept(String dept_no) {
		
	}

	@Override
	public void selectFromDate(String from_date) {
		
	}

	@Override
	public void selectManagerInfo(String dept_no) {
		
	}

}
