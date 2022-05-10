package ch04_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto {
	@NonNull
	private String emp_no;
	@NonNull
	private String birth_date;
	@NonNull
	private String first_name;
	@NonNull
	private String last_name;
	@NonNull
	private String gender;
	
	private String dept_no;
	private String dept_name;
	private String title;
	private String salary;
	private String from_date;
	private String to_date;
	
	@Override
	public String toString() {
		return "EmployeesDto [" + 
				((emp_no != null) ? "emp_no=" + emp_no + " " : "") +
				((dept_no != null) ? "dept_no=" + dept_no + " " : "") +
				((dept_name != null) ? "dept_name=" + dept_name + " " : "") +
				((birth_date != null) ? "birth_date=" + birth_date + " " : "") +
				((first_name != null) ? "first_name=" + first_name + " " : "") +
				((last_name != null) ? "last_name=" + last_name + " " : "") +
				((gender != null) ? "gender=" + gender + " " : "") +
				((title != null) ? "title=" + title + " " : "") +
				((salary != null) ? "salary=" + salary + " " : "") +
				((from_date != null) ? "from_date=" + from_date + " " : "") +
				((to_date != null) ? "to_date=" + to_date : "") +
				"]\n";
	}
}
