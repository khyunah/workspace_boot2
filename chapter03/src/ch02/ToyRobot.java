package ch02;
// 기능은 같지만 같은부류가 아니라 상속 받기엔 좀 그렇다 이럴때 인터페이스 ch03참고
public class ToyRobot {

	String name;
	
	public ToyRobot() {
		this.name = "건담로봇";
	}
	
	public void turnOn() {
		System.out.println("장난감 로봇을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("장난감 로봇을 끕니다.");
	}
}
