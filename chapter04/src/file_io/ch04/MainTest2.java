package file_io.ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter를 이용한 파일에 문자 쓰기. <br>
 * 자기공간이 다 채워지면 자동으로 전달한다. <br>
 * 
 * @author 김현아
 *
 */
public class MainTest2 {

	public static void main(String[] args) {

		String text = "File Writer Test";
		String fileName = "result.txt";

		try {
			// Buffer를 쓰게 되면 가변배열에 공간이 다채워지기 전에 보내지 않기때문에
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(text);
			
			// flush() 사용해줘야함
			bw.flush();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
