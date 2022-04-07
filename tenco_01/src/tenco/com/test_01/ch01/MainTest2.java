package tenco.com.test_01.ch01;

public class MainTest2 {

	public static void main(String[] args) {

		Powder powder = new Powder();
		Plastic plastic = new Plastic();

		ThreeDPrinter1 dPrinter1 = new ThreeDPrinter1();
		dPrinter1.setMaterial(plastic);

		ThreeDPrinter2 dPrinter2 = new ThreeDPrinter2();
		dPrinter2.setMaterial(powder);

		// 모든 클래스의 최상위 클래스는 Object
		ThreeDPrinter3 dPrinter3 = new ThreeDPrinter3();
		dPrinter3.setMaterial(plastic);

		// dp1 재료꺼내기
		Plastic getPlastic = dPrinter1.getMaterial();
		System.out.println(getPlastic);

		// dp2 재료꺼내기
		Powder getPowder = dPrinter2.getMaterial();
		System.out.println(getPowder);

		// dp3 재료꺼내기
		Plastic tempPlastic = (Plastic) dPrinter3.getMaterial();
		System.out.println(tempPlastic);

		// 형변환을 해야하는 번거로움, 코드를 살펴서 확인해야하는 번거러움. ㅡ> 제네릭으로 해결
	}
}
