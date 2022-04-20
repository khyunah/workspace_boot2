package ch04;

import java.awt.Color;

// 콜백 받는 객체
public class Activity1 extends BaseActivity {

	// 변수 선언, 초기화 ( 콜백 메서드 )
	CallBackCheckPosition callback = new CallBackCheckPosition() {

		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "가 콜백을 받았습니다. " + x);
			System.out.println(name + "가 콜백을 받았습니다. " + y);
		}
	};

	public Activity1(String name) {
		super(name);
	}

	@Override // 어노테이션 ㅡ> 주석의 일종이지만 컴파일러가 무시하지 않음. ㅡ> 컴파일러가 부모 클래스에 가서 메소드를 확인해줌
	protected void initData() {
		super.initData();
	}

	@Override
	protected void setInintLayout() {
		super.setInintLayout();
		panel.setBackground(Color.BLUE);
	}
}
