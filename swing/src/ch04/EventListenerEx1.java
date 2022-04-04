package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListenerEx1 extends JFrame implements ActionListener {

	JButton button1;

	public EventListenerEx1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("이벤트 리스너 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		add(button1);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
	}

	// 버튼이 일어나면 자동으로 메소드를 실행시켜주게 만들어 놓은 약속이다.
	// 콜백되어진다 ㅡ> 콜백 메서드
	private void addEventListener() {
		// 나 자신의 타입으로 등록하겠다.
		button1.addActionListener(this);
		// 1. 버튼1에 액션이 일어나면 this 나에게 알려줘 ㅡ> 이벤트를 등록했다.
		// 등록하다
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		// 2. actionPerformed 라는 메소드를 통해서 동작을 처리할거야 .
		System.out.println("버튼이 클릭되었습니다.");
	}
}