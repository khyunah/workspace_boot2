package ch01;

// 1. 인터페이스를 선언한다
/**
 * 
 * @author 김현아
 * 콜백 메서드 만드는 연습
 *
 */
public interface ICallBackBtnAction {

	// +버튼 메소드
	public abstract void clickedAddBtn();
	
	// -버튼 메서드 
	public abstract void clickedMinusBtn();
	
	// 값을 변경하는 메소드
	public abstract void clicked100Btn(int result);
}
