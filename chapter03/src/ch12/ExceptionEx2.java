package ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx2 {

	public static void main(String[] args) {

		FileInputStream fis;
		// 파일 있는 확인 하는 것은 프로젝트 안에 존재해야함 "b.txt"
		// 프로젝트안의 폴더안에 존재한다면 cd명령어 써줘야함

		try {
			// 예외가 발생할 수 있는 코드
			fis = new FileInputStream("a.txt");
			// return;
		} catch (FileNotFoundException e) {
			// 예외를 어떻게 처리해야 하는지 작성하는 부분
			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		} finally {
			// finally는 코드의 제어권을 가진 return키워드를 만나도
			// 실행된다.
			System.out.println("반드시 실행되는 영역입니다.");
		}
		System.out.println("코드가 실행이 되나요?");
	}
}
