package ch09;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		BookClient bookClient = new BookClient();
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			System.out.println("원하시는 메뉴를 선택해 주세요.");
			System.out.println("1. 추가  2. 수정  3. 조회  4. 삭제  5. 종료");
			int menuChoice = scanner.nextInt();
			if(menuChoice == 1) {
				bookClient.userInputInsert();
			} else if(menuChoice == 2) {
				bookClient.userInputUpdate();
			} else if(menuChoice == 3) {
				bookClient.userInputRead();
			} else if(menuChoice == 4) {
				bookClient.userInputDelete();
			} else if(menuChoice == 5) {
				System.out.println("종료합니다.");
				flag = false;
			} else {
				System.out.println("메뉴를 선택해 주세요");
			}
		}
		scanner.close();
	}
}
