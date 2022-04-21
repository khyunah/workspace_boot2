package file_io.ch02;

import java.io.FileInputStream;

/**
 * FileInputStream<br>
 * write(byte[] b, int off, int len) 사용해보기<br>
 * 
 * @author 김현아
 *
 */
public class MainTest97 {

	public static void main(String[] args) {
		FileInputStream fileInputStream;

		try {
			fileInputStream = new FileInputStream("input_kha2.txt");
			byte[] data = new byte[10];
			int i;
			while((i = fileInputStream.read(data, 1, 5)) != -1) {
				System.out.println((char)data[i]);
			}
			
			System.out.println("=====");
			
//			for (int j = 0; j < data.length; j++) {
//				System.out.println((char)data[j]);
//			}
		} catch (Exception e) {
			
		}

	}
}
