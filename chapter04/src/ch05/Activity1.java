package ch05;

public class Activity1 extends BaseActivity {
	
	CallBackCheckPosition callBackCheckPosition = new CallBackCheckPosition() {
		
		@Override
		public void checkClicked(int x, int y) {
			System.out.println(name + "가 콜백 받았습니다. x : " + x + " / y : " + y);
		}
	};

	public Activity1(String name) {
		super(name);
	}
}
