package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener2 extends JFrame implements ActionListener {

	private JButton button1;
	private JButton button2;

	public EventListener2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("이벤트 리스너 연습2");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		add(button1);
		add(button2);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 방법 1
//		System.out.println(button1.getText());
//		// 버튼1이 눌러졌는지 버튼2가 눌러졌는지 구분해서 화면에 출력하세요
//		if(e.getActionCommand().equals(button1.getText())) {
//			System.out.println("버튼 1이 클릭");
//		} else {
//			System.out.println("버튼 2가 클릭");
//		}

		// 방법 2
//		Object obj = e.getSource();
		// 하지만 우리는 버튼 타입인것을 알고 있다.
		JButton selectedBtn = (JButton) e.getSource();
		if (selectedBtn.getText().equals(this.button1.getText())) {
			System.out.println(button1.getText() + "가 클릭되었습니다.");
		} else {
			System.out.println(button2.getText() + "가 클릭되었습니다.");
		}
	}
}
