package file_io.ch01;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTest2 {

	public static PrintStream out;
	public static InputStream in;

	public static void main(String[] args) {

		// 표준 출력 스트림 ( 모니터 )
		// System.out
		System.out.println("출력 스트림 모니터");
		
		// 표준 입력 스트림 ( 키보드 )
		// System.in
		try {
			int k = System.in.read();
			System.out.println("K : " + k);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
