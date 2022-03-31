package ch11;

import java.util.Scanner;

public class UserInputScanner {

	Scanner scanner = new Scanner(System.in);
	BookClient bookClient = new BookClient();
	BookArray bookArray;
	String title;
	String savedTitle;
	String author;

	/**
	 * 책을 생성하기 위해 사용자에게 입력받는다.
	 * 입력받은 정보는 Book객체로 생성을 하고 Book타입으로 리턴
	 * @return Book
	 */
	public Book userInputCreateBook() {
		System.out.println("책을 생성합니다.");
		System.out.println("도서명 : ");
		title = scanner.nextLine();
		System.out.println("작가 : ");
		author = scanner.nextLine();
		return bookClient.createBook(title, author);

	}
	
	public Book userInputUpdateBook() {
		System.out.println("수정할 책의 제목을 입력해 주세요.");
		savedTitle = scanner.nextLine();
		for (int i = 0; i < bookArray.books.length; i++) {
			if(savedTitle.equals(bookArray.books[i].getTitle())) {
				System.out.println("수정할 정보를 입력해 주세요.");
				System.out.println("도서명 : ");
				title = scanner.nextLine();
				System.out.println("작가 : ");
				author = scanner.nextLine();
				return bookClient.createBook(title, author);
			}
			
		}
		return null;
	}
}
