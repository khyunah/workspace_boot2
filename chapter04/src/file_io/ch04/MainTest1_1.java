package file_io.ch04;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter<br>
 * 문자 단위 스트림
 * 
 * @author 김현아
 *
 */
public class MainTest1_1 {

	public static void main(String[] args) {

		try (FileWriter fw = new FileWriter("output_kha.txt")) {

			// write(int c)
			fw.write('A');
			fw.write('\n');

			// write(String str)
			fw.write("안녕하세요. FileWriter는 String 문자열도 가능해요!\n");

			// write(char[] cbuf)
			char[] data1 = new char[10];
			char character = 'A';
			for (int i = 0; i < data1.length; i++) {
				data1[i] = character;
				character++;
			}
			fw.write(data1);
			fw.write("\n");
			
			// write(String str, int off, int len)
			// off번 인덱스부터 len만큼 글자수
			fw.write("가나다라마바사아자차카타파하", 2, 7);
			fw.write("\n");
			
			// write(char[] cbuf, int off, int len)
			// off번 인덱스부터 len만큼 글자수
			fw.write(data1, 4, 6);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("파일 출력 완료");
	}
}
