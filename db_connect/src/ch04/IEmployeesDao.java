package ch04;

import java.util.ArrayList;

public interface IEmployeesDao {
	// 직급별 직원 조회하기 
	ArrayList<EmployeesDto> selectTitle(String title);
	
	// 사원번호로 이름과 직급, 연봉 조회하기 
	ArrayList<EmployeesDto> selectSalary(String emp_no);
	
	// 부서별 직원 조회 하기
	ArrayList<EmployeesDto> selectDept(String dept_no);
	
	// 입력한 입사날짜 이후의 입사 직원 조회하기
	ArrayList<EmployeesDto> selectFromDate(String from_date);
	
	// 부서별 현재 매니저 정보 조회하기
	ArrayList<EmployeesDto> selectManagerInfo(String dept_no);
}
