package ch02;

public class MaxMainTest {

	public static void main(String[] args) {
		IMax iMaxInt = (x, y) -> x > y ? x : y;
		System.out.println(iMaxInt.maxInt(200, 100));
	}
}
