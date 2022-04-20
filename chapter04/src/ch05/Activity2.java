package ch05;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Activity2 extends BaseActivity {
	
	CallBackCheckPosition callBackCheckPosition;

	// 콜백 세터 메소드
	public void setCallBackCheckPosition(CallBackCheckPosition callBackCheckPosition) {
		this.callBackCheckPosition = callBackCheckPosition;
	}

	public Activity2(String name) {
		super(name);
		initEventListener();
	}

	private void initEventListener() {
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println(name + "가 호출을 하였습니다. x : " + x + " / y : " + y);
				callBackCheckPosition.checkClicked(x, y);
			}
		});
		
	}

}
