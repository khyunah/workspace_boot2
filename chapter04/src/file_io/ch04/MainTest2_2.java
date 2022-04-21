package file_io.ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter<br>
 * 저장공간이 채워지면 자동으로 출력한다.<br>
 * 또 다른 말로는 저장공간이 채워지지 않으면 자동으로 출력 되지 않는다.<br>
 * flush()를 이용하여 보내줘야 한다.<br>
 * 
 * @author 김현아
 *
 */
public class MainTest2_2 {

	public static void main(String[] args) {
		
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter("output_kha2.txt"));
//			
//			bw.write("BufferedWriter를 이용한 파일 출력 테스트 하는 중.\n");
//			bw.write('C');
//			
//			bw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("output_kha2.txt"))) {
			bw.write("BufferedWriter를 이용한 파일 출력 테스트 하는 중..\n");
			bw.write('C');
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
