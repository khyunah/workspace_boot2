package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * ch02의 MainTest1클래스 dto
 * @author ITPS
 *
 */
@Getter
@Setter
@ToString
public class Test {
	private String 이름;
	private int 나이;
	private String 직업;
	private String 취미;
	private boolean 결혼여부;
}
