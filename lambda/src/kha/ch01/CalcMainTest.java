package kha.ch01;

public class CalcMainTest {

	public static void main(String[] args) {
		
		// 익명 구형 객체 
		ICalc iCalc = new ICalc() {
			
			@Override
			public int calc(int x, int y) {
				return x + y;
			}
		};
		System.out.println(iCalc.calc(10, 20));
		
		// 람다식
		ICalc iCalcLambda = (x, y) -> { return x + y ;};
		System.out.println(iCalcLambda.calc(10, 20));
		
		// 람다식 축약형
		ICalc iCalcLambda_1 = (x, y) -> x + y;
		System.out.println(iCalcLambda_1.calc(10, 20));
	}
}
