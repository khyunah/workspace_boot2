package ch03;

// 인터페이스 
public interface RemoteController {

	// 구현된 것이 아무것도 없는 밑그림만 있는 기본 설계도
	// 멤버변수, 일반메서드를 가질 수 없고, 오직 추상 메서드와 상수만을 멤버로 가질 수 있다.
	
	// 추상 클래스보다 추상화가 더 높다.
	
	// 인터페이스는 강제성이 있는 약속이다. / 표준, 규칙이다
	
	// 사용방법 
	// class 키워드 대신에 interface라는 키워드를 사용한다.
	// 멤버 접근제어 지시자는 public이나 default 사용가능.
	
	// 원형
	public static final int SERIAL_NUMBER = 1000;
	public abstract void turnOn();
	
	// 축약형 
	int SERIAL_NUMBER2 = 100;		// static final 생략
	void turnOff();					// abstract 생략
}
