package ch03;

public class StringConcatImplTest {

	public static void main(String[] args) {

		// 우리가 알고 있던 OOP방식
		String s1 = "Hello";
		String s2 = "Java";
		
		StringConcatImpl impl = new StringConcatImpl();
		impl.makeString(s1, s2);

		// 익명 구현 객체
		IStringConcat iStringConcat = new IStringConcat() {
			
			@Override
			public void makeString(String s1, String s2) {
				System.out.println("[[[" + s1 + " : " + s2 + "]]]");
			}
		};
		
		// 클래스 설계없이 바로 사용가능
		
		// 람다 표현식으로 설계해서 사용하기
		IStringConcat iStringConcatLambda = (str1, str2) -> System.out.println("+++" + s1 + " : " + s2 + "+++");
		iStringConcatLambda.makeString("안녕", "람다");
		
		// 러너블 익명 구현 객체를 
		// 람다식으로 표현한 것.
		new Thread(() -> {});
	}
}
