package file_io.ch01;

import java.io.IOException;

public class MainTest2 {

	public static void main(String[] args) {
		System.out.println("알파벳 여러개 쓰고 엔터");
		int i;
		
		try {
			// 알파벳 여러개를 쓰고 화면에 출력 할 수 있도록 코드 변경하기 
//			i = System.in.read();
//			System.out.println(i);
			
			// 엔터를 뜻하는 이스케이프 문자 '\n'이 아닐때는 계속 반복.
			while( ( i = System.in.read() ) != '\n' ) {
				System.out.print("i : " + i + " ");
				System.out.print((char)i);
				System.out.print("\t");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
