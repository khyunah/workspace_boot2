package ch03;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1. MyComponent를 화면에 띄우세요
		// 2. textField에 안녕하세요 라는 글자를 코드로 셋팅해주세요
		MyComponents components = new MyComponents();
		System.out.println("글자를 입력하세요");
		String userInput = scanner.nextLine();
		components.textField.setText(userInput);
	}
}
