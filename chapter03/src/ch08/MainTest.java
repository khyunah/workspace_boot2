package ch08;

import java.util.ArrayList;

// ArrayList 
// CRUD
public class MainTest {

	public static void main(String[] args) {

		Book book1 = new Book(1, "흐르는강물처럼", "파울로코엘료");
		Book book2 = new Book(2, "플러터UI실전", "김근호");
		Book book3 = new Book(3, "무궁화꽃이피었습니다", "김진명");
		Book book4 = new Book(4, "리딩으로리드하라", "이지성");
		Book book5 = new Book(5, "사피엔스", "유발하라리");

		// how, why 고민하기

		// 사용방법 ㅡ> 데이터타입 미리 지정
		ArrayList<Book> cart = new ArrayList<>();

		// 데이터를 추가하는 방법 add()
		cart.add(book1);
		cart.add(book2);
		cart.add(book3);

		// 데이터를 꺼내는 방법 get()
		System.out.println(cart.get(0).getTitle());
		System.out.println(cart.get(1).getTitle());
		System.out.println(cart.get(2).getTitle());

		System.out.println(cart.get(0));
		System.out.println(cart.get(1));
		System.out.println(cart.get(2));
		System.out.println();

		for (Book book : cart) {
			System.out.println(book);
		}
		System.out.println();

		// 데이터를 삭제하는 방법 remove()
		cart.remove(0);

		// 사이즈 출력
		System.out.println(cart.size());
		System.out.println(cart.get(0));
		System.out.println();

		// 수정하기
		cart.set(0, book5);

		System.out.println(cart.size());
		System.out.println(cart.isEmpty());

		for (Book book : cart) {
			System.out.println(book);
		}

		// 데이터를 전부 삭제하고 싶다면
		cart.removeAll(cart);
		System.out.println("--------");
		for (Book book : cart) {
			System.out.println(book);
		}
	}
}
