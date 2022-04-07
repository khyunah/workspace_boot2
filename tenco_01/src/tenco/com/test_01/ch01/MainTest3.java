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
	}
}
