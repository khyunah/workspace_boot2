package tenco.com.test_01.ch01;

public class Pororo extends ToyMaterial {

	@Override
	public void doMake() {
		System.out.println("뽀로로를 만듭니다.");
	}
	
	@Override
	public String toString() {
		return "뽀로로 만드는 재료 입니다.";
	}
}
