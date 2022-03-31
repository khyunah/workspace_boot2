package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private BorderLayout borderLayout;

	// super 생략한 것
	public BorderLayoutEx() {
		setTitle("테스트1");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 눌렀을때 메모리 까지 종료시키는

		initData();
		setInitLayout();
	}

	private void initData() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		borderLayout = new BorderLayout();
	}

	private void setInitLayout() {
		this.setLayout(borderLayout);
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.CENTER);
	}
}
