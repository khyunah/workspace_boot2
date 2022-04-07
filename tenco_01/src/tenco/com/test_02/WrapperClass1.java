package tenco.com.test_02;

public class WrapperClass1 {

	public static void main(String[] args) {

		Integer itegerNum1 = new Integer(100);	// 박싱
		Integer integerNum2 = 200;				// 자동 박싱 new Integer(200) 생략
		Number number1 = 10; 					// 자동 박싱 new Integer(10) 생략
		
		int intNum1 = itegerNum1.intValue();	// 언박싱
		int intNum2 = integerNum2;				// 자동 언박싱 num1.intValue() 생략
	}
}
