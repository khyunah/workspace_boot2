package tenco.com.test_02;

public class WrapperClass2 {

	public static void main(String[] args) {

		String str1 = "100gfsdfg";
		String str2 = "100.5";
		String str3 = "true";

		//
		try {
			int i = Integer.parseInt(str1);
			System.out.println("문자열 int값 변환 : " + i);
		} catch (Exception e) {
			System.out.println("int로 변환할 수 없습니다.");
		}

		try {
			double d = Double.parseDouble(str2);
			System.out.println("문자열 double값 변환 : " + d);
		} catch (Exception e) {
			System.out.println("double로 변환할 수 없습니다.");
		}

		try {
			boolean bool = Boolean.parseBoolean(str3);
			System.out.println("문자열 boolean값 변환 : " + bool);
		} catch (Exception e) {
			System.out.println("boolean으로 변환할 수 없습니다.");
		}
	}
}
