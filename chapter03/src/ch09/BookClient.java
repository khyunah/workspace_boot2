package ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class BookClient {

	// 스캐너 사용
	Scanner scanner = new Scanner(System.in);
	BookDaoMySql bookDaoMySql = new BookDaoMySql();
	Book book;
	ArrayList<Book> books;
	String title;
	String author;

	// 생성
	public void userInputInsert() {
		System.out.println("책을 등록해 주세요.");
		System.out.println("도서명 : ");
		title = scanner.nextLine();
		System.out.println("작가 : ");
		author = scanner.nextLine();
		Book newBook = new Book(title, author);
		bookDaoMySql.insertBook(newBook);
	}

	// 수정
	public void userInputUpdate() {
		System.out.println("수정할 책 순서를 입력하세요.");
		int index = scanner.nextInt() - 1;
		scanner.nextLine();
		book = bookDaoMySql.books.get(index);
		System.out.println("도서명을 수정해 주세요.");
		title = scanner.nextLine();
		book.setTitle(title);
		System.out.println("작가이름을 수정해 주세요.");
		author = scanner.nextLine();
		book.setAuthor(author);
		bookDaoMySql.updateBook(index, book);
	}

	// 삭제
	public void userInputDelete() {
		System.out.println("삭제할 책순서를 입력하세요.");
		int index = scanner.nextInt() - 1;
		bookDaoMySql.deleteBook(index);
	}

	// 출력
	public void userInputRead() {
		System.out.println("1. 전체 목록 조회  2. 도서명 검색");
		int choice = scanner.nextInt();
		scanner.nextLine();
		if (choice == 1) {
			bookDaoMySql.readAllBook();
		} else if (choice == 2) {
			System.out.println("검색할 도서명을 입력하세요.");
			title = scanner.nextLine();
			Book bookCheck = null;
			for (int i = 0; i < bookDaoMySql.books.size(); i++) {
				if(title.equals(bookDaoMySql.books.get(i).getTitle())) {
					bookCheck = bookDaoMySql.books.get(i);
					bookDaoMySql.readBook(bookCheck);
				}
			}
			if(bookCheck == null) {
				System.out.println("입력하신 도서명으로 조회가 되지 않습니다.");
			}
		} else {
			System.out.println("잘못 입력 했습니다.");
		}
	}

}
