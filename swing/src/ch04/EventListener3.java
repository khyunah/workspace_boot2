package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener3 extends JFrame {

	private JButton button1;
	private JButton button2;

	public EventListener3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("익명 구현 객체의 이해");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		add(button1);
		add(button2);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
	}

	private void addEventListener() {
		// 인터페이스나 추상객체를 구현받은것 
		// 익명 구현 객체 사용법
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭됨.");
			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2가 클릭됨.");
			}
		});
	}

	public static void main(String[] args) {
		// 이름이 없는 클래스
		// 익명 클래스
		new EventListener3();
	}
}
