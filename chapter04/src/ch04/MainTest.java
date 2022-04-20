package ch04;

/**
 * 메소드 방식으로 콜백
 * 
 * @author ITPS
 *
 */
public class MainTest {

	public static void main(String[] args) {
		Activity1 activity1 = new Activity1("화면1");
		Activity2 activity2 = new Activity2("화면2");
		
		// 1. 메서드를 통해서 콜백 연결하기 
		// activity2.setCallBackCheckPosition(activity1);
		// ㅡ> 멤버변수로 콜백 메서드를 만들어 놨기때문에 연결 불가
		
		// 2. 콜백 메서드로 연결 해주기
		activity2.setCallBackCheckPosition(activity1.callback);
	}
}
