package file_io.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 입력 스트림, 파일에서 한 바이트씩 데이터를 읽기
 * while문 사용해서 출력하기
 * 
 * try-with-resources : 1.7이상 부터 가능 / try( ) 오토클로즈 제공.
 * 
 * @author ITPS
 * 
 */
public class MainTest2 {

	public static void main(String[] args) {
		System.out.println("시작 파일에서 데이터를 읽어서 화면에 출력해 주세요.");

		FileInputStream fis = null;
		int i;

		try {
			fis = new FileInputStream("boot_a.txt");
			
			// 와일문 조건식 안에서 메소드가 호출이 되기 때문에 변수화를 해서 처리해 주어야 한다.
			while ((i = fis.read()) != -1) {
				System.out.println((char) i);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("끝");
	}
}
