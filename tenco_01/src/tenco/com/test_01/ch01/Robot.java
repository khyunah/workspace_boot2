package tenco.com.test_01.ch01;

public class Robot extends ToyMaterial {

	@Override
	public void doMake() {
		System.out.println("로봇을 만듭니다");
	}
	
	@Override
	public String toString() {
		return "로봇";
	}
}
