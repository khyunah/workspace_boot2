package ch01;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 콜백 받는 객체 ( 응답자 )
// ICallBackBtnAction을 구현해서 정의하면 된다. 
public class MainActivity extends JFrame implements ICallBackBtnAction {

	int count;
	JLabel label;

	public MainActivity() {
		count = 0;
		label = new JLabel("count : " + count);

		setSize(300, 300);
		setLayout(new FlowLayout());
		setVisible(true);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// SubActivity 클래스와 연결을 하기 위해 주소값을 넣어준다.
		new SubActivity(this);
	}

	// +버튼의 동작을 받는 콜백 메소드 정의
	@Override
	public void clickedAddBtn() {
		System.out.println("더하기 버튼에 콜백 받았습니다.");
		count++;
		label.setText("count : " + count);
	}

	// -버튼의 동작을 받는 콜백 메소드 정의
	@Override
	public void clickedMinusBtn() {
		System.out.println("마이너스 버튼에 콜백 받았습니다.");
		count--;
		label.setText("count : " + count);
	}

	// 값을 전달 받는 콜백 메서드 정의
	@Override
	public void clicked100Btn(int result) {
		System.out.println("값이 100으로 변경되었습니다.");
		count = result;
		label.setText("count : " + count);
	}
}
