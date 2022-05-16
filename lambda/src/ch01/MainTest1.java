package ch01;

// 람다 표현식
public class MainTest1 {

	public static void main(String[] args) {

		// 익명 구현 객체
		IAdd iAdd = new IAdd() {

			@Override
			public int add(int x, int y) {
				return x + y;
			}
		};

		// 사용하는 방법
		System.out.println(iAdd.add(10, 20));

		System.out.println("==========================");

		// 람다식으로 변경
		// 타입 추론이 가능하기에 람다식을 사용할수 있는 것.
		IAdd iAddLambda = (x, y) -> {
			return x + y;
		};

		// 사용하는 방법
		System.out.println(iAddLambda.add(10, 20));

		// 결론
		// 기본 OOP문법 : 인터페이스를 선언하여 익명 구현 객체로 만들어 사용
		// 람다 표현식 : 인터페이를 선언하여 람다 표현식으로 만들어 사용
	}
}
