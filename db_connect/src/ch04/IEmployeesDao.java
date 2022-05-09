package ch04;

public interface IEmployeesDao {
	// 직급별 직원 조회하기 
	void selectTitle(String title);
	
	// 사원번호로 이름과 직급, 연봉 조회하기 
	void selectSalary(String emp_no);
	
	// 부서별 직원 조회 하기
	void selectDept(String dept_no);
	
	// 입사날짜별 직원 조회하기 
	void selectFromDate(String from_date);
	
	// 부서별 매니저 정보 조회하기
	void selectManagerInfo(String dept_no);
}
