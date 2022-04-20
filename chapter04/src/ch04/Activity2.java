package ch04;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 호출 하는 객체
public class Activity2 extends BaseActivity {

	CallBackCheckPosition callBackCheckPosition;

	public void setCallBackCheckPosition(CallBackCheckPosition callBackCheckPosition) {
		this.callBackCheckPosition = callBackCheckPosition;
	}

	public Activity2(String name) {
		super(name);
		addEventListener();
	}

	private void addEventListener() {

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callBackCheckPosition.checkPosition(x, y);
			}
		});
	}
}
