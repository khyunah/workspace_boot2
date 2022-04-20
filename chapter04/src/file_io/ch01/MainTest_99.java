package file_io.ch01;

import java.io.IOException;
import java.io.InputStream;

public class MainTest_99 {

	public static void main(String[] args) {

		// 출력 스트림
		// System.out.println();

		// 한 바이트씩 읽는 read()로 여러 바이트 읽기
		System.out.println("알파벳 쓰고 엔터 누르세요");
		try {
			InputStream in = System.in;
			int i;
			while ((i = in.read()) != '\n') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
