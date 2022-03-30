package ch06;

// Object ㅡ> 오버라이드, equals 이해하기
// 매개변수로 참조값을 받아서 설계
public class MainTest {

	public static void main(String[] args) {

		Book book1 = new Book(1, "흐르는 강물처럼");
		Book book2 = new Book(2, "사피엔스");
		Book book3 = new Book(3, "흐르는 강물처럼");
		Book book4 = new Book(4, "무궁화 꽃이 피었습니다.");
		Student student = new Student();

		System.out.println(book1);
		System.out.println(book2);

//		if (book1.equals(book3)) {
//			System.out.println("같은 책 입니다.");
//		} else {
//			System.out.println("다른 책 입니다.");
//		}

//		if (book1.equals(student)) {
//			System.out.println("true 리턴");
//		} else {
//			System.out.println("false 리턴");
//		}
		
		if(book1.idSameBook(book3)) {
			System.out.println("같은 책입니다.");
		} else { 
			System.out.println("다른 책입니다.");
		}
	}
}
