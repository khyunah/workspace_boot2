package ch08;

import java.util.ArrayList;

public class MainTest2 {

	public static void main(String[] args) {

		Book book1 = new Book(1, "흐르는강물처럼", "파울로코엘료");
		Book book2 = new Book(2, "플러터UI실전", "김근호");
		Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
		Book book4 = new Book(4, "리딩으로리드하라", "이지성");
		Book book5 = new Book(5, "사피엔스", "유발하라리");

		// 배열 //

		// 생성
		Book[] books = { book1, book2, book3, book4, book5 };

		// 리드
		System.out.println("----------배열 books 전체보기-------------");
		for (Book book : books) {
			System.out.println(book);
		}

		// 수정
		books[2] = book5;

		// 삭제
		books[0] = null;

		System.out.println();
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println();

		// ArrayList //

		// 생성
		ArrayList<Book> books2 = new ArrayList<>();
		books2.add(book1);
		books2.add(book2);
		books2.add(book3);
		books2.add(book4);
		books2.add(book5);

		// 리드
		for (Book book : books2) {
			System.out.println(book);
		}

		// 수정
		books2.set(2, book5);

		// 삭제
		books2.remove(0);

		System.out.println();
		for (Book book : books2) {
			System.out.println(book);
		}
		System.out.println();
	}
}
