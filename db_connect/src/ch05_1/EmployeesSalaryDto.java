package ch05_1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeesSalaryDto {

	private String emp_no;
	private String first_name;
	private String last_name;
	private String title;
	private String salary;
	
	@Override
	public String toString() {
		return "EmployeesSalary [emp_no=" + emp_no + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", title=" + title + ", salary=" + salary + "]\n";
	}
	
}
