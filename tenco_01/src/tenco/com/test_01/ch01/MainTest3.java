package tenco.com.test_01.ch01;

public class MainTest3 {

	public static void main(String[] args) {
		// 재료
		Powder powder = new Powder();
		Plastic plastic = new Plastic();

		// 제네릭은 사용하는 시점에 지정된 자료형으로 완벽하게 컴파일 된다.
		GenericPinter<Powder> genericPinter1 = new GenericPinter<>();
		genericPinter1.setMaterial(powder);
		System.out.println(genericPinter1.getMaterial());

		GenericPinter<Plastic> genericPinter2 = new GenericPinter<Plastic>();
		genericPinter2.setMaterial(plastic);
		System.out.println(genericPinter2.getMaterial());

		GenericPinter<Water> genericPinter3 = new GenericPinter<>();
		genericPinter3.setMaterial(genericPinter3.getMaterial());
		
		// 
		GenericPrinter2<Powder> g2 = new GenericPrinter2<>();
		g2.setMaterial(powder);
		System.out.println(g2);
		
		// <T extends 클래스> 사용하기
		// 상위 클래스의 필요성
		// T 자료형의 범위를 제한할 수 있다. ㅡ> 제한하지 않으면 아무클래스나 올수 있다.
	}
}
