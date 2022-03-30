package ch09;

import java.util.ArrayList;

public class BookDaoMySql implements BookDao {

	ArrayList<Book> books = new ArrayList<>();

	@Override
	public void insertBook(Book book) {
		books.add(book);
		System.out.println("[ " + book.getTitle() + " ] 추가 완료");
		System.out.println(book);
	}

	@Override
	public void updateBook(int index, Book book) {
		books.set(index, book);
		System.out.println("[ " + book.getTitle() + " ] 변경 완료");
		System.out.println(book);
	}

	@Override
	public void deleteBook(int index) {
		Book book = books.remove(index);
		System.out.println(book.toString() + " 삭제 완료");
	}

	@Override
	public void readAllBook() {
		System.out.println("-----------------도서 목록----------------");
		for (Book book1 : books) {
			System.out.println(book1);
		}
		System.out.println("------------------------------------------");
	}

	@Override
	public void readBook(Book book) {
		System.out.println(book);
	}
}
