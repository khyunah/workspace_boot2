package ch10;

import java.util.Scanner;

public class BookClient {

	Scanner scanner = new Scanner(System.in);

	// 사용자한테 Book 객체를 생성하는 메소드 기능을 만든다
	public Book createBookObj() {
		System.out.println("Book객체를 생성해주세요.");
		String bookTitle = scanner.nextLine();
		String author = scanner.nextLine();
		Book book = new Book(bookTitle, author);
		return book;
	}

	// 책의 정보를 확인하는 기능
	public void showBookInfo(int index) {

	}

	// 저장되어 있는 책을 삭제하는 기능
	public void deleteBook(String title) {

	}

	// 수정하기
	public void updateBook(int index, Book book) {

	}

}
