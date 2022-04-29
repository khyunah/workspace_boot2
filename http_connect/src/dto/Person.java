package dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
// 매개변수 다 들어가는 생성자 
@RequiredArgsConstructor
@ToString
public class Person {
	private String name;
	private int age;
	private String address;
}
