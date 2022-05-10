package ch05_1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeesFromDateDto {

	private String emp_no;
	private String birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private String dept_no;
	private String from_date;
	private String to_date;
	
	@Override
	public String toString() {
		return "EmployeesFromDateDto [emp_no=" + emp_no + ", birth_date=" + birth_date + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", gender=" + gender + ", dept_no=" + dept_no + ", from_date="
				+ from_date + ", to_date=" + to_date + "]\n";
	}
}
