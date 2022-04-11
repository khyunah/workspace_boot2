package tenco.com.slider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter						// 게터 메서드
@Setter						// 세터 메서드
@AllArgsConstructor			// 모든 멤버변수를 넣어 만든 생성자
@RequiredArgsConstructor	// 생성자에 포함할 변수를 @NonNull붙여줌
@NoArgsConstructor			// 기본 생성자
@ToString					// 모든 멤버변수를 넣은 ToString()이 재정의
public class Student2 {

	@NonNull
	private String name;
	@ToString.Exclude		// 이렇게 표시하면 이것 빼고 ToString 재정의 
	private String address;
	
	private int age;
	
	private int birth;
}
