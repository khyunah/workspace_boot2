package ch11;

import java.util.Scanner;

// 문자열 공백 제거 하는 방법
public class MainTest2 {

	public static void main(String[] args) {
		
		System.out.println(removeBlankString("          공백        제거                확인 111"));

//		String str1 = "              문자열        공백 제거   ";
//		System.out.println(str1);
//		// 앞뒤 공백 제거 trim()
//		String removeBlank = str1.trim();
//		System.out.println(removeBlank);
//
//		// 문자열의 모든 공백을 제거할 수 있게 응용하여 사용 replace()
//		// " "를 ""로 바꾸겠다.
//		String str2 = removeBlank.replace(" ", "");
//		System.out.println(str2);

		BookClient bookClient = new BookClient();

		// 사용자가 입력한거 저장할 기능클래스
		BookArrayList bookArrayList = new BookArrayList();

		// 스캐너는 여기서만 사용
		Scanner scanner = new Scanner(System.in);

		// do while
		String selectedMenu = "";
		//
		do {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("1. 책 생성 2. 책 조회 3. 책 삭제 4. 책 전체 조회 5. 책 수정 0. 프로그램 종료 ");
			System.out.println("-----------------------------------------------------------------------------");
			selectedMenu = scanner.nextLine();
			if (selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
			} else if (selectedMenu.equals("1")) {
				System.out.println("책 제목을 입력하세요.");
				// Book 객체 생성
				String title = removeBlankString(scanner.nextLine());
				System.out.println("작가의 이름을 입력하세요.");
				String author = removeBlankString(scanner.nextLine());
				Book book = bookClient.createBook(title, author);
				bookArrayList.addBook(book);
			} else if (selectedMenu.equals("2")) {
				System.out.println("책 제목을 입력해 주세요");
				String title = removeBlankString(scanner.nextLine());
				bookArrayList.selectedByTitleBook(title);
			} else if (selectedMenu.equals("3")) {
				System.out.println("삭제 할 책 제목을 입력해 주세요.");
				String title = removeBlankString(scanner.nextLine());
				bookArrayList.deleteBook(title);
			} else if (selectedMenu.equals("4")) {
				System.out.println("저장되어 있는 책 목록 조회");
				bookArrayList.showAllBook();
			} else if (selectedMenu.equals("5")) {
				System.out.println("수정하려는 책 제목을 입력해 주세요.");
				String savedTitle = removeBlankString(scanner.nextLine());
				System.out.println("새로운 책 제목을 입력하세요.");
				String title = removeBlankString(scanner.nextLine());
				System.out.println("새로운 작가 이름을 입력하세요.");
				String author = removeBlankString(scanner.nextLine());
				Book book = bookClient.createBook(title, author);
				bookArrayList.updateBook(savedTitle, book);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		} while (!(selectedMenu.equals("0")));
	} // end of main

	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
	}
} // end of class
