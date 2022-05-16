package ch01;

// 람다 표현식
public class MainTest2 {

	public static void main(String[] args) {

		// 익명 구현 객체 
		ICalc iCalcAdd = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a + b + c;
			}
		};

		ICalc iCalcMinus = new ICalc() {

			@Override
			public double calc(int a, int b, int c) {
				return a - b - c;
			}
		};

		ICalc iCalcMulti = new ICalc() {
			
			@Override
			public double calc(int a, int b, int c) {
				return a * b * c;
			}
		};
		
		// 사용하는 방법
		System.out.println(iCalcAdd.calc(5, 5, 5));
		System.out.println(iCalcMinus.calc(5, 5, 5));
		System.out.println(iCalcMulti.calc(5, 5, 5));
		
		System.out.println("==================");
		
		// 람다 표현식으로 바꾸기 
		// 1. add
		ICalc iCalcAddLambda = (a, b, c) -> {return a + b + c;};
		// 2. minus
		ICalc iCalcMinusLambda = (a, b, c) -> {return a - b - c;};
		// 3. multi
		// 실행문이 한 문장인 경우에만 중괄호와 return 키워드를 생략 할 수 있다. 
		ICalc iCalcMultiLambda = (a, b, c) -> a * b * c;;
		System.out.println(iCalcAddLambda.calc(5, 5, 5));
		System.out.println(iCalcMinusLambda.calc(5, 5, 5));
		System.out.println(iCalcMultiLambda.calc(5, 5, 5));
	}
}
