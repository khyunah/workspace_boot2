package ch11;

import java.util.ArrayList;

public class BookArrayList implements BookService {

	private ArrayList<Book> books = new ArrayList<Book>();

	public BookArrayList() {
		Book book1 = new Book(1, "흐르는강물처럼", "파울로코엘료");
		Book book2 = new Book(2, "플러터UI실전", "김근호");
		Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
		Book book4 = new Book(4, "리딩으로리드하라", "이지성");
		Book book5 = new Book(5, "사피엔스", "유발하라리");
		BookClient.serialBookNumber = 5;
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
	}

	/**
	 * Book 객체를 ArrayList 자료구조에 저장.
	 */
	@Override
	public void addBook(Book book) {
		System.out.println("저장합니다.");
		books.add(book);
		showAllBook();
	}

	/**
	 * Book의 title로 Book 존재여부 확인. 존재한다면, 매개변수로 넘어오는 Book 객체를 수정한다.
	 */
	@Override
	public void updateBook(String title, Book book) {
		System.out.println("수정합니다.");
		// 책 타이틀로 인덱스 번호를 찾아야 한다.
		int bookIndex = -1;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				// 책이 존재
				bookIndex = i;
			}
		}
		if (bookIndex == -1) {
			System.out.println(title + " 책이 존재 하지 않습니다.");
		} else {
			books.set(bookIndex, book);
		}
		showAllBook();
	}

	/**
	 * Book의 title로 객체를 삭제.
	 */
	@Override
	public void deleteBook(String title) {
		boolean deleteOk = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				books.remove(i);
				System.out.println("삭제합니다.");
				deleteOk = true;
			}
		}
		if (deleteOk) {
			System.out.println(title + " 책을 삭제 하였습니다.");
		} else {
			System.out.println(title + " 책이 존재하지 않습니다.");
		}
		showAllBook();
	}

	/**
	 * Book의 title에 해당하는 객체의 정보를 출력.
	 */
	@Override
	public void selectedByTitleBook(String title) {
		System.out.println("조회합니다.");
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i));
				return;
			}
		}
		System.out.println(title + " 제목으로 책을 찾을 수 없습니다.");
	}

	/**
	 * 모든 데이터를 출력.
	 */
	@Override
	public void showAllBook() {
		System.out.println("---------------현재 저장된 데이터 확인----------------");
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println("------------------------------------------------------");
	}
}
