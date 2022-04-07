package tenco.com.test_01.ch01;

public class ToyFactoryMainTest {

	public static void main(String[] args) {
		// 장난감공장의 뽀로로 만드는 곳
		ToyFactory<Pororo> pororoFactory = new ToyFactory<>();
		Pororo pororo = new Pororo();
		pororoFactory.setToyMaterial(pororo);
		System.out.println(pororoFactory);
		
		// 장난감공장의 로봇 만드는 곳
		ToyFactory<Robot> robotFactory = new ToyFactory<>();
		Robot robot = new Robot();
		robotFactory.setToyMaterial(robot);
		System.out.println(robotFactory);
	}
}
