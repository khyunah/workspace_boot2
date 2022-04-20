package ch05;

public class MainTest {

	public static void main(String[] args) {

		Activity1 activity1 = new Activity1("콜백 받는 객체");
		Activity2 activity2 = new Activity2("호출 하는 객체");

		// 위에 생성만 하면 둘이 연결이 되어 있지 않아서 호출하는 부분의 메소드의 주소값을 몰라
		// 널포인트 예외가 난다.

		// 연결 해주기
		activity2.setCallBackCheckPosition(activity1.callBackCheckPosition);
	}
}
