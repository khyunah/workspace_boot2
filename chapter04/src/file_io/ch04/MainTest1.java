package file_io.ch04;

import java.io.FileWriter;

/**
 * 문자 단위 출력 기능<br>
 * 파일에 문자 쓰기<br>
 * 문자가 이어서 나오기 때문에 이스케이프 문자로 띄어쓰기, 줄바꿈 하기
 * 
 * @author ITPS
 *
 */
public class MainTest1 {

	public static void main(String[] args) {

		try (FileWriter fw = new FileWriter("write_1.txt")) {
			// 문자 하나 출력
			fw.write('A'); 
			
			// 배열
			char[] buf = { 'B', 'C', 'D', 'E', 'F', 'G' };
			fw.write(buf);
			
			// String
			fw.write("\t안녕하세요 ! 반갑습니다 !");
			
			fw.write(buf, 1, 2);
			
			fw.write("\t65");
			fw.write("/");
			
			// 숫자는 자동으로 부호화
			fw.write(65);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
