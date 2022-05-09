package ch01_변수;

public class VariableTest {
	
	// 전역변수 = 멤버변수 = 필드
	String str1 = "안녕하세요.";
	double double1 = 10.2;
	int int1 = 10;
	
	
	public void method1(String str) {  // 매개변수
		// 지역변수 
		String str2 = "홍길동 입니다.";
		int int2 = 5;
	}

	public static void main(String[] args) {
		// 지역변수 
		String str3 = "hello";
		int int3 = 1;
		
		
		for (int i = 0; i < 20; i++) {
			// 지역변수
			String str4 = "hi";
		}
		
		// 참조변수 = 레퍼런스변수
		VariableTest test = new VariableTest();
		
		System.out.println("안녕하세요\rㅋㅋㅋㅋ\r");
		System.out.println("안녕하세요\nㅋㅋㅋㅋ\n");
	}
}
